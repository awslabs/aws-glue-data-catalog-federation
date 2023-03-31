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

import org.apache.hadoop.hive.metastore.api.StorageDescriptor;
import org.apache.hadoop.hive.metastore.api.Table;
import org.apache.hadoop.hive.metastore.api.hive_metastoreConstants;

import java.util.Comparator;
import java.util.function.Function;

public class TableSortHandler extends SortHandler<Table> {

    @Override
    Comparator<Table> databaseIdentifierComparator() {
        return nullSafeComparator(Table::getDbName, Comparator.naturalOrder());
    }

    @Override
    Comparator<Table> nameComparator() {
        return nullSafeComparator(Table::getTableName, Comparator.naturalOrder());
    }

    @Override
    Comparator<Table> locationComparator() {
        /*
         * Location resides within the storage descriptor. Therefore, we need to nest the location comparator within
         * a storage descriptor comparator so that comparison on null storage descriptors precedes the location
         * comparisons.
         */
        Comparator<StorageDescriptor> locationComparator = nullSafeComparator(StorageDescriptor::getLocation,
                Comparator.naturalOrder());
        return nullSafeComparator(Table::getSd, locationComparator);
    }

    @Override
    Comparator<Table> updateTimeComparator() {
        return nullSafeComparator(this::getUpdateTime, Integer::compareTo);
    }

    @Override
    Comparator<Table> createTimeComparator() {
        return nullSafeComparator(Table::getCreateTime, Comparator.naturalOrder());
    }

    /**
     * Best effort attempt to use the `transient_lastDdlTime` Table parameter as an UpdateTime field for comparison.
     * If not present, will default to the table's CreateTime.
     */
    private int getUpdateTime(Table table) {
        try {
            String updateTimeString = table.getParameters().get(hive_metastoreConstants.DDL_TIME);
            return Integer.parseInt(updateTimeString);
        } catch (Exception ex) {
            // Default to create time in case of exception
            return table.getCreateTime();
        }
    }

    /**
     * Will nest whatever comparator is being applied to the key within a {@link Comparator#nullsFirst} comparator for
     * safety against null value comparison.
     */
    public static <T, U> Comparator<T> nullSafeComparator(Function<? super T, ? extends U> keyExtractor,
                                                          Comparator<? super U> keyComparator) {
        return (o1, o2) -> Comparator.nullsFirst(keyComparator).compare(keyExtractor.apply(o1), keyExtractor.apply(o2));
    }
}
