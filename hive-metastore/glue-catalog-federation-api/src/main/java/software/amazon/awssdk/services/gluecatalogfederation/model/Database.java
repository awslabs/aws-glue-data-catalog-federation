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
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;
import software.amazon.awssdk.annotations.Generated;
import software.amazon.awssdk.core.SdkField;
import software.amazon.awssdk.core.SdkPojo;
import software.amazon.awssdk.core.protocol.MarshallLocation;
import software.amazon.awssdk.core.protocol.MarshallingType;
import software.amazon.awssdk.core.traits.LocationTrait;
import software.amazon.awssdk.core.traits.MapTrait;
import software.amazon.awssdk.core.util.DefaultSdkAutoConstructMap;
import software.amazon.awssdk.core.util.SdkAutoConstructMap;
import software.amazon.awssdk.utils.ToString;
import software.amazon.awssdk.utils.builder.CopyableBuilder;
import software.amazon.awssdk.utils.builder.ToCopyableBuilder;

/**
 */
@Generated("software.amazon.awssdk:codegen")
public final class Database implements SdkPojo, Serializable, ToCopyableBuilder<Database.Builder, Database> {
    private static final SdkField<String> DATABASE_IDENTIFIER_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("DatabaseIdentifier").getter(getter(Database::databaseIdentifier))
            .setter(setter(Builder::databaseIdentifier))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("DatabaseIdentifier").build())
            .build();

    private static final SdkField<String> DATABASE_NAME_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("DatabaseName").getter(getter(Database::databaseName)).setter(setter(Builder::databaseName))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("DatabaseName").build()).build();

    private static final SdkField<String> DESCRIPTION_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("Description").getter(getter(Database::description)).setter(setter(Builder::description))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Description").build()).build();

    private static final SdkField<Instant> CREATE_TIME_FIELD = SdkField.<Instant> builder(MarshallingType.INSTANT)
            .memberName("CreateTime").getter(getter(Database::createTime)).setter(setter(Builder::createTime))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("CreateTime").build()).build();

    private static final SdkField<String> LOCATION_URI_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("LocationUri").getter(getter(Database::locationUri)).setter(setter(Builder::locationUri))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("LocationUri").build()).build();

    private static final SdkField<Map<String, String>> PARAMETERS_FIELD = SdkField
            .<Map<String, String>> builder(MarshallingType.MAP)
            .memberName("Parameters")
            .getter(getter(Database::parameters))
            .setter(setter(Builder::parameters))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Parameters").build(),
                    MapTrait.builder()
                            .keyLocationName("key")
                            .valueLocationName("value")
                            .valueFieldInfo(
                                    SdkField.<String> builder(MarshallingType.STRING)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("value").build()).build()).build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(DATABASE_IDENTIFIER_FIELD,
            DATABASE_NAME_FIELD, DESCRIPTION_FIELD, CREATE_TIME_FIELD, LOCATION_URI_FIELD, PARAMETERS_FIELD));

    private static final long serialVersionUID = 1L;

    private final String databaseIdentifier;

    private final String databaseName;

    private final String description;

    private final Instant createTime;

    private final String locationUri;

    private final Map<String, String> parameters;

    private Database(BuilderImpl builder) {
        this.databaseIdentifier = builder.databaseIdentifier;
        this.databaseName = builder.databaseName;
        this.description = builder.description;
        this.createTime = builder.createTime;
        this.locationUri = builder.locationUri;
        this.parameters = builder.parameters;
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
     * Returns the value of the Description property for this object.
     * 
     * @return The value of the Description property for this object.
     */
    public final String description() {
        return description;
    }

    /**
     * Returns the value of the CreateTime property for this object.
     * 
     * @return The value of the CreateTime property for this object.
     */
    public final Instant createTime() {
        return createTime;
    }

    /**
     * Returns the value of the LocationUri property for this object.
     * 
     * @return The value of the LocationUri property for this object.
     */
    public final String locationUri() {
        return locationUri;
    }

    /**
     * For responses, this returns true if the service returned a value for the Parameters property. This DOES NOT check
     * that the value is non-empty (for which, you should check the {@code isEmpty()} method on the property). This is
     * useful because the SDK will never return a null collection or map, but you may need to differentiate between the
     * service returning nothing (or null) and the service returning an empty collection or map. For requests, this
     * returns true if a value for the property was specified in the request builder, and false if a value was not
     * specified.
     */
    public final boolean hasParameters() {
        return parameters != null && !(parameters instanceof SdkAutoConstructMap);
    }

    /**
     * Returns the value of the Parameters property for this object.
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasParameters} method.
     * </p>
     * 
     * @return The value of the Parameters property for this object.
     */
    public final Map<String, String> parameters() {
        return parameters;
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
        hashCode = 31 * hashCode + Objects.hashCode(description());
        hashCode = 31 * hashCode + Objects.hashCode(createTime());
        hashCode = 31 * hashCode + Objects.hashCode(locationUri());
        hashCode = 31 * hashCode + Objects.hashCode(hasParameters() ? parameters() : null);
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
        if (!(obj instanceof Database)) {
            return false;
        }
        Database other = (Database) obj;
        return Objects.equals(databaseIdentifier(), other.databaseIdentifier())
                && Objects.equals(databaseName(), other.databaseName()) && Objects.equals(description(), other.description())
                && Objects.equals(createTime(), other.createTime()) && Objects.equals(locationUri(), other.locationUri())
                && hasParameters() == other.hasParameters() && Objects.equals(parameters(), other.parameters());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("Database").add("DatabaseIdentifier", databaseIdentifier()).add("DatabaseName", databaseName())
                .add("Description", description()).add("CreateTime", createTime()).add("LocationUri", locationUri())
                .add("Parameters", hasParameters() ? parameters() : null).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "DatabaseIdentifier":
            return Optional.ofNullable(clazz.cast(databaseIdentifier()));
        case "DatabaseName":
            return Optional.ofNullable(clazz.cast(databaseName()));
        case "Description":
            return Optional.ofNullable(clazz.cast(description()));
        case "CreateTime":
            return Optional.ofNullable(clazz.cast(createTime()));
        case "LocationUri":
            return Optional.ofNullable(clazz.cast(locationUri()));
        case "Parameters":
            return Optional.ofNullable(clazz.cast(parameters()));
        default:
            return Optional.empty();
        }
    }

    @Override
    public final List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    private static <T> Function<Object, T> getter(Function<Database, T> g) {
        return obj -> g.apply((Database) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    public interface Builder extends SdkPojo, CopyableBuilder<Builder, Database> {
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
         * Sets the value of the Description property for this object.
         *
         * @param description
         *        The new value for the Description property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder description(String description);

        /**
         * Sets the value of the CreateTime property for this object.
         *
         * @param createTime
         *        The new value for the CreateTime property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder createTime(Instant createTime);

        /**
         * Sets the value of the LocationUri property for this object.
         *
         * @param locationUri
         *        The new value for the LocationUri property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder locationUri(String locationUri);

        /**
         * Sets the value of the Parameters property for this object.
         *
         * @param parameters
         *        The new value for the Parameters property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder parameters(Map<String, String> parameters);
    }

    static final class BuilderImpl implements Builder {
        private String databaseIdentifier;

        private String databaseName;

        private String description;

        private Instant createTime;

        private String locationUri;

        private Map<String, String> parameters = DefaultSdkAutoConstructMap.getInstance();

        private BuilderImpl() {
        }

        private BuilderImpl(Database model) {
            databaseIdentifier(model.databaseIdentifier);
            databaseName(model.databaseName);
            description(model.description);
            createTime(model.createTime);
            locationUri(model.locationUri);
            parameters(model.parameters);
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

        public final String getDescription() {
            return description;
        }

        public final void setDescription(String description) {
            this.description = description;
        }

        @Override
        @Transient
        public final Builder description(String description) {
            this.description = description;
            return this;
        }

        public final Instant getCreateTime() {
            return createTime;
        }

        public final void setCreateTime(Instant createTime) {
            this.createTime = createTime;
        }

        @Override
        @Transient
        public final Builder createTime(Instant createTime) {
            this.createTime = createTime;
            return this;
        }

        public final String getLocationUri() {
            return locationUri;
        }

        public final void setLocationUri(String locationUri) {
            this.locationUri = locationUri;
        }

        @Override
        @Transient
        public final Builder locationUri(String locationUri) {
            this.locationUri = locationUri;
            return this;
        }

        public final Map<String, String> getParameters() {
            if (parameters instanceof SdkAutoConstructMap) {
                return null;
            }
            return parameters;
        }

        public final void setParameters(Map<String, String> parameters) {
            this.parameters = ParametersMapCopier.copy(parameters);
        }

        @Override
        @Transient
        public final Builder parameters(Map<String, String> parameters) {
            this.parameters = ParametersMapCopier.copy(parameters);
            return this;
        }

        @Override
        public Database build() {
            return new Database(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }
}
