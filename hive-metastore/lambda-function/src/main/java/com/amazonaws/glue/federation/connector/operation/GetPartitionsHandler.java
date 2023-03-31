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
import com.amazonaws.glue.federation.connector.util.HivePartitionComparator;
import com.amazonaws.glue.federation.connector.util.HiveToGlueConverter;
import com.amazonaws.glue.federation.connector.util.Paginator;
import com.amazonaws.services.lambda.runtime.Context;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hive.metastore.IMetaStoreClient;
import org.apache.hadoop.hive.metastore.api.MetaException;
import org.apache.hadoop.hive.metastore.api.NoSuchObjectException;
import org.apache.thrift.TException;
import software.amazon.awssdk.services.gluecatalogfederation.model.GetPartitionsRequest;
import software.amazon.awssdk.services.gluecatalogfederation.model.GetPartitionsResponse;
import software.amazon.awssdk.services.gluecatalogfederation.model.GlueCatalogFederationException;
import software.amazon.awssdk.services.gluecatalogfederation.model.Partition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetPartitionsHandler implements OperationHandler<GetPartitionsRequest, GetPartitionsResponse> {

    @Override
    public GetPartitionsResponse handleRequest(IMetaStoreClient client, Context context,
            GetPartitionsRequest request) throws GlueCatalogFederationException {
        context.getLogger().log("Handling GetPartitions request: " + request);

        /*
         * Return empty list for unsupported segment requests. Partitions will only be returned for segment 0 to
         * maintain compatibility with AWS services that always call Glue using segments.
         */
        if (request.segment() != null && request.segment().segmentNumber() != 0) {
            context.getLogger().log("Segments are not supported for GetPartitions. Will only returning partitions for" +
                    " segment 0.");
            return GetPartitionsResponse.builder().partitions(Collections.emptyList()).build();
        }

        List<org.apache.hadoop.hive.metastore.api.Partition> hmsPartitions;
        String nextToken;
        if (StringUtils.isNotBlank(request.expression())) {
            /*
             * Pagination is performed on the filtered list of partitions retrieved from Hive Metastore. Hive
             * Metastore does not provide a method to filter over partition names alone, so all partitions must be
             * retrieved for each page. This can be improved with caching.
             */
            Paginator<org.apache.hadoop.hive.metastore.api.Partition> paginator = new Paginator<>(() ->
                    this.retrieveFilteredPartitions(client, context, request.databaseIdentifier(),
                            request.tableIdentifier(), request.expression()),
                    new HivePartitionComparator());

            // Retrieve page of partitions & next token
            hmsPartitions = paginator.getPage(request.maxResults(), request.nextToken());
            nextToken = paginator.getNextTokenIfPresent();
        } else {
            /*
             * Pagination is performed on the unfiltered list of partition names retrieved from Hive Metastore. This
             * improves efficiency by only requesting full objects for partitions within the page being returned.
             */
            Paginator<String> paginator = new Paginator<>(() -> this.retrievePartitionNames(client, context,
                    request.databaseIdentifier(),request.tableIdentifier()),
                    String::compareTo);

            // Retrieve page of partition names & next token
            List<String> partitionNames = paginator.getPage(request.maxResults(), request.nextToken());
            nextToken = paginator.getNextTokenIfPresent();

            // Retrieve partition objects for this page
            hmsPartitions = this.retrievePartitionObjectsFromNames(client, context, request.databaseIdentifier(),
                    request.tableIdentifier(), partitionNames);

            if (hmsPartitions.size() < partitionNames.size()) {
                context.getLogger().log("Hive Metastore failed to return all requested partitions. Returning " +
                        "partial result.");
            }
        }

        List<Partition> gluePartitions = new ArrayList<>();
        for (org.apache.hadoop.hive.metastore.api.Partition hmsPartition : hmsPartitions) {
            gluePartitions.add(HiveToGlueConverter.convertPartition(hmsPartition));
        }

        return GetPartitionsResponse.builder().partitions(gluePartitions).nextToken(nextToken).build();
    }

    private List<org.apache.hadoop.hive.metastore.api.Partition> retrieveFilteredPartitions(IMetaStoreClient client,
            Context context, String databaseIdentifier, String tableIdentifier, String filter) {
        try {
            return client.listPartitionsByFilter(databaseIdentifier, tableIdentifier, filter, (short) -1);
        } catch (NoSuchObjectException ex) {
            context.getLogger().log(ExceptionUtils.getFullStackTrace(ex));
            throw ExceptionTranslator.translateNoSuchObjectException(ex);
        } catch (MetaException ex) {
            context.getLogger().log(ExceptionUtils.getFullStackTrace(ex));
            throw ExceptionTranslator.translateMetaException(ex);
        } catch (TException ex) {
            context.getLogger().log(ExceptionUtils.getFullStackTrace(ex));
            throw ExceptionTranslator.translateTException(ex);
        }
    }

    private List<String> retrievePartitionNames(IMetaStoreClient client, Context context, String databaseIdentifier,
            String tableIdentifier) {
        try {
            return client.listPartitionNames(databaseIdentifier, tableIdentifier, (short) -1);
        } catch (MetaException ex) {
            context.getLogger().log(ExceptionUtils.getFullStackTrace(ex));
            throw ExceptionTranslator.translateMetaException(ex);
        } catch (TException ex) {
            context.getLogger().log(ExceptionUtils.getFullStackTrace(ex));
            throw ExceptionTranslator.translateTException(ex);
        }
    }

    private List<org.apache.hadoop.hive.metastore.api.Partition> retrievePartitionObjectsFromNames(
            IMetaStoreClient client, Context context, String databaseIdentifier, String tableIdentifier,
            List<String> partitionNames) {
        try {
            return client.getPartitionsByNames(databaseIdentifier, tableIdentifier, partitionNames);
        } catch (NoSuchObjectException ex) {
            context.getLogger().log(ExceptionUtils.getFullStackTrace(ex));
            throw ExceptionTranslator.translateNoSuchObjectException(ex);
        } catch (MetaException ex) {
            context.getLogger().log(ExceptionUtils.getFullStackTrace(ex));
            throw ExceptionTranslator.translateMetaException(ex);
        } catch (TException ex) {
            context.getLogger().log(ExceptionUtils.getFullStackTrace(ex));
            throw ExceptionTranslator.translateTException(ex);
        }
    }

}
