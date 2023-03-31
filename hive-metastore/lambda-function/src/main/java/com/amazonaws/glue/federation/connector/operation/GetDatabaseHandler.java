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
import software.amazon.awssdk.services.gluecatalogfederation.model.Database;
import software.amazon.awssdk.services.gluecatalogfederation.model.GetDatabaseRequest;
import software.amazon.awssdk.services.gluecatalogfederation.model.GetDatabaseResponse;
import software.amazon.awssdk.services.gluecatalogfederation.model.GlueCatalogFederationException;

public class GetDatabaseHandler implements OperationHandler<GetDatabaseRequest, GetDatabaseResponse> {
    @Override
    public GetDatabaseResponse handleRequest(IMetaStoreClient client, Context context,
            GetDatabaseRequest request) throws GlueCatalogFederationException {
        context.getLogger().log("Handling GetDatabase request: " + request);

        org.apache.hadoop.hive.metastore.api.Database hmsDatabase;
        try {
            hmsDatabase = client.getDatabase(request.databaseIdentifier());
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

        Database glueDatabase = HiveToGlueConverter.convertDatabase(hmsDatabase);
        return GetDatabaseResponse.builder().database(glueDatabase).build();
    }
}

