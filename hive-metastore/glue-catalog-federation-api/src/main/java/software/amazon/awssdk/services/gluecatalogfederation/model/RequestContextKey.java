/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is located at
 * 
 * http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */

package software.amazon.awssdk.services.gluecatalogfederation.model;

import java.util.EnumSet;
import java.util.Map;
import java.util.Set;
import software.amazon.awssdk.annotations.Generated;
import software.amazon.awssdk.utils.internal.EnumUtils;

@Generated("software.amazon.awssdk:codegen")
public enum RequestContextKey {
    AUDIT_CONTEXT("auditContext"),

    REQUEST_ID("requestId"),

    CALLER("caller"),

    RESOURCE_LINK_ARN("resourceLinkArn"),

    UNKNOWN_TO_SDK_VERSION(null);

    private static final Map<String, RequestContextKey> VALUE_MAP = EnumUtils.uniqueIndex(RequestContextKey.class,
            RequestContextKey::toString);

    private final String value;

    private RequestContextKey(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    /**
     * Use this in place of valueOf to convert the raw string returned by the service into the enum value.
     *
     * @param value
     *        real value
     * @return RequestContextKey corresponding to the value
     */
    public static RequestContextKey fromValue(String value) {
        if (value == null) {
            return null;
        }
        return VALUE_MAP.getOrDefault(value, UNKNOWN_TO_SDK_VERSION);
    }

    /**
     * Use this in place of {@link #values()} to return a {@link Set} of all values known to the SDK. This will return
     * all known enum values except {@link #UNKNOWN_TO_SDK_VERSION}.
     *
     * @return a {@link Set} of known {@link RequestContextKey}s
     */
    public static Set<RequestContextKey> knownValues() {
        Set<RequestContextKey> knownValues = EnumSet.allOf(RequestContextKey.class);
        knownValues.remove(UNKNOWN_TO_SDK_VERSION);
        return knownValues;
    }
}