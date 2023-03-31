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

package com.amazonaws.glue.federation.connector;

import com.amazonaws.glue.federation.connector.operation.BatchGetDatabaseHandler;
import com.amazonaws.glue.federation.connector.operation.BatchGetPartitionHandler;
import com.amazonaws.glue.federation.connector.operation.BatchGetTableHandler;
import com.amazonaws.glue.federation.connector.operation.GetDatabaseHandler;
import com.amazonaws.glue.federation.connector.operation.GetPartitionHandler;
import com.amazonaws.glue.federation.connector.operation.GetPartitionsHandler;
import com.amazonaws.glue.federation.connector.operation.GetTableHandler;
import com.amazonaws.glue.federation.connector.operation.GetTablesHandler;
import com.amazonaws.glue.federation.connector.operation.Operation;
import com.amazonaws.glue.federation.connector.operation.SearchTablesHandler;
import com.amazonaws.glue.federation.connector.util.SerDeUtil;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import org.apache.hadoop.hive.metastore.IMetaStoreClient;
import software.amazon.awssdk.services.gluecatalogfederation.model.BatchGetDatabaseRequest;
import software.amazon.awssdk.services.gluecatalogfederation.model.BatchGetPartitionRequest;
import software.amazon.awssdk.services.gluecatalogfederation.model.BatchGetTableRequest;
import software.amazon.awssdk.services.gluecatalogfederation.model.GetDatabaseRequest;
import software.amazon.awssdk.services.gluecatalogfederation.model.GetPartitionRequest;
import software.amazon.awssdk.services.gluecatalogfederation.model.GetPartitionsRequest;
import software.amazon.awssdk.services.gluecatalogfederation.model.GetTableRequest;
import software.amazon.awssdk.services.gluecatalogfederation.model.GetTablesRequest;
import software.amazon.awssdk.services.gluecatalogfederation.model.GlueCatalogFederationException;
import software.amazon.awssdk.services.gluecatalogfederation.model.GlueCatalogFederationResponse;
import software.amazon.awssdk.services.gluecatalogfederation.model.SearchTablesRequest;

import java.util.Base64;
import java.util.HashMap;

/**
 * This abstract class provides all the core Lambda function logic. It determines the operation being performed and
 * calls an operation handler accordingly. The class can be extended with
 * {@link HiveMetastoreRequestHandler#getMetastoreClient()} to provide a custom Hive Metastore thrift client.
 */
public abstract class HiveMetastoreRequestHandler implements RequestHandler<APIGatewayProxyRequestEvent,
        APIGatewayProxyResponseEvent> {

    /**
     * Should provide a standalone Hive Metastore client implementation.
     */
    public abstract IMetaStoreClient getMetastoreClient();

    private final String TARGET_PREFIX = "GlueCatalogFederationService.";
    private final String CONTENT_TYPE_HEADER = "Content-Type";
    private final String X_AMZ_TARGET_HEADER = "x-amz-target";
    private final String X_AMZN_ERRORTYPE_HEADER = "x-amzn-ErrorType";

    private final IMetaStoreClient client;

    public HiveMetastoreRequestHandler() {
        this.client = getMetastoreClient();
    }

    /**
     * Entry point for the Lambda function call.
     */
    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent event, Context context) {
        context.getLogger().log("Event: " + event);

        Operation operation = this.getOperation(event);
        try {
            GlueCatalogFederationResponse response = this.callOperation(operation, event, context);
            return this.createResponseEvent(response);
        } catch (GlueCatalogFederationException ex) {
            return this.createResponseEvent(ex);
        }
    }

    private Operation getOperation(APIGatewayProxyRequestEvent event) {
        String operationName = event.getHeaders().get(X_AMZ_TARGET_HEADER).substring(TARGET_PREFIX.length());
        return Operation.valueOf(operationName);
    }

    private GlueCatalogFederationResponse callOperation(Operation operation, APIGatewayProxyRequestEvent event,
            Context context) throws GlueCatalogFederationException {
        String eventBody = this.getDecodedBody(event);
        switch (operation) {
            case BatchGetDatabase:
                BatchGetDatabaseRequest batchGetDatabaseRequest = SerDeUtil.deserialize(eventBody,
                        BatchGetDatabaseRequest.serializableBuilderClass()).build();
                return new BatchGetDatabaseHandler().handleRequest(client, context, batchGetDatabaseRequest);
            case BatchGetPartition:
                BatchGetPartitionRequest batchGetPartitionRequest = SerDeUtil.deserialize(eventBody,
                        BatchGetPartitionRequest.serializableBuilderClass()).build();
                return new BatchGetPartitionHandler().handleRequest(client, context, batchGetPartitionRequest);
            case BatchGetTable:
                BatchGetTableRequest batchGetTableRequest = SerDeUtil.deserialize(eventBody,
                        BatchGetTableRequest.serializableBuilderClass()).build();
                return new BatchGetTableHandler().handleRequest(client, context, batchGetTableRequest);
            case GetDatabase:
                GetDatabaseRequest getDatabaseRequest = SerDeUtil.deserialize(eventBody,
                        GetDatabaseRequest.serializableBuilderClass()).build();
                return new GetDatabaseHandler().handleRequest(client, context, getDatabaseRequest);
            case GetPartition:
                GetPartitionRequest getPartitionRequest = SerDeUtil.deserialize(eventBody,
                        GetPartitionRequest.serializableBuilderClass()).build();
                return new GetPartitionHandler().handleRequest(client, context, getPartitionRequest);
            case GetPartitions:
                GetPartitionsRequest getPartitionsRequest = SerDeUtil.deserialize(eventBody,
                        GetPartitionsRequest.serializableBuilderClass()).build();
                return new GetPartitionsHandler().handleRequest(client, context, getPartitionsRequest);
            case GetTable:
                GetTableRequest getTableRequest = SerDeUtil.deserialize(eventBody,
                        GetTableRequest.serializableBuilderClass()).build();
                return new GetTableHandler().handleRequest(client, context, getTableRequest);
            case GetTables:
                GetTablesRequest getTablesRequest = SerDeUtil.deserialize(eventBody,
                        GetTablesRequest.serializableBuilderClass()).build();
                return new GetTablesHandler().handleRequest(client, context, getTablesRequest);
            case SearchTables:
                SearchTablesRequest searchTablesRequest = SerDeUtil.deserialize(eventBody,
                        SearchTablesRequest.serializableBuilderClass()).build();
                return new SearchTablesHandler().handleRequest(client, context, searchTablesRequest);
            default:
                throw new RuntimeException("No handler exists for operation: " + operation.name());
        }
    }

    private String getDecodedBody(APIGatewayProxyRequestEvent event) {
        String request = event.getBody();
        if (event.getIsBase64Encoded()) {
            request = new String(Base64.getDecoder().decode(request));
        }
        return request;
    }

    private APIGatewayProxyResponseEvent createResponseEvent(GlueCatalogFederationResponse response) {
        String body = SerDeUtil.serialize(response.toBuilder());
        HashMap<String, String> headers = new HashMap<>();
        headers.put(CONTENT_TYPE_HEADER, "application/json");
        return new APIGatewayProxyResponseEvent()
                .withBody(body)
                .withHeaders(headers)
                .withIsBase64Encoded(false)
                .withStatusCode(200);
    }

    private APIGatewayProxyResponseEvent createResponseEvent(GlueCatalogFederationException exception) {
        String body = SerDeUtil.serialize(exception);
        HashMap<String, String> headers = new HashMap<>();
        headers.put(CONTENT_TYPE_HEADER, "application/json");
        headers.put(X_AMZN_ERRORTYPE_HEADER, exception.getClass().getSimpleName());
        return new APIGatewayProxyResponseEvent()
                .withBody(body)
                .withHeaders(headers)
                .withIsBase64Encoded(false)
                .withStatusCode(exception.statusCode());
    }
}
