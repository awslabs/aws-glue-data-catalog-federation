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

import com.amazonaws.glue.federation.connector.util.ExceptionTranslator;
import com.amazonaws.glue.federation.connector.util.HiveToGlueConverter;
import com.amazonaws.services.lambda.runtime.Context;
import org.apache.hadoop.hive.metastore.IMetaStoreClient;
import org.apache.hadoop.hive.metastore.api.MetaException;
import org.apache.hadoop.hive.metastore.api.NoSuchObjectException;
import org.apache.thrift.TException;
import software.amazon.awssdk.services.gluecatalogfederation.model.BatchGetDatabaseErrorEntry;
import software.amazon.awssdk.services.gluecatalogfederation.model.BatchGetDatabaseRequest;
import software.amazon.awssdk.services.gluecatalogfederation.model.BatchGetDatabaseResponse;
import software.amazon.awssdk.services.gluecatalogfederation.model.Database;
import software.amazon.awssdk.services.gluecatalogfederation.model.GlueCatalogFederationException;

import java.util.ArrayList;
import java.util.List;

public class BatchGetDatabaseHandler implements OperationHandler<BatchGetDatabaseRequest, BatchGetDatabaseResponse> {
    @Override
    public BatchGetDatabaseResponse handleRequest(IMetaStoreClient client, Context context,
            BatchGetDatabaseRequest request) throws GlueCatalogFederationException {
        context.getLogger().log("Handling BatchGetDatabase request: " + request);

        List<Database> glueDatabaseList = new ArrayList<>();
        List<BatchGetDatabaseErrorEntry> glueErrorList = new ArrayList<>();
        for (String databaseEntry : request.entries()) {
            try {
                org.apache.hadoop.hive.metastore.api.Database hmsDatabase = this.getDatabaseFromHms(client, context,
                        databaseEntry);
                Database glueDatabase = HiveToGlueConverter.convertDatabase(hmsDatabase);
                glueDatabaseList.add(glueDatabase);
            } catch (GlueCatalogFederationException ex) {
                BatchGetDatabaseErrorEntry errorEntry = this.convertToErrorEntry(ex, databaseEntry);
                glueErrorList.add(errorEntry);
            }
        }

        return BatchGetDatabaseResponse.builder().databases(glueDatabaseList).errors(glueErrorList).build();
    }

    private org.apache.hadoop.hive.metastore.api.Database getDatabaseFromHms(IMetaStoreClient client, Context context,
            String databaseIdentifier) {
        try {
            return client.getDatabase(databaseIdentifier);
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

    private BatchGetDatabaseErrorEntry convertToErrorEntry(GlueCatalogFederationException ex,
            String databaseIdentifier) {
        return BatchGetDatabaseErrorEntry.builder()
                .databaseIdentifier(databaseIdentifier)
                .error(ExceptionTranslator.errorDetailOf(ex))
                .build();
    }
}
