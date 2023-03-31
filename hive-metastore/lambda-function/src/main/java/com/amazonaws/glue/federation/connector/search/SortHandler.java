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

import software.amazon.awssdk.services.gluecatalogfederation.model.Sort;

import java.util.Comparator;
import java.util.List;

/**
 * Handler for adding sorting capabilities post-retrieval from metastore. This class is for adding sorting
 * functionality on sources that don't provide capable search APIs.
 * @param <T> Class of object being sorted.
 */
public abstract class SortHandler<T> {

    /**
     * Provides comparator for sort items on {@link SearchField#DATABASEIDENTIFIER}.
     */
    abstract Comparator<T> databaseIdentifierComparator();

    /**
     * Provides comparator for sort items on {@link SearchField#NAME}.
     */
    abstract Comparator<T> nameComparator();

    /**
     * Provides comparator for sort items on {@link SearchField#LOCATION}.
     */
    abstract Comparator<T> locationComparator();

    /**
     * Provides comparator for sort items on {@link SearchField#UPDATETIME}.
     */
    abstract Comparator<T> updateTimeComparator();

    /**
     * Provides comparator for sort items on {@link SearchField#CREATETIME}.
     */
    abstract Comparator<T> createTimeComparator();

    /**
     * Default comparator can be used for any unsupported fields.
     */
    Comparator<T> defaultComparator() {
        return (o1, o2) -> 0;
    }

    /**
     * Provides corresponding comparator for sorting item on given field.
     */
    private Comparator<T> getComparator(SearchField field) {
        switch (field) {
            case DATABASEIDENTIFIER: return databaseIdentifierComparator();
            case NAME: return nameComparator();
            case LOCATION: return locationComparator();
            case UPDATETIME: return updateTimeComparator();
            case CREATETIME: return createTimeComparator();
            default: throw new UnsupportedOperationException();
        }
    }

    /**
     * Sorts the passed items using the given sort criteria. The criterion will be applied in the order it appears
     * within the list.
     * @param items List of items to be sorted.
     * @param sortConditions List of sort conditions to apply.
     */
    public void sort(List<T> items, List<SortCondition> sortConditions) {
        items.sort((o1, o2) -> {
            int result = 0;
            // Sort is determined from the first sort condition that doesn't result in 0 (equal to)
            for (int i = 0; i < sortConditions.size() && result == 0; i++) {
                SortCondition condition = sortConditions.get(i);
                int sortDir = Sort.ASC.equals(condition.getSort()) ? 1 : -1;
                Comparator<T> comparator = this.getComparator(condition.getField());
                result = comparator.compare(o1, o2) * sortDir;
            }
            return result;
        });
    }

 }
