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

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.metastore.HiveMetaStoreClient;
import org.apache.hadoop.hive.metastore.IMetaStoreClient;
import org.apache.hadoop.hive.metastore.conf.MetastoreConf;

/**
 * Default implementation of the HiveMetastoreRequestHandler using the publicly available implementation of the
 * standalone Hive Metastore client.
 */
public class DefaultHiveMetastoreLambdaFunction extends HiveMetastoreRequestHandler {

    private final String ENV_THRIFT_URIS = "THRIFT_URIS";

    public IMetaStoreClient getMetastoreClient() {
        try {
            return new HiveMetaStoreClient(this.getMetastoreConfiguration());
        } catch (Exception ex) {
            throw new RuntimeException("Failed to create Hive Metastore client", ex);
        }
    }

    private Configuration getMetastoreConfiguration() {
        try {
            // Create a new configuration. Automatically uses local 'metastore-site.xml' to override properties.
            Configuration conf = MetastoreConf.newMetastoreConf();

            // Override with Lambda env variables (given as input during SAM deployment)
            MetastoreConf.setVar(conf, MetastoreConf.ConfVars.THRIFT_URIS, System.getenv(ENV_THRIFT_URIS));

            return conf;
        } catch (Exception ex) {
            throw new RuntimeException("Failed to retrieve Hive configurations", ex);
        }
    }
}
