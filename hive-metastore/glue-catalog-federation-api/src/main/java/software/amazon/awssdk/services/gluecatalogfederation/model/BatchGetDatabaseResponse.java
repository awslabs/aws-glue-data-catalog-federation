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
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import software.amazon.awssdk.annotations.Generated;
import software.amazon.awssdk.core.SdkField;
import software.amazon.awssdk.core.SdkPojo;
import software.amazon.awssdk.core.protocol.MarshallLocation;
import software.amazon.awssdk.core.protocol.MarshallingType;
import software.amazon.awssdk.core.traits.ListTrait;
import software.amazon.awssdk.core.traits.LocationTrait;
import software.amazon.awssdk.core.util.DefaultSdkAutoConstructList;
import software.amazon.awssdk.core.util.SdkAutoConstructList;
import software.amazon.awssdk.utils.ToString;
import software.amazon.awssdk.utils.builder.CopyableBuilder;
import software.amazon.awssdk.utils.builder.ToCopyableBuilder;

/**
 */
@Generated("software.amazon.awssdk:codegen")
public final class BatchGetDatabaseResponse extends GlueCatalogFederationResponse implements
        ToCopyableBuilder<BatchGetDatabaseResponse.Builder, BatchGetDatabaseResponse> {
    private static final SdkField<List<Database>> DATABASES_FIELD = SdkField
            .<List<Database>> builder(MarshallingType.LIST)
            .memberName("Databases")
            .getter(getter(BatchGetDatabaseResponse::databases))
            .setter(setter(Builder::databases))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Databases").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<Database> builder(MarshallingType.SDK_POJO)
                                            .constructor(Database::builder)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").build()).build()).build()).build();

    private static final SdkField<List<BatchGetDatabaseErrorEntry>> ERRORS_FIELD = SdkField
            .<List<BatchGetDatabaseErrorEntry>> builder(MarshallingType.LIST)
            .memberName("Errors")
            .getter(getter(BatchGetDatabaseResponse::errors))
            .setter(setter(Builder::errors))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Errors").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<BatchGetDatabaseErrorEntry> builder(MarshallingType.SDK_POJO)
                                            .constructor(BatchGetDatabaseErrorEntry::builder)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").build()).build()).build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections
            .unmodifiableList(Arrays.asList(DATABASES_FIELD, ERRORS_FIELD));

    private final List<Database> databases;

    private final List<BatchGetDatabaseErrorEntry> errors;

    private BatchGetDatabaseResponse(BuilderImpl builder) {
        super(builder);
        this.databases = builder.databases;
        this.errors = builder.errors;
    }

    /**
     * For responses, this returns true if the service returned a value for the Databases property. This DOES NOT check
     * that the value is non-empty (for which, you should check the {@code isEmpty()} method on the property). This is
     * useful because the SDK will never return a null collection or map, but you may need to differentiate between the
     * service returning nothing (or null) and the service returning an empty collection or map. For requests, this
     * returns true if a value for the property was specified in the request builder, and false if a value was not
     * specified.
     */
    public final boolean hasDatabases() {
        return databases != null && !(databases instanceof SdkAutoConstructList);
    }

    /**
     * Returns the value of the Databases property for this object.
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasDatabases} method.
     * </p>
     * 
     * @return The value of the Databases property for this object.
     */
    public final List<Database> databases() {
        return databases;
    }

    /**
     * For responses, this returns true if the service returned a value for the Errors property. This DOES NOT check
     * that the value is non-empty (for which, you should check the {@code isEmpty()} method on the property). This is
     * useful because the SDK will never return a null collection or map, but you may need to differentiate between the
     * service returning nothing (or null) and the service returning an empty collection or map. For requests, this
     * returns true if a value for the property was specified in the request builder, and false if a value was not
     * specified.
     */
    public final boolean hasErrors() {
        return errors != null && !(errors instanceof SdkAutoConstructList);
    }

    /**
     * Returns the value of the Errors property for this object.
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasErrors} method.
     * </p>
     * 
     * @return The value of the Errors property for this object.
     */
    public final List<BatchGetDatabaseErrorEntry> errors() {
        return errors;
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
        hashCode = 31 * hashCode + super.hashCode();
        hashCode = 31 * hashCode + Objects.hashCode(hasDatabases() ? databases() : null);
        hashCode = 31 * hashCode + Objects.hashCode(hasErrors() ? errors() : null);
        return hashCode;
    }

    @Override
    public final boolean equals(Object obj) {
        return super.equals(obj) && equalsBySdkFields(obj);
    }

    @Override
    public final boolean equalsBySdkFields(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof BatchGetDatabaseResponse)) {
            return false;
        }
        BatchGetDatabaseResponse other = (BatchGetDatabaseResponse) obj;
        return hasDatabases() == other.hasDatabases() && Objects.equals(databases(), other.databases())
                && hasErrors() == other.hasErrors() && Objects.equals(errors(), other.errors());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("BatchGetDatabaseResponse").add("Databases", hasDatabases() ? databases() : null)
                .add("Errors", hasErrors() ? errors() : null).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Databases":
            return Optional.ofNullable(clazz.cast(databases()));
        case "Errors":
            return Optional.ofNullable(clazz.cast(errors()));
        default:
            return Optional.empty();
        }
    }

    @Override
    public final List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    private static <T> Function<Object, T> getter(Function<BatchGetDatabaseResponse, T> g) {
        return obj -> g.apply((BatchGetDatabaseResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    public interface Builder extends GlueCatalogFederationResponse.Builder, SdkPojo,
            CopyableBuilder<Builder, BatchGetDatabaseResponse> {
        /**
         * Sets the value of the Databases property for this object.
         *
         * @param databases
         *        The new value for the Databases property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder databases(Collection<Database> databases);

        /**
         * Sets the value of the Databases property for this object.
         *
         * @param databases
         *        The new value for the Databases property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder databases(Database... databases);

        /**
         * Sets the value of the Databases property for this object.
         *
         * This is a convenience that creates an instance of the {@link List<Database>.Builder} avoiding the need to
         * create one manually via {@link List<Database>#builder()}.
         *
         * When the {@link Consumer} completes, {@link List<Database>.Builder#build()} is called immediately and its
         * result is passed to {@link #databases(List<Database>)}.
         * 
         * @param databases
         *        a consumer that will call methods on {@link List<Database>.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #databases(List<Database>)
         */
        Builder databases(Consumer<Database.Builder>... databases);

        /**
         * Sets the value of the Errors property for this object.
         *
         * @param errors
         *        The new value for the Errors property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder errors(Collection<BatchGetDatabaseErrorEntry> errors);

        /**
         * Sets the value of the Errors property for this object.
         *
         * @param errors
         *        The new value for the Errors property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder errors(BatchGetDatabaseErrorEntry... errors);

        /**
         * Sets the value of the Errors property for this object.
         *
         * This is a convenience that creates an instance of the {@link List<BatchGetDatabaseErrorEntry>.Builder}
         * avoiding the need to create one manually via {@link List<BatchGetDatabaseErrorEntry>#builder()}.
         *
         * When the {@link Consumer} completes, {@link List<BatchGetDatabaseErrorEntry>.Builder#build()} is called
         * immediately and its result is passed to {@link #errors(List<BatchGetDatabaseErrorEntry>)}.
         * 
         * @param errors
         *        a consumer that will call methods on {@link List<BatchGetDatabaseErrorEntry>.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #errors(List<BatchGetDatabaseErrorEntry>)
         */
        Builder errors(Consumer<BatchGetDatabaseErrorEntry.Builder>... errors);
    }

    static final class BuilderImpl extends GlueCatalogFederationResponse.BuilderImpl implements Builder {
        private List<Database> databases = DefaultSdkAutoConstructList.getInstance();

        private List<BatchGetDatabaseErrorEntry> errors = DefaultSdkAutoConstructList.getInstance();

        private BuilderImpl() {
        }

        private BuilderImpl(BatchGetDatabaseResponse model) {
            super(model);
            databases(model.databases);
            errors(model.errors);
        }

        public final List<Database.Builder> getDatabases() {
            List<Database.Builder> result = DatabaseListCopier.copyToBuilder(this.databases);
            if (result instanceof SdkAutoConstructList) {
                return null;
            }
            return result;
        }

        public final void setDatabases(Collection<Database.BuilderImpl> databases) {
            this.databases = DatabaseListCopier.copyFromBuilder(databases);
        }

        @Override
        @Transient
        public final Builder databases(Collection<Database> databases) {
            this.databases = DatabaseListCopier.copy(databases);
            return this;
        }

        @Override
        @Transient
        @SafeVarargs
        public final Builder databases(Database... databases) {
            databases(Arrays.asList(databases));
            return this;
        }

        @Override
        @Transient
        @SafeVarargs
        public final Builder databases(Consumer<Database.Builder>... databases) {
            databases(Stream.of(databases).map(c -> Database.builder().applyMutation(c).build()).collect(Collectors.toList()));
            return this;
        }

        public final List<BatchGetDatabaseErrorEntry.Builder> getErrors() {
            List<BatchGetDatabaseErrorEntry.Builder> result = BatchGetDatabaseErrorListCopier.copyToBuilder(this.errors);
            if (result instanceof SdkAutoConstructList) {
                return null;
            }
            return result;
        }

        public final void setErrors(Collection<BatchGetDatabaseErrorEntry.BuilderImpl> errors) {
            this.errors = BatchGetDatabaseErrorListCopier.copyFromBuilder(errors);
        }

        @Override
        @Transient
        public final Builder errors(Collection<BatchGetDatabaseErrorEntry> errors) {
            this.errors = BatchGetDatabaseErrorListCopier.copy(errors);
            return this;
        }

        @Override
        @Transient
        @SafeVarargs
        public final Builder errors(BatchGetDatabaseErrorEntry... errors) {
            errors(Arrays.asList(errors));
            return this;
        }

        @Override
        @Transient
        @SafeVarargs
        public final Builder errors(Consumer<BatchGetDatabaseErrorEntry.Builder>... errors) {
            errors(Stream.of(errors).map(c -> BatchGetDatabaseErrorEntry.builder().applyMutation(c).build())
                    .collect(Collectors.toList()));
            return this;
        }

        @Override
        public BatchGetDatabaseResponse build() {
            return new BatchGetDatabaseResponse(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }
}
