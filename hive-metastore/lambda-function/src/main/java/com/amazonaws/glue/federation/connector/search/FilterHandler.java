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

import software.amazon.awssdk.services.gluecatalogfederation.model.Comparator;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * Handler for adding filtering capabilities post-retrieval from metastore. This class is for filling gaps in the
 * metastore search APIs.
 * @param <T> Class of object being filtered.
 */
public abstract class FilterHandler<T> {

    /**
     * Predicate for filtering items on {@link SearchField#DATABASEIDENTIFIER}. Returns whether item is a match.
     */
    abstract boolean databaseIdentifierPredicate(T item, Comparator comparator, String value);

    /**
     * Predicate for filtering items on {@link SearchField#NAME}. Returns whether item is a match.
     */
    abstract boolean namePredicate(T item, Comparator comparator, String value);

    /**
     * Predicate for filtering items on {@link SearchField#LOCATION}. Returns whether item is a match.
     */
    abstract boolean locationPredicate(T item, Comparator comparator, String value);

    /**
     * Predicate for filtering items on {@link SearchField#UPDATETIME}. Returns whether item is a match.
     */
    abstract boolean updateTimePredicate(T item, Comparator comparator, String value);

    /**
     * Predicate for filtering items on {@link SearchField#CREATETIME}. Returns whether item is a match.
     */
    abstract boolean createTimePredicate(T item, Comparator comparator, String value);

    /**
     * Default predicate can be used for any unsupported fields.
     */
    boolean defaultPredicate() {
        return false;
    }

    /**
     * Applies corresponding predicate for the given filter. Returns boolean indicating whether item is a match.
     */
    private boolean matchFilter(T item, Filter filter) {
        SearchField key = filter.getKey();
        Comparator comparator = filter.getComparator();
        String value = filter.getValue();
        switch (key) {
            case DATABASEIDENTIFIER: return databaseIdentifierPredicate(item, comparator, value);
            case NAME: return namePredicate(item, comparator, value);
            case LOCATION: return locationPredicate(item, comparator, value);
            case UPDATETIME: return updateTimePredicate(item, comparator, value);
            case CREATETIME: return createTimePredicate(item, comparator, value);
            default: throw new UnsupportedOperationException();
        }
    }

    /**
     * Applies a joint predicate for the given filter list. Returns whether the item matches any of the filters for
     * each field. This is equivalent to applying a union across each filter with the same field and an intersection
     * of all different fields passed across all filters.
     */
    private boolean matchFilters(T item, List<Filter> filters) {
        // Maintain mapping of whether each field has been matched with a filter
        Map<SearchField, Boolean> matchedFieldMap = new EnumMap<>(SearchField.class);
        for (Filter filter : filters) {
            SearchField key = filter.getKey();
            Boolean fieldAlreadyMatched = matchedFieldMap.getOrDefault(key, false);
            if (!fieldAlreadyMatched) {
                matchedFieldMap.put(key, this.matchFilter(item, filter));
            }
        }

        // Apply AND operator across all field match values to ensure each one is met
        boolean match = false;
        if (!matchedFieldMap.isEmpty()) {
            match = matchedFieldMap.values().stream().allMatch(i -> i);
        }

        return match;
    }

    /**
     * Filters the passed items to only include those that match one of the passed filters for each key.
     * @param items List of items to filter
     * @param filters List of filters to apply
     */
    public void filter(List<T> items, List<Filter> filters) {
        if (!filters.isEmpty()) {
            items.removeIf(i -> !this.matchFilters(i, filters));
        }
    }

}
