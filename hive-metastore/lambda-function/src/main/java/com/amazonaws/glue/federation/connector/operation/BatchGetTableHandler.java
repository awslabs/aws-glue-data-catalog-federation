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
import com.amazonaws.glue.federation.connector.util.ExceptionTranslator;
import com.amazonaws.glue.federation.connector.util.HiveToGlueConverter;
import com.amazonaws.glue.federation.connector.util.TableViewFilter;
import com.amazonaws.services.lambda.runtime.Context;
import org.apache.hadoop.hive.metastore.IMetaStoreClient;
import org.apache.hadoop.hive.metastore.api.MetaException;
import org.apache.hadoop.hive.metastore.api.NoSuchObjectException;
import org.apache.thrift.TException;
import software.amazon.awssdk.services.gluecatalogfederation.model.BatchGetTableEntry;
import software.amazon.awssdk.services.gluecatalogfederation.model.BatchGetTableErrorEntry;
import software.amazon.awssdk.services.gluecatalogfederation.model.BatchGetTableRequest;
import software.amazon.awssdk.services.gluecatalogfederation.model.BatchGetTableResponse;
import software.amazon.awssdk.services.gluecatalogfederation.model.GlueCatalogFederationException;
import software.amazon.awssdk.services.gluecatalogfederation.model.InvalidInputException;
import software.amazon.awssdk.services.gluecatalogfederation.model.Table;

import java.util.ArrayList;
import java.util.List;

public class BatchGetTableHandler implements OperationHandler<BatchGetTableRequest, BatchGetTableResponse> {
    @Override
    public BatchGetTableResponse handleRequest(IMetaStoreClient client, Context context,
            BatchGetTableRequest request) throws GlueCatalogFederationException {
        context.getLogger().log("Handling BatchGetTable request: " + request);

        List<Table> glueTableList = new ArrayList<>();
        List<BatchGetTableErrorEntry> glueErrorList = new ArrayList<>();
        for (BatchGetTableEntry tableEntry : request.entries()) {
            try {
                org.apache.hadoop.hive.metastore.api.Table hmsTable = this.getTableFromHms(client, context, tableEntry);

                if (TableViewFilter.isTableView(hmsTable)) {
                    throw InvalidInputException.builder()
                            .message("Table views are not supported.")
                            .statusCode(400)
                            .build();
                }

                String tableId = new DefaultHiveIdProvider().getId(hmsTable);
                Table glueTable = HiveToGlueConverter.convertTable(hmsTable, tableId);
                glueTableList.add(glueTable);
            } catch (GlueCatalogFederationException ex) {
                BatchGetTableErrorEntry errorEntry = this.convertToErrorEntry(ex, tableEntry);
                glueErrorList.add(errorEntry);
            }
        }

        return BatchGetTableResponse.builder().tableList(glueTableList).errors(glueErrorList).build();
    }

    private org.apache.hadoop.hive.metastore.api.Table getTableFromHms(IMetaStoreClient client, Context context,
            BatchGetTableEntry tableEntry) {
        try {
            return client.getTable(tableEntry.databaseIdentifier(), tableEntry.tableIdentifier());
        } catch (NoSuchObjectException ex) {
            context.getLogger().log(ex.getMessage());
            throw ExceptionTranslator.translateNoSuchObjectException(ex);
        } catch (MetaException ex) {
            context.getLogger().log(ex.getMessage());
            throw ExceptionTranslator.translateMetaException(ex);
        } catch (TException ex) {
            context.getLogger().log(ex.getMessage());
            throw ExceptionTranslator.translateTException(ex);
        }
    }

    private BatchGetTableErrorEntry convertToErrorEntry(GlueCatalogFederationException ex,
            BatchGetTableEntry tableEntry) {
        return BatchGetTableErrorEntry.builder()
                .batchGetTableEntry(tableEntry)
                .error(ExceptionTranslator.errorDetailOf(ex))
                .build();
    }
}
