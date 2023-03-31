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

import com.amazonaws.services.lambda.runtime.Context;
import org.apache.hadoop.hive.metastore.IMetaStoreClient;
import software.amazon.awssdk.services.gluecatalogfederation.model.GlueCatalogFederationException;
import software.amazon.awssdk.services.gluecatalogfederation.model.GlueCatalogFederationRequest;
import software.amazon.awssdk.services.gluecatalogfederation.model.GlueCatalogFederationResponse;

/**
 * Operation handlers implement logic for the GlueCatalogFederationService API.
 */
public interface OperationHandler<REQ extends GlueCatalogFederationRequest, RES extends GlueCatalogFederationResponse> {
    /**
     * Should handle all necessary calls to the Hive Metastore client for the operation.
     * @param client Hive Metastore client
     * @param context Lambda function context
     * @param request GlueCatalogFederationRequest subclass
     * @return GlueCatalogFederationResponse subclass
     * @throws GlueCatalogFederationException Translated Hive Metastore exception
     */
    RES handleRequest(IMetaStoreClient client, Context context, REQ request) throws GlueCatalogFederationException;
}
