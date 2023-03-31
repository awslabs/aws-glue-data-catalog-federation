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

import org.apache.hadoop.hive.metastore.api.Partition;

import java.util.Comparator;
import java.util.List;

/**
 * Allows the sorting of Hive partitions based on the lexicographical ordering of their partition values.
 */
public class HivePartitionComparator implements Comparator<Partition> {

    @Override
    public int compare(Partition o1, Partition o2) {
        List<String> values1 = o1.getValues();
        List<String> values2 = o2.getValues();
        int minSize = Math.min(values1.size(), values2.size());

        // Attempt lexicographical sort on min num of values
        for (int i = 0; i < minSize; i++) {
            int c = values1.get(i).compareTo(values2.get(i));
            if (c != 0) {
                return c;
            }
        }

        // Otherwise, sort on num of values
        return Integer.compare(values1.size(), values2.size());
    }
}
