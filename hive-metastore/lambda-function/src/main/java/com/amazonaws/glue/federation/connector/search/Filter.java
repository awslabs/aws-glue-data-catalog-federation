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
import software.amazon.awssdk.services.gluecatalogfederation.model.PropertyPredicate;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an applicable filter for the {@link FilterHandler}.
 */
public class Filter {
    private final SearchField key;
    private final Comparator comparator;
    private final String value;

    private Filter(SearchField key, Comparator comparator, String value) {
        this.key = key;
        this.comparator = comparator;
        this.value = value;
    }

    private static Filter from(PropertyPredicate propertyPredicate) {
        SearchField key = SearchField.from(propertyPredicate.key());
        Comparator comparator = propertyPredicate.comparator();
        String value = propertyPredicate.value();
        return new Filter(key, comparator, value);
    }

    public static List<Filter> from(List<PropertyPredicate> propertyPredicates) {
        List<Filter> filters = new ArrayList<>();
        for (PropertyPredicate propertyPredicate : propertyPredicates) {
            filters.add(Filter.from(propertyPredicate));
        }
        return filters;
    }

    public SearchField getKey() {
        return key;
    }

    public Comparator getComparator() {
        return comparator;
    }

    public String getValue() {
        return value;
    }
}
