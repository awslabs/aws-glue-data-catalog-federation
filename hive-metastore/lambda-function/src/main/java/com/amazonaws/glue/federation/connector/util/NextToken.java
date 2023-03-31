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

import org.apache.commons.lang.StringUtils;

import java.util.Base64;

/**
 * Represents the next token for pagination APIs.
 */
public class NextToken {
    private final int startIndex;

    // Constructor required for ser/de
    private NextToken() {
        this.startIndex = 0;
    }

    public NextToken(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getStartIndex() {
        return this.startIndex;
    }

    public static NextToken from(final String nextTokenString) {
        if (StringUtils.isBlank(nextTokenString)) {
            return new NextToken();
        }
        String serializedNextToken = new String(Base64.getDecoder().decode(nextTokenString));
        return SerDeUtil.deserialize(serializedNextToken, NextToken.class);
    }

    @Override
    public String toString() {
        String serializedNextToken = SerDeUtil.serialize(this);
        return Base64.getEncoder().encodeToString(serializedNextToken.getBytes());
    }

}
