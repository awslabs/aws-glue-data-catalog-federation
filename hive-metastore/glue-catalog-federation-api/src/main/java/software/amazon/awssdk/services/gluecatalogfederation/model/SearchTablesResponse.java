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
public final class SearchTablesResponse extends GlueCatalogFederationResponse implements
        ToCopyableBuilder<SearchTablesResponse.Builder, SearchTablesResponse> {
    private static final SdkField<List<Table>> TABLES_FIELD = SdkField
            .<List<Table>> builder(MarshallingType.LIST)
            .memberName("Tables")
            .getter(getter(SearchTablesResponse::tables))
            .setter(setter(Builder::tables))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Tables").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<Table> builder(MarshallingType.SDK_POJO)
                                            .constructor(Table::builder)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").build()).build()).build()).build();

    private static final SdkField<String> NEXT_TOKEN_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("NextToken").getter(getter(SearchTablesResponse::nextToken)).setter(setter(Builder::nextToken))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("NextToken").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays
            .asList(TABLES_FIELD, NEXT_TOKEN_FIELD));

    private final List<Table> tables;

    private final String nextToken;

    private SearchTablesResponse(BuilderImpl builder) {
        super(builder);
        this.tables = builder.tables;
        this.nextToken = builder.nextToken;
    }

    /**
     * For responses, this returns true if the service returned a value for the Tables property. This DOES NOT check
     * that the value is non-empty (for which, you should check the {@code isEmpty()} method on the property). This is
     * useful because the SDK will never return a null collection or map, but you may need to differentiate between the
     * service returning nothing (or null) and the service returning an empty collection or map. For requests, this
     * returns true if a value for the property was specified in the request builder, and false if a value was not
     * specified.
     */
    public final boolean hasTables() {
        return tables != null && !(tables instanceof SdkAutoConstructList);
    }

    /**
     * Returns the value of the Tables property for this object.
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasTables} method.
     * </p>
     * 
     * @return The value of the Tables property for this object.
     */
    public final List<Table> tables() {
        return tables;
    }

    /**
     * Returns the value of the NextToken property for this object.
     * 
     * @return The value of the NextToken property for this object.
     */
    public final String nextToken() {
        return nextToken;
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
        hashCode = 31 * hashCode + Objects.hashCode(hasTables() ? tables() : null);
        hashCode = 31 * hashCode + Objects.hashCode(nextToken());
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
        if (!(obj instanceof SearchTablesResponse)) {
            return false;
        }
        SearchTablesResponse other = (SearchTablesResponse) obj;
        return hasTables() == other.hasTables() && Objects.equals(tables(), other.tables())
                && Objects.equals(nextToken(), other.nextToken());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("SearchTablesResponse").add("Tables", hasTables() ? tables() : null)
                .add("NextToken", nextToken()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Tables":
            return Optional.ofNullable(clazz.cast(tables()));
        case "NextToken":
            return Optional.ofNullable(clazz.cast(nextToken()));
        default:
            return Optional.empty();
        }
    }

    @Override
    public final List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    private static <T> Function<Object, T> getter(Function<SearchTablesResponse, T> g) {
        return obj -> g.apply((SearchTablesResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    public interface Builder extends GlueCatalogFederationResponse.Builder, SdkPojo,
            CopyableBuilder<Builder, SearchTablesResponse> {
        /**
         * Sets the value of the Tables property for this object.
         *
         * @param tables
         *        The new value for the Tables property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder tables(Collection<Table> tables);

        /**
         * Sets the value of the Tables property for this object.
         *
         * @param tables
         *        The new value for the Tables property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder tables(Table... tables);

        /**
         * Sets the value of the Tables property for this object.
         *
         * This is a convenience that creates an instance of the {@link List<Table>
         * .Builder} avoiding the need to create one manually via {@link List<Table>
         * #builder()}.
         *
         * When the {@link Consumer} completes, {@link List<Table>
         * .Builder#build()} is called immediately and its result is passed to {@link #tables(List
         * <Table>
         * )}.
         * 
         * @param tables
         *        a consumer that will call methods on {@link List<Table>
         *        .Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #tables(List
         *      <Table>
         *      )
         */
        Builder tables(Consumer<Table.Builder>... tables);

        /**
         * Sets the value of the NextToken property for this object.
         *
         * @param nextToken
         *        The new value for the NextToken property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder nextToken(String nextToken);
    }

    static final class BuilderImpl extends GlueCatalogFederationResponse.BuilderImpl implements Builder {
        private List<Table> tables = DefaultSdkAutoConstructList.getInstance();

        private String nextToken;

        private BuilderImpl() {
        }

        private BuilderImpl(SearchTablesResponse model) {
            super(model);
            tables(model.tables);
            nextToken(model.nextToken);
        }

        public final List<Table.Builder> getTables() {
            List<Table.Builder> result = TableListCopier.copyToBuilder(this.tables);
            if (result instanceof SdkAutoConstructList) {
                return null;
            }
            return result;
        }

        public final void setTables(Collection<Table.BuilderImpl> tables) {
            this.tables = TableListCopier.copyFromBuilder(tables);
        }

        @Override
        @Transient
        public final Builder tables(Collection<Table> tables) {
            this.tables = TableListCopier.copy(tables);
            return this;
        }

        @Override
        @Transient
        @SafeVarargs
        public final Builder tables(Table... tables) {
            tables(Arrays.asList(tables));
            return this;
        }

        @Override
        @Transient
        @SafeVarargs
        public final Builder tables(Consumer<Table.Builder>... tables) {
            tables(Stream.of(tables).map(c -> Table.builder().applyMutation(c).build()).collect(Collectors.toList()));
            return this;
        }

        public final String getNextToken() {
            return nextToken;
        }

        public final void setNextToken(String nextToken) {
            this.nextToken = nextToken;
        }

        @Override
        @Transient
        public final Builder nextToken(String nextToken) {
            this.nextToken = nextToken;
            return this;
        }

        @Override
        public SearchTablesResponse build() {
            return new SearchTablesResponse(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }
}
