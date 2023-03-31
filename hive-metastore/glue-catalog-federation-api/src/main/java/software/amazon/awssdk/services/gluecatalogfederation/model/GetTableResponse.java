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
public final class GetTableResponse extends GlueCatalogFederationResponse implements
        ToCopyableBuilder<GetTableResponse.Builder, GetTableResponse> {
    private static final SdkField<Table> TABLE_FIELD = SdkField.<Table> builder(MarshallingType.SDK_POJO).memberName("Table")
            .getter(getter(GetTableResponse::table)).setter(setter(Builder::table)).constructor(Table::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Table").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(TABLE_FIELD));

    private final Table table;

    private GetTableResponse(BuilderImpl builder) {
        super(builder);
        this.table = builder.table;
    }

    /**
     * Returns the value of the Table property for this object.
     * 
     * @return The value of the Table property for this object.
     */
    public final Table table() {
        return table;
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
        hashCode = 31 * hashCode + Objects.hashCode(table());
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
        if (!(obj instanceof GetTableResponse)) {
            return false;
        }
        GetTableResponse other = (GetTableResponse) obj;
        return Objects.equals(table(), other.table());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("GetTableResponse").add("Table", table()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Table":
            return Optional.ofNullable(clazz.cast(table()));
        default:
            return Optional.empty();
        }
    }

    @Override
    public final List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    private static <T> Function<Object, T> getter(Function<GetTableResponse, T> g) {
        return obj -> g.apply((GetTableResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    public interface Builder extends GlueCatalogFederationResponse.Builder, SdkPojo, CopyableBuilder<Builder, GetTableResponse> {
        /**
         * Sets the value of the Table property for this object.
         *
         * @param table
         *        The new value for the Table property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder table(Table table);

        /**
         * Sets the value of the Table property for this object.
         *
         * This is a convenience that creates an instance of the {@link Table.Builder} avoiding the need to create one
         * manually via {@link Table#builder()}.
         *
         * When the {@link Consumer} completes, {@link Table.Builder#build()} is called immediately and its result is
         * passed to {@link #table(Table)}.
         * 
         * @param table
         *        a consumer that will call methods on {@link Table.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #table(Table)
         */
        default Builder table(Consumer<Table.Builder> table) {
            return table(Table.builder().applyMutation(table).build());
        }
    }

    static final class BuilderImpl extends GlueCatalogFederationResponse.BuilderImpl implements Builder {
        private Table table;

        private BuilderImpl() {
        }

        private BuilderImpl(GetTableResponse model) {
            super(model);
            table(model.table);
        }

        public final Table.Builder getTable() {
            return table != null ? table.toBuilder() : null;
        }

        public final void setTable(Table.BuilderImpl table) {
            this.table = table != null ? table.build() : null;
        }

        @Override
        @Transient
        public final Builder table(Table table) {
            this.table = table;
            return this;
        }

        @Override
        public GetTableResponse build() {
            return new GetTableResponse(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }
}
