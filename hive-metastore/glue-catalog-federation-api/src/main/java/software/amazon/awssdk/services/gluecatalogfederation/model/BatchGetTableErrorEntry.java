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
public final class BatchGetTableErrorEntry implements SdkPojo, Serializable,
        ToCopyableBuilder<BatchGetTableErrorEntry.Builder, BatchGetTableErrorEntry> {
    private static final SdkField<BatchGetTableEntry> BATCH_GET_TABLE_ENTRY_FIELD = SdkField
            .<BatchGetTableEntry> builder(MarshallingType.SDK_POJO).memberName("BatchGetTableEntry")
            .getter(getter(BatchGetTableErrorEntry::batchGetTableEntry)).setter(setter(Builder::batchGetTableEntry))
            .constructor(BatchGetTableEntry::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("BatchGetTableEntry").build())
            .build();

    private static final SdkField<ErrorDetail> ERROR_FIELD = SdkField.<ErrorDetail> builder(MarshallingType.SDK_POJO)
            .memberName("Error").getter(getter(BatchGetTableErrorEntry::error)).setter(setter(Builder::error))
            .constructor(ErrorDetail::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Error").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(BATCH_GET_TABLE_ENTRY_FIELD,
            ERROR_FIELD));

    private static final long serialVersionUID = 1L;

    private final BatchGetTableEntry batchGetTableEntry;

    private final ErrorDetail error;

    private BatchGetTableErrorEntry(BuilderImpl builder) {
        this.batchGetTableEntry = builder.batchGetTableEntry;
        this.error = builder.error;
    }

    /**
     * Returns the value of the BatchGetTableEntry property for this object.
     * 
     * @return The value of the BatchGetTableEntry property for this object.
     */
    public final BatchGetTableEntry batchGetTableEntry() {
        return batchGetTableEntry;
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
        hashCode = 31 * hashCode + Objects.hashCode(batchGetTableEntry());
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
        if (!(obj instanceof BatchGetTableErrorEntry)) {
            return false;
        }
        BatchGetTableErrorEntry other = (BatchGetTableErrorEntry) obj;
        return Objects.equals(batchGetTableEntry(), other.batchGetTableEntry()) && Objects.equals(error(), other.error());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("BatchGetTableErrorEntry").add("BatchGetTableEntry", batchGetTableEntry()).add("Error", error())
                .build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "BatchGetTableEntry":
            return Optional.ofNullable(clazz.cast(batchGetTableEntry()));
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

    private static <T> Function<Object, T> getter(Function<BatchGetTableErrorEntry, T> g) {
        return obj -> g.apply((BatchGetTableErrorEntry) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    public interface Builder extends SdkPojo, CopyableBuilder<Builder, BatchGetTableErrorEntry> {
        /**
         * Sets the value of the BatchGetTableEntry property for this object.
         *
         * @param batchGetTableEntry
         *        The new value for the BatchGetTableEntry property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder batchGetTableEntry(BatchGetTableEntry batchGetTableEntry);

        /**
         * Sets the value of the BatchGetTableEntry property for this object.
         *
         * This is a convenience that creates an instance of the {@link BatchGetTableEntry.Builder} avoiding the need to
         * create one manually via {@link BatchGetTableEntry#builder()}.
         *
         * When the {@link Consumer} completes, {@link BatchGetTableEntry.Builder#build()} is called immediately and its
         * result is passed to {@link #batchGetTableEntry(BatchGetTableEntry)}.
         * 
         * @param batchGetTableEntry
         *        a consumer that will call methods on {@link BatchGetTableEntry.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #batchGetTableEntry(BatchGetTableEntry)
         */
        default Builder batchGetTableEntry(Consumer<BatchGetTableEntry.Builder> batchGetTableEntry) {
            return batchGetTableEntry(BatchGetTableEntry.builder().applyMutation(batchGetTableEntry).build());
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
        private BatchGetTableEntry batchGetTableEntry;

        private ErrorDetail error;

        private BuilderImpl() {
        }

        private BuilderImpl(BatchGetTableErrorEntry model) {
            batchGetTableEntry(model.batchGetTableEntry);
            error(model.error);
        }

        public final BatchGetTableEntry.Builder getBatchGetTableEntry() {
            return batchGetTableEntry != null ? batchGetTableEntry.toBuilder() : null;
        }

        public final void setBatchGetTableEntry(BatchGetTableEntry.BuilderImpl batchGetTableEntry) {
            this.batchGetTableEntry = batchGetTableEntry != null ? batchGetTableEntry.build() : null;
        }

        @Override
        @Transient
        public final Builder batchGetTableEntry(BatchGetTableEntry batchGetTableEntry) {
            this.batchGetTableEntry = batchGetTableEntry;
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
        public BatchGetTableErrorEntry build() {
            return new BatchGetTableErrorEntry(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }
}
