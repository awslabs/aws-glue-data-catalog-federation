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
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
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
import software.amazon.awssdk.core.traits.ListTrait;
import software.amazon.awssdk.core.traits.LocationTrait;
import software.amazon.awssdk.core.traits.MapTrait;
import software.amazon.awssdk.core.util.DefaultSdkAutoConstructList;
import software.amazon.awssdk.core.util.DefaultSdkAutoConstructMap;
import software.amazon.awssdk.core.util.SdkAutoConstructList;
import software.amazon.awssdk.core.util.SdkAutoConstructMap;
import software.amazon.awssdk.utils.ToString;
import software.amazon.awssdk.utils.builder.CopyableBuilder;
import software.amazon.awssdk.utils.builder.ToCopyableBuilder;

/**
 */
@Generated("software.amazon.awssdk:codegen")
public final class Partition implements SdkPojo, Serializable, ToCopyableBuilder<Partition.Builder, Partition> {
    private static final SdkField<String> DATABASE_IDENTIFIER_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("DatabaseIdentifier").getter(getter(Partition::databaseIdentifier))
            .setter(setter(Builder::databaseIdentifier))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("DatabaseIdentifier").build())
            .build();

    private static final SdkField<String> TABLE_IDENTIFIER_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("TableIdentifier").getter(getter(Partition::tableIdentifier)).setter(setter(Builder::tableIdentifier))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("TableIdentifier").build()).build();

    private static final SdkField<String> DATABASE_NAME_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("DatabaseName").getter(getter(Partition::databaseName)).setter(setter(Builder::databaseName))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("DatabaseName").build()).build();

    private static final SdkField<String> TABLE_NAME_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("TableName").getter(getter(Partition::tableName)).setter(setter(Builder::tableName))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("TableName").build()).build();

    private static final SdkField<List<String>> VALUES_FIELD = SdkField
            .<List<String>> builder(MarshallingType.LIST)
            .memberName("Values")
            .getter(getter(Partition::values))
            .setter(setter(Builder::values))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Values").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<String> builder(MarshallingType.STRING)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").build()).build()).build()).build();

    private static final SdkField<Instant> CREATION_TIME_FIELD = SdkField.<Instant> builder(MarshallingType.INSTANT)
            .memberName("CreationTime").getter(getter(Partition::creationTime)).setter(setter(Builder::creationTime))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("CreationTime").build()).build();

    private static final SdkField<Instant> LAST_ACCESS_TIME_FIELD = SdkField.<Instant> builder(MarshallingType.INSTANT)
            .memberName("LastAccessTime").getter(getter(Partition::lastAccessTime)).setter(setter(Builder::lastAccessTime))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("LastAccessTime").build()).build();

    private static final SdkField<StorageDescriptor> STORAGE_DESCRIPTOR_FIELD = SdkField
            .<StorageDescriptor> builder(MarshallingType.SDK_POJO).memberName("StorageDescriptor")
            .getter(getter(Partition::storageDescriptor)).setter(setter(Builder::storageDescriptor))
            .constructor(StorageDescriptor::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("StorageDescriptor").build()).build();

    private static final SdkField<Map<String, String>> PARAMETERS_FIELD = SdkField
            .<Map<String, String>> builder(MarshallingType.MAP)
            .memberName("Parameters")
            .getter(getter(Partition::parameters))
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
            TABLE_IDENTIFIER_FIELD, DATABASE_NAME_FIELD, TABLE_NAME_FIELD, VALUES_FIELD, CREATION_TIME_FIELD,
            LAST_ACCESS_TIME_FIELD, STORAGE_DESCRIPTOR_FIELD, PARAMETERS_FIELD));

    private static final long serialVersionUID = 1L;

    private final String databaseIdentifier;

    private final String tableIdentifier;

    private final String databaseName;

    private final String tableName;

    private final List<String> values;

    private final Instant creationTime;

    private final Instant lastAccessTime;

    private final StorageDescriptor storageDescriptor;

    private final Map<String, String> parameters;

    private Partition(BuilderImpl builder) {
        this.databaseIdentifier = builder.databaseIdentifier;
        this.tableIdentifier = builder.tableIdentifier;
        this.databaseName = builder.databaseName;
        this.tableName = builder.tableName;
        this.values = builder.values;
        this.creationTime = builder.creationTime;
        this.lastAccessTime = builder.lastAccessTime;
        this.storageDescriptor = builder.storageDescriptor;
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
     * Returns the value of the TableIdentifier property for this object.
     * 
     * @return The value of the TableIdentifier property for this object.
     */
    public final String tableIdentifier() {
        return tableIdentifier;
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
     * Returns the value of the TableName property for this object.
     * 
     * @return The value of the TableName property for this object.
     */
    public final String tableName() {
        return tableName;
    }

    /**
     * For responses, this returns true if the service returned a value for the Values property. This DOES NOT check
     * that the value is non-empty (for which, you should check the {@code isEmpty()} method on the property). This is
     * useful because the SDK will never return a null collection or map, but you may need to differentiate between the
     * service returning nothing (or null) and the service returning an empty collection or map. For requests, this
     * returns true if a value for the property was specified in the request builder, and false if a value was not
     * specified.
     */
    public final boolean hasValues() {
        return values != null && !(values instanceof SdkAutoConstructList);
    }

    /**
     * Returns the value of the Values property for this object.
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasValues} method.
     * </p>
     * 
     * @return The value of the Values property for this object.
     */
    public final List<String> values() {
        return values;
    }

    /**
     * Returns the value of the CreationTime property for this object.
     * 
     * @return The value of the CreationTime property for this object.
     */
    public final Instant creationTime() {
        return creationTime;
    }

    /**
     * Returns the value of the LastAccessTime property for this object.
     * 
     * @return The value of the LastAccessTime property for this object.
     */
    public final Instant lastAccessTime() {
        return lastAccessTime;
    }

    /**
     * Returns the value of the StorageDescriptor property for this object.
     * 
     * @return The value of the StorageDescriptor property for this object.
     */
    public final StorageDescriptor storageDescriptor() {
        return storageDescriptor;
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
        hashCode = 31 * hashCode + Objects.hashCode(tableIdentifier());
        hashCode = 31 * hashCode + Objects.hashCode(databaseName());
        hashCode = 31 * hashCode + Objects.hashCode(tableName());
        hashCode = 31 * hashCode + Objects.hashCode(hasValues() ? values() : null);
        hashCode = 31 * hashCode + Objects.hashCode(creationTime());
        hashCode = 31 * hashCode + Objects.hashCode(lastAccessTime());
        hashCode = 31 * hashCode + Objects.hashCode(storageDescriptor());
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
        if (!(obj instanceof Partition)) {
            return false;
        }
        Partition other = (Partition) obj;
        return Objects.equals(databaseIdentifier(), other.databaseIdentifier())
                && Objects.equals(tableIdentifier(), other.tableIdentifier())
                && Objects.equals(databaseName(), other.databaseName()) && Objects.equals(tableName(), other.tableName())
                && hasValues() == other.hasValues() && Objects.equals(values(), other.values())
                && Objects.equals(creationTime(), other.creationTime())
                && Objects.equals(lastAccessTime(), other.lastAccessTime())
                && Objects.equals(storageDescriptor(), other.storageDescriptor()) && hasParameters() == other.hasParameters()
                && Objects.equals(parameters(), other.parameters());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("Partition").add("DatabaseIdentifier", databaseIdentifier())
                .add("TableIdentifier", tableIdentifier()).add("DatabaseName", databaseName()).add("TableName", tableName())
                .add("Values", hasValues() ? values() : null).add("CreationTime", creationTime())
                .add("LastAccessTime", lastAccessTime()).add("StorageDescriptor", storageDescriptor())
                .add("Parameters", hasParameters() ? parameters() : null).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "DatabaseIdentifier":
            return Optional.ofNullable(clazz.cast(databaseIdentifier()));
        case "TableIdentifier":
            return Optional.ofNullable(clazz.cast(tableIdentifier()));
        case "DatabaseName":
            return Optional.ofNullable(clazz.cast(databaseName()));
        case "TableName":
            return Optional.ofNullable(clazz.cast(tableName()));
        case "Values":
            return Optional.ofNullable(clazz.cast(values()));
        case "CreationTime":
            return Optional.ofNullable(clazz.cast(creationTime()));
        case "LastAccessTime":
            return Optional.ofNullable(clazz.cast(lastAccessTime()));
        case "StorageDescriptor":
            return Optional.ofNullable(clazz.cast(storageDescriptor()));
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

    private static <T> Function<Object, T> getter(Function<Partition, T> g) {
        return obj -> g.apply((Partition) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    public interface Builder extends SdkPojo, CopyableBuilder<Builder, Partition> {
        /**
         * Sets the value of the DatabaseIdentifier property for this object.
         *
         * @param databaseIdentifier
         *        The new value for the DatabaseIdentifier property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder databaseIdentifier(String databaseIdentifier);

        /**
         * Sets the value of the TableIdentifier property for this object.
         *
         * @param tableIdentifier
         *        The new value for the TableIdentifier property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder tableIdentifier(String tableIdentifier);

        /**
         * Sets the value of the DatabaseName property for this object.
         *
         * @param databaseName
         *        The new value for the DatabaseName property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder databaseName(String databaseName);

        /**
         * Sets the value of the TableName property for this object.
         *
         * @param tableName
         *        The new value for the TableName property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder tableName(String tableName);

        /**
         * Sets the value of the Values property for this object.
         *
         * @param values
         *        The new value for the Values property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder values(Collection<String> values);

        /**
         * Sets the value of the Values property for this object.
         *
         * @param values
         *        The new value for the Values property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder values(String... values);

        /**
         * Sets the value of the CreationTime property for this object.
         *
         * @param creationTime
         *        The new value for the CreationTime property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder creationTime(Instant creationTime);

        /**
         * Sets the value of the LastAccessTime property for this object.
         *
         * @param lastAccessTime
         *        The new value for the LastAccessTime property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder lastAccessTime(Instant lastAccessTime);

        /**
         * Sets the value of the StorageDescriptor property for this object.
         *
         * @param storageDescriptor
         *        The new value for the StorageDescriptor property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder storageDescriptor(StorageDescriptor storageDescriptor);

        /**
         * Sets the value of the StorageDescriptor property for this object.
         *
         * This is a convenience that creates an instance of the {@link StorageDescriptor.Builder} avoiding the need to
         * create one manually via {@link StorageDescriptor#builder()}.
         *
         * When the {@link Consumer} completes, {@link StorageDescriptor.Builder#build()} is called immediately and its
         * result is passed to {@link #storageDescriptor(StorageDescriptor)}.
         * 
         * @param storageDescriptor
         *        a consumer that will call methods on {@link StorageDescriptor.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #storageDescriptor(StorageDescriptor)
         */
        default Builder storageDescriptor(Consumer<StorageDescriptor.Builder> storageDescriptor) {
            return storageDescriptor(StorageDescriptor.builder().applyMutation(storageDescriptor).build());
        }

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

        private String tableIdentifier;

        private String databaseName;

        private String tableName;

        private List<String> values = DefaultSdkAutoConstructList.getInstance();

        private Instant creationTime;

        private Instant lastAccessTime;

        private StorageDescriptor storageDescriptor;

        private Map<String, String> parameters = DefaultSdkAutoConstructMap.getInstance();

        private BuilderImpl() {
        }

        private BuilderImpl(Partition model) {
            databaseIdentifier(model.databaseIdentifier);
            tableIdentifier(model.tableIdentifier);
            databaseName(model.databaseName);
            tableName(model.tableName);
            values(model.values);
            creationTime(model.creationTime);
            lastAccessTime(model.lastAccessTime);
            storageDescriptor(model.storageDescriptor);
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

        public final String getTableIdentifier() {
            return tableIdentifier;
        }

        public final void setTableIdentifier(String tableIdentifier) {
            this.tableIdentifier = tableIdentifier;
        }

        @Override
        @Transient
        public final Builder tableIdentifier(String tableIdentifier) {
            this.tableIdentifier = tableIdentifier;
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

        public final String getTableName() {
            return tableName;
        }

        public final void setTableName(String tableName) {
            this.tableName = tableName;
        }

        @Override
        @Transient
        public final Builder tableName(String tableName) {
            this.tableName = tableName;
            return this;
        }

        public final Collection<String> getValues() {
            if (values instanceof SdkAutoConstructList) {
                return null;
            }
            return values;
        }

        public final void setValues(Collection<String> values) {
            this.values = ValueStringListCopier.copy(values);
        }

        @Override
        @Transient
        public final Builder values(Collection<String> values) {
            this.values = ValueStringListCopier.copy(values);
            return this;
        }

        @Override
        @Transient
        @SafeVarargs
        public final Builder values(String... values) {
            values(Arrays.asList(values));
            return this;
        }

        public final Instant getCreationTime() {
            return creationTime;
        }

        public final void setCreationTime(Instant creationTime) {
            this.creationTime = creationTime;
        }

        @Override
        @Transient
        public final Builder creationTime(Instant creationTime) {
            this.creationTime = creationTime;
            return this;
        }

        public final Instant getLastAccessTime() {
            return lastAccessTime;
        }

        public final void setLastAccessTime(Instant lastAccessTime) {
            this.lastAccessTime = lastAccessTime;
        }

        @Override
        @Transient
        public final Builder lastAccessTime(Instant lastAccessTime) {
            this.lastAccessTime = lastAccessTime;
            return this;
        }

        public final StorageDescriptor.Builder getStorageDescriptor() {
            return storageDescriptor != null ? storageDescriptor.toBuilder() : null;
        }

        public final void setStorageDescriptor(StorageDescriptor.BuilderImpl storageDescriptor) {
            this.storageDescriptor = storageDescriptor != null ? storageDescriptor.build() : null;
        }

        @Override
        @Transient
        public final Builder storageDescriptor(StorageDescriptor storageDescriptor) {
            this.storageDescriptor = storageDescriptor;
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
        public Partition build() {
            return new Partition(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }
}
