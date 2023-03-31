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

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import software.amazon.awssdk.annotations.Generated;
import software.amazon.awssdk.core.util.DefaultSdkAutoConstructMap;
import software.amazon.awssdk.core.util.SdkAutoConstructMap;

@Generated("software.amazon.awssdk:codegen")
final class RequestContextMapCopier {
    static Map<String, String> copy(Map<String, String> requestContextMapParam) {
        Map<String, String> map;
        if (requestContextMapParam == null || requestContextMapParam instanceof SdkAutoConstructMap) {
            map = DefaultSdkAutoConstructMap.getInstance();
        } else {
            Map<String, String> modifiableMap = new LinkedHashMap<>();
            requestContextMapParam.forEach((key, value) -> {
                modifiableMap.put(key, value);
            });
            map = Collections.unmodifiableMap(modifiableMap);
        }
        return map;
    }

    static Map<String, String> copyEnumToString(Map<RequestContextKey, String> requestContextMapParam) {
        Map<String, String> map;
        if (requestContextMapParam == null || requestContextMapParam instanceof SdkAutoConstructMap) {
            map = DefaultSdkAutoConstructMap.getInstance();
        } else {
            Map<String, String> modifiableMap = new LinkedHashMap<>();
            requestContextMapParam.forEach((key, value) -> {
                String result = key.toString();
                modifiableMap.put(result, value);
            });
            map = Collections.unmodifiableMap(modifiableMap);
        }
        return map;
    }

    static Map<RequestContextKey, String> copyStringToEnum(Map<String, String> requestContextMapParam) {
        Map<RequestContextKey, String> map;
        if (requestContextMapParam == null || requestContextMapParam instanceof SdkAutoConstructMap) {
            map = DefaultSdkAutoConstructMap.getInstance();
        } else {
            Map<RequestContextKey, String> modifiableMap = new LinkedHashMap<>();
            requestContextMapParam.forEach((key, value) -> {
                RequestContextKey result = RequestContextKey.fromValue(key);
                if (result != RequestContextKey.UNKNOWN_TO_SDK_VERSION) {
                    modifiableMap.put(result, value);
                }
            });
            map = Collections.unmodifiableMap(modifiableMap);
        }
        return map;
    }
}
