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
 * Provides identifiers for Hive Metastore objects. These identifiers are used for tracking additional AWS resource
 * across name changes on the Hive Metastore. Identifiers must be unique and immutable
 * <br>
 * <br>
 * NOTE: A custom implementation of this class is REQUIRED to maintain proper functionality of additional AWS
 * resources such as LF permissions. Read more in the default implementation.
 */
public interface HiveIdProvider {
    String getId(Table table);
}
