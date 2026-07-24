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

package com.amazonaws.glue.federation.connector.search.util;

import java.util.regex.Pattern;

/**
 * Utility class for adhering to Glue-specific search behavior.
 */
public class GlueSearchUtil {

    private GlueSearchUtil() {}

    /**
     * Common match function.
     * <p>
     * Pattern will match any string that contains the exact 'searchValue' by itself or seperated by punctuation. This
     * is to match Glue's fuzzy search behavior.
     * <p>
     * e.g., if (searchValue = "link")
     * Match: "link", "xx-link-yy", "-link", "link-", "--link--"
     * No match: "xxlinkyy", "xlink", "linky", "xlink-", "-linky"
     */
    public static boolean match(String itemProperty, String searchValue) {
        if (itemProperty == null || searchValue == null) {
            return false;
        }

        // \p{Punct} same as [!"\#$%&'()*+,\-./:;<=>?@\[\\\]^_‘{|}~]
        // Escape searchValue so regex metacharacters are treated as literals,
        // then wrap with punctuation-boundary anchors.
        // Uses (?:.*\p{Punct})? instead of (.*\p{Punct})* — semantically identical
        // but eliminates the nested quantifier that causes catastrophic backtracking.
        String escapedSearchValue = Pattern.quote(searchValue);
        String matchPattern = "^(?:.*\\p{Punct})?" + escapedSearchValue + "(?:\\p{Punct}.*)?$";
        return Pattern.matches(matchPattern, itemProperty);
    }
}
