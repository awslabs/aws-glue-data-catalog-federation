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

package com.amazonaws.glue.federation.connector.util;

import org.apache.hadoop.hive.metastore.TableType;
import org.apache.hadoop.hive.metastore.api.Table;

import java.util.List;

/**
 * Filters out unsupported VIRTUAL_VIEW & MATERIALIZED_VIEW table types.
 */
public final class TableViewFilter {

    private TableViewFilter() {}

    /**
     * Filters the passed items to any table views (tables with type VIRTUAL_VIEW or MATERIALIZED_VIEW).
     * @param tables List of items to filter
     */
    public static void filter(List<Table> tables) {
        tables.removeIf(TableViewFilter::isTableView);
    }

    public static boolean isTableView(Table table) {
        String tableType = table.getTableType();
        return TableType.VIRTUAL_VIEW.name().equals(tableType) || TableType.MATERIALIZED_VIEW.name().equals(tableType);
    }
}
