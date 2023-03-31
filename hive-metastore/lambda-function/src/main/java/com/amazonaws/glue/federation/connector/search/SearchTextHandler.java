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
import com.amazonaws.glue.federation.connector.util.SerDeUtil;

import java.util.List;

/**
 * Handler for adding search text capabilities post-retrieval from metastore. This class is for filling gaps in the
 * metastore search APIs.
 */
public class SearchTextHandler {

    /**
     * Applies search text over the serialized item.
     */
    private <T> boolean searchTextMatch(T item, String searchText) {
        String serialized = SerDeUtil.serialize(item);
        return GlueSearchUtil.match(serialized, searchText);
    }

    /**
     * Filters the passed items to only include those that match search text on any member.
     * @param items List of items to filter
     * @param searchText Search text to filter by
     */
    public <T> void filter(List<T> items, String searchText) {
        if (searchText != null && !searchText.isEmpty()) {
            items.removeIf(i -> !this.searchTextMatch(i, searchText));
        }
    }

}
