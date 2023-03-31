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
import java.nio.ByteBuffer;
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
import java.util.stream.Collectors;
import java.util.stream.Stream;
import software.amazon.awssdk.annotations.Generated;
import software.amazon.awssdk.core.SdkBytes;
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
public final class Table implements SdkPojo, Serializable, ToCopyableBuilder<Table.Builder, Table> {
    private static final SdkField<String> TABLE_IDENTIFIER_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("TableIdentifier").getter(getter(Table::tableIdentifier)).setter(setter(Builder::tableIdentifier))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("TableIdentifier").build()).build();

    private static final SdkField<String> DATABASE_IDENTIFIER_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("DatabaseIdentifier").getter(getter(Table::databaseIdentifier))
            .setter(setter(Builder::databaseIdentifier))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("DatabaseIdentifier").build())
            .build();

    private static final SdkField<String> TABLE_NAME_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("TableName").getter(getter(Table::tableName)).setter(setter(Builder::tableName))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("TableName").build()).build();

    private static final SdkField<String> DATABASE_NAME_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("DatabaseName").getter(getter(Table::databaseName)).setter(setter(Builder::databaseName))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("DatabaseName").build()).build();

    private static final SdkField<String> DESCRIPTION_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("Description").getter(getter(Table::description)).setter(setter(Builder::description))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Description").build()).build();

    private static final SdkField<String> ID_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("Id")
            .getter(getter(Table::id)).setter(setter(Builder::id))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Id").build()).build();

    private static final SdkField<Instant> CREATE_TIME_FIELD = SdkField.<Instant> builder(MarshallingType.INSTANT)
            .memberName("CreateTime").getter(getter(Table::createTime)).setter(setter(Builder::createTime))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("CreateTime").build()).build();

    private static final SdkField<Instant> UPDATE_TIME_FIELD = SdkField.<Instant> builder(MarshallingType.INSTANT)
            .memberName("UpdateTime").getter(getter(Table::updateTime)).setter(setter(Builder::updateTime))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("UpdateTime").build()).build();

    private static final SdkField<Instant> LAST_ACCESS_TIME_FIELD = SdkField.<Instant> builder(MarshallingType.INSTANT)
            .memberName("LastAccessTime").getter(getter(Table::lastAccessTime)).setter(setter(Builder::lastAccessTime))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("LastAccessTime").build()).build();

    private static final SdkField<StorageDescriptor> STORAGE_DESCRIPTOR_FIELD = SdkField
            .<StorageDescriptor> builder(MarshallingType.SDK_POJO).memberName("StorageDescriptor")
            .getter(getter(Table::storageDescriptor)).setter(setter(Builder::storageDescriptor))
            .constructor(StorageDescriptor::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("StorageDescriptor").build()).build();

    private static final SdkField<List<Column>> PARTITION_KEYS_FIELD = SdkField
            .<List<Column>> builder(MarshallingType.LIST)
            .memberName("PartitionKeys")
            .getter(getter(Table::partitionKeys))
            .setter(setter(Builder::partitionKeys))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("PartitionKeys").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<Column> builder(MarshallingType.SDK_POJO)
                                            .constructor(Column::builder)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").build()).build()).build()).build();

    private static final SdkField<String> TABLE_TYPE_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("TableType").getter(getter(Table::tableType)).setter(setter(Builder::tableType))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("TableType").build()).build();

    private static final SdkField<Map<String, String>> PARAMETERS_FIELD = SdkField
            .<Map<String, String>> builder(MarshallingType.MAP)
            .memberName("Parameters")
            .getter(getter(Table::parameters))
            .setter(setter(Builder::parameters))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Parameters").build(),
                    MapTrait.builder()
                            .keyLocationName("key")
                            .valueLocationName("value")
                            .valueFieldInfo(
                                    SdkField.<String> builder(MarshallingType.STRING)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("value").build()).build()).build()).build();

    private static final SdkField<Map<String, SdkBytes>> DATA_PARAMETERS_FIELD = SdkField
            .<Map<String, SdkBytes>> builder(MarshallingType.MAP)
            .memberName("DataParameters")
            .getter(getter(Table::dataParameters))
            .setter(setter(Builder::dataParameters))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("DataParameters").build(),
                    MapTrait.builder()
                            .keyLocationName("key")
                            .valueLocationName("value")
                            .valueFieldInfo(
                                    SdkField.<SdkBytes> builder(MarshallingType.SDK_BYTES)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("value").build()).build()).build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(TABLE_IDENTIFIER_FIELD,
            DATABASE_IDENTIFIER_FIELD, TABLE_NAME_FIELD, DATABASE_NAME_FIELD, DESCRIPTION_FIELD, ID_FIELD, CREATE_TIME_FIELD,
            UPDATE_TIME_FIELD, LAST_ACCESS_TIME_FIELD, STORAGE_DESCRIPTOR_FIELD, PARTITION_KEYS_FIELD, TABLE_TYPE_FIELD,
            PARAMETERS_FIELD, DATA_PARAMETERS_FIELD));

    private static final long serialVersionUID = 1L;

    private final String tableIdentifier;

    private final String databaseIdentifier;

    private final String tableName;

    private final String databaseName;

    private final String description;

    private final String id;

    private final Instant createTime;

    private final Instant updateTime;

    private final Instant lastAccessTime;

    private final StorageDescriptor storageDescriptor;

    private final List<Column> partitionKeys;

    private final String tableType;

    private final Map<String, String> parameters;

    private final Map<String, SdkBytes> dataParameters;

    private Table(BuilderImpl builder) {
        this.tableIdentifier = builder.tableIdentifier;
        this.databaseIdentifier = builder.databaseIdentifier;
        this.tableName = builder.tableName;
        this.databaseName = builder.databaseName;
        this.description = builder.description;
        this.id = builder.id;
        this.createTime = builder.createTime;
        this.updateTime = builder.updateTime;
        this.lastAccessTime = builder.lastAccessTime;
        this.storageDescriptor = builder.storageDescriptor;
        this.partitionKeys = builder.partitionKeys;
        this.tableType = builder.tableType;
        this.parameters = builder.parameters;
        this.dataParameters = builder.dataParameters;
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
     * Returns the value of the DatabaseIdentifier property for this object.
     * 
     * @return The value of the DatabaseIdentifier property for this object.
     */
    public final String databaseIdentifier() {
        return databaseIdentifier;
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
     * Returns the value of the Id property for this object.
     * 
     * @return The value of the Id property for this object.
     */
    public final String id() {
        return id;
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
     * Returns the value of the UpdateTime property for this object.
     * 
     * @return The value of the UpdateTime property for this object.
     */
    public final Instant updateTime() {
        return updateTime;
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
     * For responses, this returns true if the service returned a value for the PartitionKeys property. This DOES NOT
     * check that the value is non-empty (for which, you should check the {@code isEmpty()} method on the property).
     * This is useful because the SDK will never return a null collection or map, but you may need to differentiate
     * between the service returning nothing (or null) and the service returning an empty collection or map. For
     * requests, this returns true if a value for the property was specified in the request builder, and false if a
     * value was not specified.
     */
    public final boolean hasPartitionKeys() {
        return partitionKeys != null && !(partitionKeys instanceof SdkAutoConstructList);
    }

    /**
     * Returns the value of the PartitionKeys property for this object.
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasPartitionKeys} method.
     * </p>
     * 
     * @return The value of the PartitionKeys property for this object.
     */
    public final List<Column> partitionKeys() {
        return partitionKeys;
    }

    /**
     * Returns the value of the TableType property for this object.
     * 
     * @return The value of the TableType property for this object.
     */
    public final String tableType() {
        return tableType;
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

    /**
     * For responses, this returns true if the service returned a value for the DataParameters property. This DOES NOT
     * check that the value is non-empty (for which, you should check the {@code isEmpty()} method on the property).
     * This is useful because the SDK will never return a null collection or map, but you may need to differentiate
     * between the service returning nothing (or null) and the service returning an empty collection or map. For
     * requests, this returns true if a value for the property was specified in the request builder, and false if a
     * value was not specified.
     */
    public final boolean hasDataParameters() {
        return dataParameters != null && !(dataParameters instanceof SdkAutoConstructMap);
    }

    /**
     * Returns the value of the DataParameters property for this object.
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasDataParameters} method.
     * </p>
     * 
     * @return The value of the DataParameters property for this object.
     */
    public final Map<String, SdkBytes> dataParameters() {
        return dataParameters;
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
        hashCode = 31 * hashCode + Objects.hashCode(tableIdentifier());
        hashCode = 31 * hashCode + Objects.hashCode(databaseIdentifier());
        hashCode = 31 * hashCode + Objects.hashCode(tableName());
        hashCode = 31 * hashCode + Objects.hashCode(databaseName());
        hashCode = 31 * hashCode + Objects.hashCode(description());
        hashCode = 31 * hashCode + Objects.hashCode(id());
        hashCode = 31 * hashCode + Objects.hashCode(createTime());
        hashCode = 31 * hashCode + Objects.hashCode(updateTime());
        hashCode = 31 * hashCode + Objects.hashCode(lastAccessTime());
        hashCode = 31 * hashCode + Objects.hashCode(storageDescriptor());
        hashCode = 31 * hashCode + Objects.hashCode(hasPartitionKeys() ? partitionKeys() : null);
        hashCode = 31 * hashCode + Objects.hashCode(tableType());
        hashCode = 31 * hashCode + Objects.hashCode(hasParameters() ? parameters() : null);
        hashCode = 31 * hashCode + Objects.hashCode(hasDataParameters() ? dataParameters() : null);
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
        if (!(obj instanceof Table)) {
            return false;
        }
        Table other = (Table) obj;
        return Objects.equals(tableIdentifier(), other.tableIdentifier())
                && Objects.equals(databaseIdentifier(), other.databaseIdentifier())
                && Objects.equals(tableName(), other.tableName()) && Objects.equals(databaseName(), other.databaseName())
                && Objects.equals(description(), other.description()) && Objects.equals(id(), other.id())
                && Objects.equals(createTime(), other.createTime()) && Objects.equals(updateTime(), other.updateTime())
                && Objects.equals(lastAccessTime(), other.lastAccessTime())
                && Objects.equals(storageDescriptor(), other.storageDescriptor())
                && hasPartitionKeys() == other.hasPartitionKeys() && Objects.equals(partitionKeys(), other.partitionKeys())
                && Objects.equals(tableType(), other.tableType()) && hasParameters() == other.hasParameters()
                && Objects.equals(parameters(), other.parameters()) && hasDataParameters() == other.hasDataParameters()
                && Objects.equals(dataParameters(), other.dataParameters());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("Table").add("TableIdentifier", tableIdentifier())
                .add("DatabaseIdentifier", databaseIdentifier()).add("TableName", tableName())
                .add("DatabaseName", databaseName()).add("Description", description()).add("Id", id())
                .add("CreateTime", createTime()).add("UpdateTime", updateTime()).add("LastAccessTime", lastAccessTime())
                .add("StorageDescriptor", storageDescriptor()).add("PartitionKeys", hasPartitionKeys() ? partitionKeys() : null)
                .add("TableType", tableType()).add("Parameters", hasParameters() ? parameters() : null)
                .add("DataParameters", hasDataParameters() ? dataParameters() : null).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "TableIdentifier":
            return Optional.ofNullable(clazz.cast(tableIdentifier()));
        case "DatabaseIdentifier":
            return Optional.ofNullable(clazz.cast(databaseIdentifier()));
        case "TableName":
            return Optional.ofNullable(clazz.cast(tableName()));
        case "DatabaseName":
            return Optional.ofNullable(clazz.cast(databaseName()));
        case "Description":
            return Optional.ofNullable(clazz.cast(description()));
        case "Id":
            return Optional.ofNullable(clazz.cast(id()));
        case "CreateTime":
            return Optional.ofNullable(clazz.cast(createTime()));
        case "UpdateTime":
            return Optional.ofNullable(clazz.cast(updateTime()));
        case "LastAccessTime":
            return Optional.ofNullable(clazz.cast(lastAccessTime()));
        case "StorageDescriptor":
            return Optional.ofNullable(clazz.cast(storageDescriptor()));
        case "PartitionKeys":
            return Optional.ofNullable(clazz.cast(partitionKeys()));
        case "TableType":
            return Optional.ofNullable(clazz.cast(tableType()));
        case "Parameters":
            return Optional.ofNullable(clazz.cast(parameters()));
        case "DataParameters":
            return Optional.ofNullable(clazz.cast(dataParameters()));
        default:
            return Optional.empty();
        }
    }

    @Override
    public final List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    private static <T> Function<Object, T> getter(Function<Table, T> g) {
        return obj -> g.apply((Table) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    public interface Builder extends SdkPojo, CopyableBuilder<Builder, Table> {
        /**
         * Sets the value of the TableIdentifier property for this object.
         *
         * @param tableIdentifier
         *        The new value for the TableIdentifier property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder tableIdentifier(String tableIdentifier);

        /**
         * Sets the value of the DatabaseIdentifier property for this object.
         *
         * @param databaseIdentifier
         *        The new value for the DatabaseIdentifier property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder databaseIdentifier(String databaseIdentifier);

        /**
         * Sets the value of the TableName property for this object.
         *
         * @param tableName
         *        The new value for the TableName property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder tableName(String tableName);

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
         * Sets the value of the Id property for this object.
         *
         * @param id
         *        The new value for the Id property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder id(String id);

        /**
         * Sets the value of the CreateTime property for this object.
         *
         * @param createTime
         *        The new value for the CreateTime property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder createTime(Instant createTime);

        /**
         * Sets the value of the UpdateTime property for this object.
         *
         * @param updateTime
         *        The new value for the UpdateTime property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder updateTime(Instant updateTime);

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
         * Sets the value of the PartitionKeys property for this object.
         *
         * @param partitionKeys
         *        The new value for the PartitionKeys property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder partitionKeys(Collection<Column> partitionKeys);

        /**
         * Sets the value of the PartitionKeys property for this object.
         *
         * @param partitionKeys
         *        The new value for the PartitionKeys property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder partitionKeys(Column... partitionKeys);

        /**
         * Sets the value of the PartitionKeys property for this object.
         *
         * This is a convenience that creates an instance of the {@link List<Column>.Builder} avoiding the need to
         * create one manually via {@link List<Column>#builder()}.
         *
         * When the {@link Consumer} completes, {@link List<Column>.Builder#build()} is called immediately and its
         * result is passed to {@link #partitionKeys(List<Column>)}.
         * 
         * @param partitionKeys
         *        a consumer that will call methods on {@link List<Column>.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #partitionKeys(List<Column>)
         */
        Builder partitionKeys(Consumer<Column.Builder>... partitionKeys);

        /**
         * Sets the value of the TableType property for this object.
         *
         * @param tableType
         *        The new value for the TableType property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder tableType(String tableType);

        /**
         * Sets the value of the Parameters property for this object.
         *
         * @param parameters
         *        The new value for the Parameters property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder parameters(Map<String, String> parameters);

        /**
         * Sets the value of the DataParameters property for this object.
         *
         * @param dataParameters
         *        The new value for the DataParameters property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder dataParameters(Map<String, SdkBytes> dataParameters);
    }

    static final class BuilderImpl implements Builder {
        private String tableIdentifier;

        private String databaseIdentifier;

        private String tableName;

        private String databaseName;

        private String description;

        private String id;

        private Instant createTime;

        private Instant updateTime;

        private Instant lastAccessTime;

        private StorageDescriptor storageDescriptor;

        private List<Column> partitionKeys = DefaultSdkAutoConstructList.getInstance();

        private String tableType;

        private Map<String, String> parameters = DefaultSdkAutoConstructMap.getInstance();

        private Map<String, SdkBytes> dataParameters = DefaultSdkAutoConstructMap.getInstance();

        private BuilderImpl() {
        }

        private BuilderImpl(Table model) {
            tableIdentifier(model.tableIdentifier);
            databaseIdentifier(model.databaseIdentifier);
            tableName(model.tableName);
            databaseName(model.databaseName);
            description(model.description);
            id(model.id);
            createTime(model.createTime);
            updateTime(model.updateTime);
            lastAccessTime(model.lastAccessTime);
            storageDescriptor(model.storageDescriptor);
            partitionKeys(model.partitionKeys);
            tableType(model.tableType);
            parameters(model.parameters);
            dataParameters(model.dataParameters);
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

        public final String getId() {
            return id;
        }

        public final void setId(String id) {
            this.id = id;
        }

        @Override
        @Transient
        public final Builder id(String id) {
            this.id = id;
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

        public final Instant getUpdateTime() {
            return updateTime;
        }

        public final void setUpdateTime(Instant updateTime) {
            this.updateTime = updateTime;
        }

        @Override
        @Transient
        public final Builder updateTime(Instant updateTime) {
            this.updateTime = updateTime;
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

        public final List<Column.Builder> getPartitionKeys() {
            List<Column.Builder> result = ColumnListCopier.copyToBuilder(this.partitionKeys);
            if (result instanceof SdkAutoConstructList) {
                return null;
            }
            return result;
        }

        public final void setPartitionKeys(Collection<Column.BuilderImpl> partitionKeys) {
            this.partitionKeys = ColumnListCopier.copyFromBuilder(partitionKeys);
        }

        @Override
        @Transient
        public final Builder partitionKeys(Collection<Column> partitionKeys) {
            this.partitionKeys = ColumnListCopier.copy(partitionKeys);
            return this;
        }

        @Override
        @Transient
        @SafeVarargs
        public final Builder partitionKeys(Column... partitionKeys) {
            partitionKeys(Arrays.asList(partitionKeys));
            return this;
        }

        @Override
        @Transient
        @SafeVarargs
        public final Builder partitionKeys(Consumer<Column.Builder>... partitionKeys) {
            partitionKeys(Stream.of(partitionKeys).map(c -> Column.builder().applyMutation(c).build())
                    .collect(Collectors.toList()));
            return this;
        }

        public final String getTableType() {
            return tableType;
        }

        public final void setTableType(String tableType) {
            this.tableType = tableType;
        }

        @Override
        @Transient
        public final Builder tableType(String tableType) {
            this.tableType = tableType;
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

        public final Map<String, ByteBuffer> getDataParameters() {
            if (dataParameters instanceof SdkAutoConstructMap) {
                return null;
            }
            return dataParameters == null ? null : dataParameters.entrySet().stream()
                    .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue().asByteBuffer()));
        }

        public final void setDataParameters(Map<String, ByteBuffer> dataParameters) {
            dataParameters(dataParameters == null ? null : dataParameters.entrySet().stream()
                    .collect(Collectors.toMap(e -> e.getKey(), e -> SdkBytes.fromByteBuffer(e.getValue()))));
        }

        @Override
        @Transient
        public final Builder dataParameters(Map<String, SdkBytes> dataParameters) {
            this.dataParameters = BlobParametersMapCopier.copy(dataParameters);
            return this;
        }

        @Override
        public Table build() {
            return new Table(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }
}
