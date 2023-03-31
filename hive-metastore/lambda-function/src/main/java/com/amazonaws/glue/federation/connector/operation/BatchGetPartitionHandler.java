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
import software.amazon.awssdk.services.gluecatalogfederation.model.BatchGetPartitionErrorEntry;
import software.amazon.awssdk.services.gluecatalogfederation.model.BatchGetPartitionRequest;
import software.amazon.awssdk.services.gluecatalogfederation.model.BatchGetPartitionResponse;
import software.amazon.awssdk.services.gluecatalogfederation.model.GlueCatalogFederationException;
import software.amazon.awssdk.services.gluecatalogfederation.model.Partition;
import software.amazon.awssdk.services.gluecatalogfederation.model.PartitionValue;

import java.util.ArrayList;
import java.util.List;

public class BatchGetPartitionHandler implements OperationHandler<BatchGetPartitionRequest, BatchGetPartitionResponse> {
    @Override
    public BatchGetPartitionResponse handleRequest(IMetaStoreClient client, Context context,
            BatchGetPartitionRequest request) throws GlueCatalogFederationException {
        context.getLogger().log("Handling BatchGetPartition request: " + request);

        List<Partition> gluePartitionList = new ArrayList<>();
        List<BatchGetPartitionErrorEntry> glueErrorList = new ArrayList<>();
        for (PartitionValue partitionEntry : request.entries()) {
            try {
                org.apache.hadoop.hive.metastore.api.Partition hmsPartition = this.getPartitionFromHms(client,
                        context, request.databaseIdentifier(), request.tableIdentifier(), partitionEntry);
                Partition gluePartition = HiveToGlueConverter.convertPartition(hmsPartition);
                gluePartitionList.add(gluePartition);
            } catch (GlueCatalogFederationException ex) {
                BatchGetPartitionErrorEntry errorEntry = this.convertToErrorEntry(ex, partitionEntry);
                glueErrorList.add(errorEntry);
            }
        }

        return BatchGetPartitionResponse.builder().partitions(gluePartitionList).errors(glueErrorList).build();
    }

    private org.apache.hadoop.hive.metastore.api.Partition getPartitionFromHms(IMetaStoreClient client, Context context,
            String databaseIdentifier, String tableIdentifier, PartitionValue partitionEntry) {
        try {
            return client.getPartition(databaseIdentifier, tableIdentifier, partitionEntry.values());
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

    private BatchGetPartitionErrorEntry convertToErrorEntry(GlueCatalogFederationException ex,
            PartitionValue partitionValue) {
        return BatchGetPartitionErrorEntry.builder()
                .partitionValue(partitionValue)
                .error(ExceptionTranslator.errorDetailOf(ex))
                .build();
    }
}
