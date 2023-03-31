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
public final class BatchGetTableResponse extends GlueCatalogFederationResponse implements
        ToCopyableBuilder<BatchGetTableResponse.Builder, BatchGetTableResponse> {
    private static final SdkField<List<Table>> TABLE_LIST_FIELD = SdkField
            .<List<Table>> builder(MarshallingType.LIST)
            .memberName("TableList")
            .getter(getter(BatchGetTableResponse::tableList))
            .setter(setter(Builder::tableList))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("TableList").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<Table> builder(MarshallingType.SDK_POJO)
                                            .constructor(Table::builder)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").build()).build()).build()).build();

    private static final SdkField<List<BatchGetTableErrorEntry>> ERRORS_FIELD = SdkField
            .<List<BatchGetTableErrorEntry>> builder(MarshallingType.LIST)
            .memberName("Errors")
            .getter(getter(BatchGetTableResponse::errors))
            .setter(setter(Builder::errors))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Errors").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<BatchGetTableErrorEntry> builder(MarshallingType.SDK_POJO)
                                            .constructor(BatchGetTableErrorEntry::builder)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").build()).build()).build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays
            .asList(TABLE_LIST_FIELD, ERRORS_FIELD));

    private final List<Table> tableList;

    private final List<BatchGetTableErrorEntry> errors;

    private BatchGetTableResponse(BuilderImpl builder) {
        super(builder);
        this.tableList = builder.tableList;
        this.errors = builder.errors;
    }

    /**
     * For responses, this returns true if the service returned a value for the TableList property. This DOES NOT check
     * that the value is non-empty (for which, you should check the {@code isEmpty()} method on the property). This is
     * useful because the SDK will never return a null collection or map, but you may need to differentiate between the
     * service returning nothing (or null) and the service returning an empty collection or map. For requests, this
     * returns true if a value for the property was specified in the request builder, and false if a value was not
     * specified.
     */
    public final boolean hasTableList() {
        return tableList != null && !(tableList instanceof SdkAutoConstructList);
    }

    /**
     * Returns the value of the TableList property for this object.
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasTableList} method.
     * </p>
     * 
     * @return The value of the TableList property for this object.
     */
    public final List<Table> tableList() {
        return tableList;
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
    public final List<BatchGetTableErrorEntry> errors() {
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
        hashCode = 31 * hashCode + Objects.hashCode(hasTableList() ? tableList() : null);
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
        if (!(obj instanceof BatchGetTableResponse)) {
            return false;
        }
        BatchGetTableResponse other = (BatchGetTableResponse) obj;
        return hasTableList() == other.hasTableList() && Objects.equals(tableList(), other.tableList())
                && hasErrors() == other.hasErrors() && Objects.equals(errors(), other.errors());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("BatchGetTableResponse").add("TableList", hasTableList() ? tableList() : null)
                .add("Errors", hasErrors() ? errors() : null).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "TableList":
            return Optional.ofNullable(clazz.cast(tableList()));
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

    private static <T> Function<Object, T> getter(Function<BatchGetTableResponse, T> g) {
        return obj -> g.apply((BatchGetTableResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    public interface Builder extends GlueCatalogFederationResponse.Builder, SdkPojo,
            CopyableBuilder<Builder, BatchGetTableResponse> {
        /**
         * Sets the value of the TableList property for this object.
         *
         * @param tableList
         *        The new value for the TableList property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder tableList(Collection<Table> tableList);

        /**
         * Sets the value of the TableList property for this object.
         *
         * @param tableList
         *        The new value for the TableList property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder tableList(Table... tableList);

        /**
         * Sets the value of the TableList property for this object.
         *
         * This is a convenience that creates an instance of the {@link List<Table>
         * .Builder} avoiding the need to create one manually via {@link List<Table>
         * #builder()}.
         *
         * When the {@link Consumer} completes, {@link List<Table>
         * .Builder#build()} is called immediately and its result is passed to {@link #tableList(List
         * <Table>
         * )}.
         * 
         * @param tableList
         *        a consumer that will call methods on {@link List<Table>
         *        .Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #tableList(List
         *      <Table>
         *      )
         */
        Builder tableList(Consumer<Table.Builder>... tableList);

        /**
         * Sets the value of the Errors property for this object.
         *
         * @param errors
         *        The new value for the Errors property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder errors(Collection<BatchGetTableErrorEntry> errors);

        /**
         * Sets the value of the Errors property for this object.
         *
         * @param errors
         *        The new value for the Errors property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder errors(BatchGetTableErrorEntry... errors);

        /**
         * Sets the value of the Errors property for this object.
         *
         * This is a convenience that creates an instance of the {@link List<BatchGetTableErrorEntry>.Builder} avoiding
         * the need to create one manually via {@link List<BatchGetTableErrorEntry>#builder()}.
         *
         * When the {@link Consumer} completes, {@link List<BatchGetTableErrorEntry>.Builder#build()} is called
         * immediately and its result is passed to {@link #errors(List<BatchGetTableErrorEntry>)}.
         * 
         * @param errors
         *        a consumer that will call methods on {@link List<BatchGetTableErrorEntry>.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #errors(List<BatchGetTableErrorEntry>)
         */
        Builder errors(Consumer<BatchGetTableErrorEntry.Builder>... errors);
    }

    static final class BuilderImpl extends GlueCatalogFederationResponse.BuilderImpl implements Builder {
        private List<Table> tableList = DefaultSdkAutoConstructList.getInstance();

        private List<BatchGetTableErrorEntry> errors = DefaultSdkAutoConstructList.getInstance();

        private BuilderImpl() {
        }

        private BuilderImpl(BatchGetTableResponse model) {
            super(model);
            tableList(model.tableList);
            errors(model.errors);
        }

        public final List<Table.Builder> getTableList() {
            List<Table.Builder> result = TableListCopier.copyToBuilder(this.tableList);
            if (result instanceof SdkAutoConstructList) {
                return null;
            }
            return result;
        }

        public final void setTableList(Collection<Table.BuilderImpl> tableList) {
            this.tableList = TableListCopier.copyFromBuilder(tableList);
        }

        @Override
        @Transient
        public final Builder tableList(Collection<Table> tableList) {
            this.tableList = TableListCopier.copy(tableList);
            return this;
        }

        @Override
        @Transient
        @SafeVarargs
        public final Builder tableList(Table... tableList) {
            tableList(Arrays.asList(tableList));
            return this;
        }

        @Override
        @Transient
        @SafeVarargs
        public final Builder tableList(Consumer<Table.Builder>... tableList) {
            tableList(Stream.of(tableList).map(c -> Table.builder().applyMutation(c).build()).collect(Collectors.toList()));
            return this;
        }

        public final List<BatchGetTableErrorEntry.Builder> getErrors() {
            List<BatchGetTableErrorEntry.Builder> result = BatchGetTableErrorListCopier.copyToBuilder(this.errors);
            if (result instanceof SdkAutoConstructList) {
                return null;
            }
            return result;
        }

        public final void setErrors(Collection<BatchGetTableErrorEntry.BuilderImpl> errors) {
            this.errors = BatchGetTableErrorListCopier.copyFromBuilder(errors);
        }

        @Override
        @Transient
        public final Builder errors(Collection<BatchGetTableErrorEntry> errors) {
            this.errors = BatchGetTableErrorListCopier.copy(errors);
            return this;
        }

        @Override
        @Transient
        @SafeVarargs
        public final Builder errors(BatchGetTableErrorEntry... errors) {
            errors(Arrays.asList(errors));
            return this;
        }

        @Override
        @Transient
        @SafeVarargs
        public final Builder errors(Consumer<BatchGetTableErrorEntry.Builder>... errors) {
            errors(Stream.of(errors).map(c -> BatchGetTableErrorEntry.builder().applyMutation(c).build())
                    .collect(Collectors.toList()));
            return this;
        }

        @Override
        public BatchGetTableResponse build() {
            return new BatchGetTableResponse(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }
}
