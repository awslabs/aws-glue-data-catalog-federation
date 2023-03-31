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
import software.amazon.awssdk.services.gluecatalogfederation.model.GetTablesRequest;
import software.amazon.awssdk.services.gluecatalogfederation.model.GetTablesResponse;
import software.amazon.awssdk.services.gluecatalogfederation.model.GlueCatalogFederationException;
import software.amazon.awssdk.services.gluecatalogfederation.model.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GetTablesHandler implements OperationHandler<GetTablesRequest, GetTablesResponse> {

    @Override
    public GetTablesResponse handleRequest(IMetaStoreClient client, Context context,
            GetTablesRequest request) throws GlueCatalogFederationException {
        context.getLogger().log("Handling GetTables request: " + request);

        // Can be null from Glue, but required as non-null for Hive Metastore
        String filter = Optional.ofNullable(request.expression()).orElse("");

        /*
         * Pagination is performed on the filtered list of table names retrieved from Hive Metastore. This improves
         * efficiency by only requesting full objects for tables within the page being returned.
         */
        Paginator<String> paginator = new Paginator<>(() -> this.retrieveFilteredTableNames(client, context,
                request.databaseIdentifier(), filter),
                String::compareTo);

        // Retrieve page of table names
        List<String> tableNames = paginator.getPage(request.maxResults(), request.nextToken());

        // Retrieve table objects for this page
        List<org.apache.hadoop.hive.metastore.api.Table> hmsTables = this.retrieveTablesFromNames(client,
                context, request.databaseIdentifier(), tableNames);
        if (hmsTables.size() < tableNames.size()) {
            context.getLogger().log("Hive Metastore failed to return all requested tables. Returning partial " +
                    "result.");
        }

        /*
         * Apply table view filter.
         */
        TableViewFilter.filter(hmsTables);

        List<Table> glueTables = new ArrayList<>();
        HiveIdProvider hiveIdProvider = new DefaultHiveIdProvider();
        for (org.apache.hadoop.hive.metastore.api.Table hmsTable : hmsTables) {
            glueTables.add(HiveToGlueConverter.convertTable(hmsTable, hiveIdProvider.getId(hmsTable)));
        }

        String nextToken = paginator.getNextTokenIfPresent();

        return GetTablesResponse.builder().tables(glueTables).nextToken(nextToken).build();
    }

    private List<String> retrieveFilteredTableNames(IMetaStoreClient client, Context context,
            String databaseIdentifier, String filter) {
        try {
            return client.listTableNamesByFilter(databaseIdentifier, filter, (short) -1);
        } catch (UnknownDBException ex) {
            context.getLogger().log(ExceptionUtils.getFullStackTrace(ex));
            throw ExceptionTranslator.translateUnknownDBException(ex);
        } catch (InvalidOperationException ex) {
            context.getLogger().log(ExceptionUtils.getFullStackTrace(ex));
            throw ExceptionTranslator.translateInvalidOperationException(ex);
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

