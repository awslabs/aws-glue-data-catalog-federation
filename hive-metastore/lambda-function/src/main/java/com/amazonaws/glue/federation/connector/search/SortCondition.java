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
import software.amazon.awssdk.services.gluecatalogfederation.model.SortCriterion;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an applicable sort condition for the {@link SortHandler}.
 */
public class SortCondition {
    private final SearchField field;
    private final Sort sort;

    public SortCondition(SearchField field, Sort sort) {
        this.field = field;
        this.sort = sort;
    }

    private static SortCondition from(SortCriterion sortCriterion) {
        SearchField field = SearchField.from(sortCriterion.fieldName());
        return new SortCondition(field, sortCriterion.sort());
    }

    public static List<SortCondition> from(List<SortCriterion> sortCriteria) {
        List<SortCondition> sortConditions = new ArrayList<>();
        for (SortCriterion sortCriterion : sortCriteria) {
            sortConditions.add(SortCondition.from(sortCriterion));
        }
        return sortConditions;
    }

    public SearchField getField() {
        return field;
    }

    public Sort getSort() {
        return sort;
    }
}