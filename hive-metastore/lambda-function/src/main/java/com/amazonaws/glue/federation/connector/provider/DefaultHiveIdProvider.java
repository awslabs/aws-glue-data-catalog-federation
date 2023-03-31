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

package com.amazonaws.glue.federation.connector.provider;

import org.apache.hadoop.hive.metastore.api.Table;

/**
 * Default implementation of {@link HiveIdProvider}.
 * <br>
 * <br>
 * WARNING: This default implementation does not provide full functionality of additional AWS resources such as LF
 * permissions. This is because the Hive Metastore objects do not maintain a unique, immutable identifier by
 * default. The Hive Metastore object names can be altered, so they are not reliable for identification over time.
 */
public class DefaultHiveIdProvider implements HiveIdProvider {
    public String getId(Table table) {
        return table.getTableName();
    }
}
