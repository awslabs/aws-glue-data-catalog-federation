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

package com.amazonaws.glue.federation.connector.search;

import com.amazonaws.glue.federation.connector.search.util.GlueSearchUtil;
import org.apache.hadoop.hive.metastore.api.StorageDescriptor;
import org.apache.hadoop.hive.metastore.api.Table;
import software.amazon.awssdk.services.gluecatalogfederation.model.Comparator;

/**
 * Post-retrieval filter handler for tables.
 */
public class TableFilterHandler extends FilterHandler<Table> {

    @Override
    boolean databaseIdentifierPredicate(Table item, Comparator comparator, String value) {
        String itemProperty = item.getDbName();
        return GlueSearchUtil.match(itemProperty, value);
    }

    @Override
    boolean namePredicate(Table item, Comparator comparator, String value) {
        String itemProperty = item.getTableName();
        return GlueSearchUtil.match(itemProperty, value);
    }

    @Override
    boolean locationPredicate(Table item, Comparator comparator, String value) {
        StorageDescriptor sd = item.getSd();
        if (sd == null) {
            return false;
        }
        String itemProperty = sd.getLocation();
        return GlueSearchUtil.match(itemProperty, value);
    }

    @Override
    boolean updateTimePredicate(Table item, Comparator comparator, String value) {
        return defaultPredicate();
    }

    @Override
    boolean createTimePredicate(Table item, Comparator comparator, String value) {
        return defaultPredicate();
    }

}
