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
public final class BatchGetDatabaseErrorEntry implements SdkPojo, Serializable,
        ToCopyableBuilder<BatchGetDatabaseErrorEntry.Builder, BatchGetDatabaseErrorEntry> {
    private static final SdkField<String> DATABASE_IDENTIFIER_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("DatabaseIdentifier").getter(getter(BatchGetDatabaseErrorEntry::databaseIdentifier))
            .setter(setter(Builder::databaseIdentifier))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("DatabaseIdentifier").build())
            .build();

    private static final SdkField<String> DATABASE_NAME_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("DatabaseName").getter(getter(BatchGetDatabaseErrorEntry::databaseName))
            .setter(setter(Builder::databaseName))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("DatabaseName").build()).build();

    private static final SdkField<ErrorDetail> ERROR_FIELD = SdkField.<ErrorDetail> builder(MarshallingType.SDK_POJO)
            .memberName("Error").getter(getter(BatchGetDatabaseErrorEntry::error)).setter(setter(Builder::error))
            .constructor(ErrorDetail::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Error").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(DATABASE_IDENTIFIER_FIELD,
            DATABASE_NAME_FIELD, ERROR_FIELD));

    private static final long serialVersionUID = 1L;

    private final String databaseIdentifier;

    private final String databaseName;

    private final ErrorDetail error;

    private BatchGetDatabaseErrorEntry(BuilderImpl builder) {
        this.databaseIdentifier = builder.databaseIdentifier;
        this.databaseName = builder.databaseName;
        this.error = builder.error;
    }

    /**
     * Returns the value of the DatabaseIdentifier property for this object.
     * 
     * @return The value of the DatabaseIdentifier property for this object.
     */
    public final String databaseIdentifier() {
        return databaseIdentifier;
    }

    /**
     * Returns the value of the DatabaseName property for this object.
     * 
     * @return The value of the DatabaseName property for this object.
     */
    public final String databaseName() {
        return databaseName;
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
        hashCode = 31 * hashCode + Objects.hashCode(databaseIdentifier());
        hashCode = 31 * hashCode + Objects.hashCode(databaseName());
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
        if (!(obj instanceof BatchGetDatabaseErrorEntry)) {
            return false;
        }
        BatchGetDatabaseErrorEntry other = (BatchGetDatabaseErrorEntry) obj;
        return Objects.equals(databaseIdentifier(), other.databaseIdentifier())
                && Objects.equals(databaseName(), other.databaseName()) && Objects.equals(error(), other.error());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("BatchGetDatabaseErrorEntry").add("DatabaseIdentifier", databaseIdentifier())
                .add("DatabaseName", databaseName()).add("Error", error()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "DatabaseIdentifier":
            return Optional.ofNullable(clazz.cast(databaseIdentifier()));
        case "DatabaseName":
            return Optional.ofNullable(clazz.cast(databaseName()));
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

    private static <T> Function<Object, T> getter(Function<BatchGetDatabaseErrorEntry, T> g) {
        return obj -> g.apply((BatchGetDatabaseErrorEntry) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    public interface Builder extends SdkPojo, CopyableBuilder<Builder, BatchGetDatabaseErrorEntry> {
        /**
         * Sets the value of the DatabaseIdentifier property for this object.
         *
         * @param databaseIdentifier
         *        The new value for the DatabaseIdentifier property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder databaseIdentifier(String databaseIdentifier);

        /**
         * Sets the value of the DatabaseName property for this object.
         *
         * @param databaseName
         *        The new value for the DatabaseName property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder databaseName(String databaseName);

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
        private String databaseIdentifier;

        private String databaseName;

        private ErrorDetail error;

        private BuilderImpl() {
        }

        private BuilderImpl(BatchGetDatabaseErrorEntry model) {
            databaseIdentifier(model.databaseIdentifier);
            databaseName(model.databaseName);
            error(model.error);
        }

        public final String getDatabaseIdentifier() {
            return databaseIdentifier;
        }

        public final void setDatabaseIdentifier(String databaseIdentifier) {
            this.databaseIdentifier = databaseIdentifier;
        }

        @Override
        @Transient
        public final Builder databaseIdentifier(String databaseIdentifier) {
            this.databaseIdentifier = databaseIdentifier;
            return this;
        }

        public final String getDatabaseName() {
            return databaseName;
        }

        public final void setDatabaseName(String databaseName) {
            this.databaseName = databaseName;
        }

        @Override
        @Transient
        public final Builder databaseName(String databaseName) {
            this.databaseName = databaseName;
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
        public BatchGetDatabaseErrorEntry build() {
            return new BatchGetDatabaseErrorEntry(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }
}
