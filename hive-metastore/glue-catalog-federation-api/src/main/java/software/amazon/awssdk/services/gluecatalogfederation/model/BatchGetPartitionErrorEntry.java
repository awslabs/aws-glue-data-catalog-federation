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

import java.beans.Transient;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import software.amazon.awssdk.annotations.Generated;
import software.amazon.awssdk.core.SdkField;
import software.amazon.awssdk.core.SdkPojo;
import software.amazon.awssdk.core.protocol.MarshallLocation;
import software.amazon.awssdk.core.protocol.MarshallingType;
import software.amazon.awssdk.core.traits.LocationTrait;
import software.amazon.awssdk.utils.ToString;
import software.amazon.awssdk.utils.builder.CopyableBuilder;
import software.amazon.awssdk.utils.builder.ToCopyableBuilder;

/**
 */
@Generated("software.amazon.awssdk:codegen")
public final class BatchGetPartitionErrorEntry implements SdkPojo, Serializable,
        ToCopyableBuilder<BatchGetPartitionErrorEntry.Builder, BatchGetPartitionErrorEntry> {
    private static final SdkField<PartitionValue> PARTITION_VALUE_FIELD = SdkField
            .<PartitionValue> builder(MarshallingType.SDK_POJO).memberName("PartitionValue")
            .getter(getter(BatchGetPartitionErrorEntry::partitionValue)).setter(setter(Builder::partitionValue))
            .constructor(PartitionValue::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("PartitionValue").build()).build();

    private static final SdkField<ErrorDetail> ERROR_FIELD = SdkField.<ErrorDetail> builder(MarshallingType.SDK_POJO)
            .memberName("Error").getter(getter(BatchGetPartitionErrorEntry::error)).setter(setter(Builder::error))
            .constructor(ErrorDetail::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Error").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(PARTITION_VALUE_FIELD,
            ERROR_FIELD));

    private static final long serialVersionUID = 1L;

    private final PartitionValue partitionValue;

    private final ErrorDetail error;

    private BatchGetPartitionErrorEntry(BuilderImpl builder) {
        this.partitionValue = builder.partitionValue;
        this.error = builder.error;
    }

    /**
     * Returns the value of the PartitionValue property for this object.
     * 
     * @return The value of the PartitionValue property for this object.
     */
    public final PartitionValue partitionValue() {
        return partitionValue;
    }

    /**
     * Returns the value of the Error property for this object.
     * 
     * @return The value of the Error property for this object.
     */
    public final ErrorDetail error() {
        return error;
    }

    @Override
    public Builder toBuilder() {
        return new BuilderImpl(this);
    }

    public static Builder builder() {
        return new BuilderImpl();
    }

    public static Class<? extends Builder> serializableBuilderClass() {
        return BuilderImpl.class;
    }

    @Override
    public final int hashCode() {
        int hashCode = 1;
        hashCode = 31 * hashCode + Objects.hashCode(partitionValue());
        hashCode = 31 * hashCode + Objects.hashCode(error());
        return hashCode;
    }

    @Override
    public final boolean equals(Object obj) {
        return equalsBySdkFields(obj);
    }

    @Override
    public final boolean equalsBySdkFields(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof BatchGetPartitionErrorEntry)) {
            return false;
        }
        BatchGetPartitionErrorEntry other = (BatchGetPartitionErrorEntry) obj;
        return Objects.equals(partitionValue(), other.partitionValue()) && Objects.equals(error(), other.error());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("BatchGetPartitionErrorEntry").add("PartitionValue", partitionValue()).add("Error", error())
                .build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "PartitionValue":
            return Optional.ofNullable(clazz.cast(partitionValue()));
        case "Error":
            return Optional.ofNullable(clazz.cast(error()));
        default:
            return Optional.empty();
        }
    }

    @Override
    public final List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    private static <T> Function<Object, T> getter(Function<BatchGetPartitionErrorEntry, T> g) {
        return obj -> g.apply((BatchGetPartitionErrorEntry) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    public interface Builder extends SdkPojo, CopyableBuilder<Builder, BatchGetPartitionErrorEntry> {
        /**
         * Sets the value of the PartitionValue property for this object.
         *
         * @param partitionValue
         *        The new value for the PartitionValue property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder partitionValue(PartitionValue partitionValue);

        /**
         * Sets the value of the PartitionValue property for this object.
         *
         * This is a convenience that creates an instance of the {@link PartitionValue.Builder} avoiding the need to
         * create one manually via {@link PartitionValue#builder()}.
         *
         * When the {@link Consumer} completes, {@link PartitionValue.Builder#build()} is called immediately and its
         * result is passed to {@link #partitionValue(PartitionValue)}.
         * 
         * @param partitionValue
         *        a consumer that will call methods on {@link PartitionValue.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #partitionValue(PartitionValue)
         */
        default Builder partitionValue(Consumer<PartitionValue.Builder> partitionValue) {
            return partitionValue(PartitionValue.builder().applyMutation(partitionValue).build());
        }

        /**
         * Sets the value of the Error property for this object.
         *
         * @param error
         *        The new value for the Error property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder error(ErrorDetail error);

        /**
         * Sets the value of the Error property for this object.
         *
         * This is a convenience that creates an instance of the {@link ErrorDetail.Builder} avoiding the need to create
         * one manually via {@link ErrorDetail#builder()}.
         *
         * When the {@link Consumer} completes, {@link ErrorDetail.Builder#build()} is called immediately and its result
         * is passed to {@link #error(ErrorDetail)}.
         * 
         * @param error
         *        a consumer that will call methods on {@link ErrorDetail.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #error(ErrorDetail)
         */
        default Builder error(Consumer<ErrorDetail.Builder> error) {
            return error(ErrorDetail.builder().applyMutation(error).build());
        }
    }

    static final class BuilderImpl implements Builder {
        private PartitionValue partitionValue;

        private ErrorDetail error;

        private BuilderImpl() {
        }

        private BuilderImpl(BatchGetPartitionErrorEntry model) {
            partitionValue(model.partitionValue);
            error(model.error);
        }

        public final PartitionValue.Builder getPartitionValue() {
            return partitionValue != null ? partitionValue.toBuilder() : null;
        }

        public final void setPartitionValue(PartitionValue.BuilderImpl partitionValue) {
            this.partitionValue = partitionValue != null ? partitionValue.build() : null;
        }

        @Override
        @Transient
        public final Builder partitionValue(PartitionValue partitionValue) {
            this.partitionValue = partitionValue;
            return this;
        }

        public final ErrorDetail.Builder getError() {
            return error != null ? error.toBuilder() : null;
        }

        public final void setError(ErrorDetail.BuilderImpl error) {
            this.error = error != null ? error.build() : null;
        }

        @Override
        @Transient
        public final Builder error(ErrorDetail error) {
            this.error = error;
            return this;
        }

        @Override
        public BatchGetPartitionErrorEntry build() {
            return new BatchGetPartitionErrorEntry(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }
}
