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

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * Assists in adding pagination functionality to the Hive Metastore. Acts like a state machine for page status by
 * automatically generating next tokens in every page retrieval.
 */
public class Paginator<T> {

    private final Supplier<List<T>> supplier;
    private final Optional<Comparator<T>> comparator;
    private NextToken nextToken;

    /**
     * Constructor to be initialized within an API handler. Assumes quasi-consistent list order from supplier.
     * @param supplier Provides list of items that will be paginated
     */
    public Paginator(Supplier<List<T>> supplier) {
        this.supplier = supplier;
        this.comparator = Optional.empty();
    }

    /**
     * Constructor to be initialized within an API handler.
     * @param supplier Provides list of items that will be paginated
     * @param comparator Used to sort items and determine order in which they are distributed across pages
     */
    public Paginator(Supplier<List<T>> supplier, Comparator<T> comparator) {
        this.supplier = supplier;
        this.comparator = Optional.of(comparator);
    }

    /**
     * Retrieves pages using the implemented methods and automatically generates next tokens for continuous pagination.
     */
    public List<T> getPage(int maxResults, String nextToken) {
        List<T> allItems = this.supplier.get();
        int startIndex = NextToken.from(nextToken).getStartIndex();
        int endIndex = Math.min(startIndex + maxResults, allItems.size());

        List<T> itemsInPage = null;
        if (startIndex < endIndex) {
            // Sorting creates a quasi-consistent baseline that enables pagination across calls by creating succeeding
            // subsets of the sorted list
            this.comparator.ifPresent(allItems::sort);
            itemsInPage = allItems.subList(startIndex, endIndex);
        }

        // Generate next token if there are any remaining tables
        if (endIndex < allItems.size()) {
            this.nextToken = new NextToken(endIndex);
        }

        return Objects.requireNonNullElseGet(itemsInPage, ArrayList::new);
    }

    /**
     * Returns the current next token. Next token string will be null if there are no more pages available.
     */
    public String getNextTokenIfPresent() {
        return nextToken != null ? nextToken.toString() : null;
    }

}
