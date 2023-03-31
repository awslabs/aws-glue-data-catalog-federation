/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.amazonaws.glue.federation.connector.operation;

import com.amazonaws.glue.federation.connector.provider.DefaultHiveIdProvider;
import com.amazonaws.glue.federation.connector.provider.HiveIdProvider;
import com.amazonaws.glue.federation.connector.search.Filter;
import com.amazonaws.glue.federation.connector.search.SearchTextHandler;
import com.amazonaws.glue.federation.connector.search.TableFilterHandler;
import com.amazonaws.glue.federation.connector.search.TableHeaderFilterHandler;
import com.amazonaws.glue.federation.connector.search.TableHeaderSortHandler;
import com.amazonaws.glue.federation.connector.search.TableSortHandler;
import com.amazonaws.glue.federation.connector.search.SearchField;
import com.amazonaws.glue.federation.connector.search.SortCondition;
import com.amazonaws.glue.federation.connector.search.TableHeader;
import com.amazonaws.glue.federation.connector.util.ExceptionTranslator;
import com.amazonaws.glue.federation.connector.util.HiveToGlueConverter;
import com.amazonaws.glue.federation.connector.util.Paginator;
import com.amazonaws.glue.federation.connector.util.TableViewFilter;
import com.amazonaws.services.lambda.runtime.Context;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.hadoop.hive.metastore.IMetaStoreClient;
import org.apache.hadoop.hive.metastore.api.InvalidOperationException;
import org.apache.hadoop.hive.metastore.api.MetaException;
import org.apache.hadoop.hive.metastore.api.UnknownDBException;
import org.apache.thrift.TException;
import software.amazon.awssdk.services.gluecatalogfederation.model.GlueCatalogFederationException;
import software.amazon.awssdk.services.gluecatalogfederation.model.InvalidInputException;
import software.amazon.awssdk.services.gluecatalogfederation.model.SearchTablesRequest;
import software.amazon.awssdk.services.gluecatalogfederation.model.SearchTablesResponse;
import software.amazon.awssdk.services.gluecatalogfederation.model.Sort;
import software.amazon.awssdk.services.gluecatalogfederation.model.Table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The following are behavior differences between the federated search below and Glue search.
 * - Global sort across all expected tables is NOT SUPPORTED. Sorting happens only within each page.
 * - Fuzzy matching for search terms differs from Glue in terms of what is allowed "punctuation".
 * - Search text is applied on JSON-serialized tables instead of just the table values. This will need to be revisited.
 */
public class SearchTablesHandler implements OperationHandler<SearchTablesRequest, SearchTablesResponse> {

    private final TableFilterHandler tableFilterHandler;
    private final TableSortHandler tableSortHandler;
    private final TableHeaderSortHandler tableHeaderSortHandler;
    private final TableHeaderFilterHandler tableHeaderFilterHandler;

    private final SearchTextHandler searchTextHandler;

    public SearchTablesHandler() {
        this.tableFilterHandler = new TableFilterHandler();
        this.tableSortHandler = new TableSortHandler();
        this.tableHeaderSortHandler = new TableHeaderSortHandler();
        this.tableHeaderFilterHandler = new TableHeaderFilterHandler();
        this.searchTextHandler = new SearchTextHandler();
    }

    @Override
    public SearchTablesResponse handleRequest(IMetaStoreClient client, Context context,
            SearchTablesRequest request) throws GlueCatalogFederationException {
        context.getLogger().log("Handling SearchTables request: " + request);

        this.validateRequest(request);

        /*
         * Get filter list with type-checked filter keys.
         */
        List<Filter> filters = Filter.from(request.filters());

        /*
         * Get sort conditions with type-checked field names.
         */
        List<SortCondition> sortConditions = SortCondition.from(request.sortCriteria());

        /*
         * Extract filters that can be applied using the HMS APIs. Any additional filters will be applied using the
         * post-retrieval filter handler.
         */
        List<Filter> databaseNameFilters = new ArrayList<>();
        List<Filter> tableNameFilters = new ArrayList<>();
        List<Filter> additionalFilters = new ArrayList<>();
        for (Filter filter : filters) {
            switch (filter.getKey()) {
                case DATABASEIDENTIFIER:
                    databaseNameFilters.add(filter);
                    break;
                case NAME:
                    tableNameFilters.add(filter);
                    break;
                default:
                    additionalFilters.add(filter);
            }
        }

        /*
         * Create table header sort conditions for pagination. Default sort conditions will be replaced any sort
         * conditions from the request with the same field name.
         */
        List<SortCondition> headerSortConditions = new ArrayList<>();
        headerSortConditions.add(0, new SortCondition(SearchField.DATABASEIDENTIFIER, Sort.ASC));
        headerSortConditions.add(1, new SortCondition(SearchField.NAME, Sort.ASC));
        for (SortCondition sortCondition : sortConditions) {
            if (sortCondition.getField().equals(SearchField.DATABASEIDENTIFIER)) {
                headerSortConditions.set(0, sortCondition);
            } else if (sortCondition.getField().equals(SearchField.NAME)) {
                headerSortConditions.set(0, sortCondition);
            }
        }

        /*
         * Pagination is performed on the filtered & sorted list of table headers retrieved from Hive Metastore.
         */
        Paginator<TableHeader> paginator = new Paginator<>(() ->
                this.searchTableHeaders(client, context, databaseNameFilters, tableNameFilters, headerSortConditions));
        List<TableHeader> hmsTableHeaders = paginator.getPage(request.maxResults(), request.nextToken());
        String nextToken = paginator.getNextTokenIfPresent();

        /*
         * Retrieve full table objects for the page.
         */
        List<org.apache.hadoop.hive.metastore.api.Table> hmsTables = this.retrieveTablesFromHeaders(client, context,
                hmsTableHeaders);

        /*
         * Apply table view filter.
         */
        TableViewFilter.filter(hmsTables);

        /*
         * Apply post-retrieval filters.
         */
        this.tableFilterHandler.filter(hmsTables, additionalFilters);

        /*
         * Apply post-retrieval search text.
         */
        this.searchTextHandler.filter(hmsTables, request.searchText());

        /*
         * Sort results based on sort criteria
         */
        this.tableSortHandler.sort(hmsTables, sortConditions);


        List<Table> glueTables = new ArrayList<>();
        HiveIdProvider hiveIdProvider = new DefaultHiveIdProvider();
        for (org.apache.hadoop.hive.metastore.api.Table hmsTable : hmsTables) {
            glueTables.add(HiveToGlueConverter.convertTable(hmsTable, hiveIdProvider.getId(hmsTable)));
        }

        return SearchTablesResponse.builder().tables(glueTables).nextToken(nextToken).build();
    }

    private void validateRequest(SearchTablesRequest request) throws InvalidInputException {
        // Check sort keys are unique
        if (request.sortCriteria().size() > 1) {
            throw InvalidInputException.builder()
                    .message("Cannot have more than 1 sort criterion.")
                    .statusCode(400)
                    .build();
        }
    }

    /**
     * Provides the semi-filtered list of table headers that match any database/table filters request.
     * The database/table name pairs should be used to paginate and create a bounded list of table to retrieve from
     * HMS for post-retrieval filtering.
     */
    private List<TableHeader> searchTableHeaders(IMetaStoreClient client, Context context,
            List<Filter> databaseNameFilters, List<Filter> tableNameFilters, List<SortCondition> sortConditions) {

        /*
         * Apply supported filters using HMS APIs.
         *
         * Any field that CONTAINS the filter value is expected to be returned from HMS, e.g. (filterValue = 'link')
         * will match & return 'customer-link', 'xx-link-yy' and 'xxlinkyy'
         */

        List<String> databaseToSearch = new ArrayList<>();
        if (databaseNameFilters.isEmpty()) {
            databaseToSearch.addAll(this.retrieveAllDatabases(client, context));
        } else {
            for (Filter databaseNameFilter : databaseNameFilters) {
                String filterValue = this.getMatchPattern(databaseNameFilter.getValue());
                databaseToSearch.addAll(this.retrieveMatchingDatabaseNames(client, context, filterValue));
            }
        }

        List<TableHeader> tableHeaders = new ArrayList<>();
        if (tableNameFilters.isEmpty()) {
            for (String databaseName : databaseToSearch) {
                List<String> tableNames = this.retrieveAllTableNames(client, context, databaseName);
                for (String tableName : tableNames) {
                    tableHeaders.add(new TableHeader(databaseName, tableName));
                }
            }
        } else {
            for (String databaseName : databaseToSearch) {
                for (Filter tableNameFilter : tableNameFilters) {
                    String filterValue = this.getMatchPattern(tableNameFilter.getValue());
                    List<String> tableNames = this.retrieveMatchingTableNames(client, context, databaseName, filterValue);
                    for (String tableName : tableNames) {
                        tableHeaders.add(new TableHeader(databaseName, tableName));
                    }
                }
            }
        }

        /*
         * Apply post-retrieval filters.
         */
        List<Filter> filterList = new ArrayList<>(databaseNameFilters.size() + tableNameFilters.size());
        filterList.addAll(databaseNameFilters);
        filterList.addAll(tableNameFilters);
        this.tableHeaderFilterHandler.filter(tableHeaders, filterList);

        /*
         * Sort table headers.
         */
        this.tableHeaderSortHandler.sort(tableHeaders, sortConditions);

        return tableHeaders;
    }

    /**
     * Returns a regular expression that matches the search token to any value containing it.
     */
    private String getMatchPattern(String searchToken) {
        return "*" + searchToken + "*";
    }

    private List<org.apache.hadoop.hive.metastore.api.Table> retrieveTablesFromHeaders(IMetaStoreClient client,
            Context context, List<TableHeader> tableHeaders) {
        // Maps each database name to a list of table names
        Map<String, List<String>> databaseMap = new HashMap<>();

        // Convert list of table headers to database mapping
        for (TableHeader tableHeader : tableHeaders) {
            List<String> tableNames = databaseMap.computeIfAbsent(tableHeader.getDatabaseName(), k -> new ArrayList<>());
            tableNames.add(tableHeader.getTableName());
        }

        List<org.apache.hadoop.hive.metastore.api.Table> tables = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : databaseMap.entrySet()) {
            String databaseName = entry.getKey();
            List<String> tableNames = entry.getValue();
            tables.addAll(this.retrieveTablesFromNames(client, context, databaseName, tableNames));
        }

        return tables;
    }

    private List<String> retrieveMatchingDatabaseNames(IMetaStoreClient client, Context context,
            String databasePattern) {
        try {
            return client.getDatabases(databasePattern);
        } catch (MetaException ex) {
            context.getLogger().log(ExceptionUtils.getFullStackTrace(ex));
            throw ExceptionTranslator.translateMetaException(ex);
        } catch (TException ex) {
            context.getLogger().log(ExceptionUtils.getFullStackTrace(ex));
            throw ExceptionTranslator.translateTException(ex);
        }
    }

    private List<String> retrieveAllDatabases(IMetaStoreClient client, Context context) {
        try {
            return client.getAllDatabases();
        } catch (MetaException ex) {
            context.getLogger().log(ExceptionUtils.getFullStackTrace(ex));
            throw ExceptionTranslator.translateMetaException(ex);
        } catch (TException ex) {
            context.getLogger().log(ExceptionUtils.getFullStackTrace(ex));
            throw ExceptionTranslator.translateTException(ex);
        }
    }

    private List<String> retrieveMatchingTableNames(IMetaStoreClient client, Context context,
            String databaseIdentifier, String tablePattern) {
        try {
            return client.getTables(databaseIdentifier, tablePattern);
        } catch (UnknownDBException ex) {
            context.getLogger().log(ExceptionUtils.getFullStackTrace(ex));
            throw ExceptionTranslator.translateUnknownDBException(ex);
        } catch (MetaException ex) {
            context.getLogger().log(ExceptionUtils.getFullStackTrace(ex));
            throw ExceptionTranslator.translateMetaException(ex);
        } catch (TException ex) {
            context.getLogger().log(ExceptionUtils.getFullStackTrace(ex));
            throw ExceptionTranslator.translateTException(ex);
        }
    }

    private List<String> retrieveAllTableNames(IMetaStoreClient client, Context context, String databaseIdentifier) {
        try {
            return client.getAllTables(databaseIdentifier);
        } catch (UnknownDBException ex) {
            context.getLogger().log(ExceptionUtils.getFullStackTrace(ex));
            throw ExceptionTranslator.translateUnknownDBException(ex);
        } catch (MetaException ex) {
            context.getLogger().log(ExceptionUtils.getFullStackTrace(ex));
            throw ExceptionTranslator.translateMetaException(ex);
        } catch (TException ex) {
            context.getLogger().log(ExceptionUtils.getFullStackTrace(ex));
            throw ExceptionTranslator.translateTException(ex);
        }
    }

    private List<org.apache.hadoop.hive.metastore.api.Table> retrieveTablesFromNames(IMetaStoreClient client,
            Context context, String databaseIdentifier, List<String> tableNames) {
        try {
            return client.getTableObjectsByName(databaseIdentifier, tableNames);
        } catch (UnknownDBException ex) {
            context.getLogger().log(ExceptionUtils.getFullStackTrace(ex));
            throw ExceptionTranslator.translateUnknownDBException(ex);
        } catch (InvalidOperationException ex) {
            context.getLogger().log(ExceptionUtils.getFullStackTrace(ex));
            throw ExceptionTranslator.translateInvalidOperationException(ex);
        } catch (MetaException ex) {
            context.getLogger().log(ExceptionUtils.getFullStackTrace(ex));
            throw ExceptionTranslator.translateMetaException(ex);
        } catch (TException ex) {
            context.getLogger().log(ExceptionUtils.getFullStackTrace(ex));
            throw ExceptionTranslator.translateTException(ex);
        }
    }

}
