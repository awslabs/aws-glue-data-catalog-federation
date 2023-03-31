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
public final class GetDatabaseResponse extends GlueCatalogFederationResponse implements
        ToCopyableBuilder<GetDatabaseResponse.Builder, GetDatabaseResponse> {
    private static final SdkField<Database> DATABASE_FIELD = SdkField.<Database> builder(MarshallingType.SDK_POJO)
            .memberName("Database").getter(getter(GetDatabaseResponse::database)).setter(setter(Builder::database))
            .constructor(Database::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Database").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(DATABASE_FIELD));

    private final Database database;

    private GetDatabaseResponse(BuilderImpl builder) {
        super(builder);
        this.database = builder.database;
    }

    /**
     * Returns the value of the Database property for this object.
     * 
     * @return The value of the Database property for this object.
     */
    public final Database database() {
        return database;
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
        hashCode = 31 * hashCode + Objects.hashCode(database());
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
        if (!(obj instanceof GetDatabaseResponse)) {
            return false;
        }
        GetDatabaseResponse other = (GetDatabaseResponse) obj;
        return Objects.equals(database(), other.database());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("GetDatabaseResponse").add("Database", database()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Database":
            return Optional.ofNullable(clazz.cast(database()));
        default:
            return Optional.empty();
        }
    }

    @Override
    public final List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    private static <T> Function<Object, T> getter(Function<GetDatabaseResponse, T> g) {
        return obj -> g.apply((GetDatabaseResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    public interface Builder extends GlueCatalogFederationResponse.Builder, SdkPojo,
            CopyableBuilder<Builder, GetDatabaseResponse> {
        /**
         * Sets the value of the Database property for this object.
         *
         * @param database
         *        The new value for the Database property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder database(Database database);

        /**
         * Sets the value of the Database property for this object.
         *
         * This is a convenience that creates an instance of the {@link Database.Builder} avoiding the need to create
         * one manually via {@link Database#builder()}.
         *
         * When the {@link Consumer} completes, {@link Database.Builder#build()} is called immediately and its result is
         * passed to {@link #database(Database)}.
         * 
         * @param database
         *        a consumer that will call methods on {@link Database.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #database(Database)
         */
        default Builder database(Consumer<Database.Builder> database) {
            return database(Database.builder().applyMutation(database).build());
        }
    }

    static final class BuilderImpl extends GlueCatalogFederationResponse.BuilderImpl implements Builder {
        private Database database;

        private BuilderImpl() {
        }

        private BuilderImpl(GetDatabaseResponse model) {
            super(model);
            database(model.database);
        }

        public final Database.Builder getDatabase() {
            return database != null ? database.toBuilder() : null;
        }

        public final void setDatabase(Database.BuilderImpl database) {
            this.database = database != null ? database.build() : null;
        }

        @Override
        @Transient
        public final Builder database(Database database) {
            this.database = database;
            return this;
        }

        @Override
        public GetDatabaseResponse build() {
            return new GetDatabaseResponse(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }
}
