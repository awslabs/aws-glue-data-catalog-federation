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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import software.amazon.awssdk.annotations.Generated;
import software.amazon.awssdk.core.util.DefaultSdkAutoConstructList;
import software.amazon.awssdk.core.util.SdkAutoConstructList;

@Generated("software.amazon.awssdk:codegen")
final class BatchGetDatabaseErrorListCopier {
    static List<BatchGetDatabaseErrorEntry> copy(Collection<? extends BatchGetDatabaseErrorEntry> batchGetDatabaseErrorListParam) {
        List<BatchGetDatabaseErrorEntry> list;
        if (batchGetDatabaseErrorListParam == null || batchGetDatabaseErrorListParam instanceof SdkAutoConstructList) {
            list = DefaultSdkAutoConstructList.getInstance();
        } else {
            List<BatchGetDatabaseErrorEntry> modifiableList = new ArrayList<>();
            batchGetDatabaseErrorListParam.forEach(entry -> {
                modifiableList.add(entry);
            });
            list = Collections.unmodifiableList(modifiableList);
        }
        return list;
    }

    static List<BatchGetDatabaseErrorEntry> copyFromBuilder(
            Collection<? extends BatchGetDatabaseErrorEntry.Builder> batchGetDatabaseErrorListParam) {
        List<BatchGetDatabaseErrorEntry> list;
        if (batchGetDatabaseErrorListParam == null || batchGetDatabaseErrorListParam instanceof SdkAutoConstructList) {
            list = DefaultSdkAutoConstructList.getInstance();
        } else {
            List<BatchGetDatabaseErrorEntry> modifiableList = new ArrayList<>();
            batchGetDatabaseErrorListParam.forEach(entry -> {
                BatchGetDatabaseErrorEntry member = entry.build();
                modifiableList.add(member);
            });
            list = Collections.unmodifiableList(modifiableList);
        }
        return list;
    }

    static List<BatchGetDatabaseErrorEntry.Builder> copyToBuilder(
            Collection<? extends BatchGetDatabaseErrorEntry> batchGetDatabaseErrorListParam) {
        List<BatchGetDatabaseErrorEntry.Builder> list;
        if (batchGetDatabaseErrorListParam == null || batchGetDatabaseErrorListParam instanceof SdkAutoConstructList) {
            list = DefaultSdkAutoConstructList.getInstance();
        } else {
            List<BatchGetDatabaseErrorEntry.Builder> modifiableList = new ArrayList<>();
            batchGetDatabaseErrorListParam.forEach(entry -> {
                BatchGetDatabaseErrorEntry.Builder member = entry.toBuilder();
                modifiableList.add(member);
            });
            list = Collections.unmodifiableList(modifiableList);
        }
        return list;
    }
}
