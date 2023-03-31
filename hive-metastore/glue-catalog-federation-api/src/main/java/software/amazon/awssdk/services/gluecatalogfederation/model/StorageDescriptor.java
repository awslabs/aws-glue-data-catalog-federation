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
public final class StorageDescriptor implements SdkPojo, Serializable,
        ToCopyableBuilder<StorageDescriptor.Builder, StorageDescriptor> {
    private static final SdkField<List<Column>> COLUMNS_FIELD = SdkField
            .<List<Column>> builder(MarshallingType.LIST)
            .memberName("Columns")
            .getter(getter(StorageDescriptor::columns))
            .setter(setter(Builder::columns))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Columns").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<Column> builder(MarshallingType.SDK_POJO)
                                            .constructor(Column::builder)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").build()).build()).build()).build();

    private static final SdkField<String> LOCATION_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("Location").getter(getter(StorageDescriptor::location)).setter(setter(Builder::location))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Location").build()).build();

    private static final SdkField<String> INPUT_FORMAT_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("InputFormat").getter(getter(StorageDescriptor::inputFormat)).setter(setter(Builder::inputFormat))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("InputFormat").build()).build();

    private static final SdkField<String> OUTPUT_FORMAT_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("OutputFormat").getter(getter(StorageDescriptor::outputFormat)).setter(setter(Builder::outputFormat))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("OutputFormat").build()).build();

    private static final SdkField<SerDeInfo> SERDE_INFO_FIELD = SdkField.<SerDeInfo> builder(MarshallingType.SDK_POJO)
            .memberName("SerdeInfo").getter(getter(StorageDescriptor::serdeInfo)).setter(setter(Builder::serdeInfo))
            .constructor(SerDeInfo::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("SerdeInfo").build()).build();

    private static final SdkField<Map<String, String>> PARAMETERS_FIELD = SdkField
            .<Map<String, String>> builder(MarshallingType.MAP)
            .memberName("Parameters")
            .getter(getter(StorageDescriptor::parameters))
            .setter(setter(Builder::parameters))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Parameters").build(),
                    MapTrait.builder()
                            .keyLocationName("key")
                            .valueLocationName("value")
                            .valueFieldInfo(
                                    SdkField.<String> builder(MarshallingType.STRING)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("value").build()).build()).build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(COLUMNS_FIELD, LOCATION_FIELD,
            INPUT_FORMAT_FIELD, OUTPUT_FORMAT_FIELD, SERDE_INFO_FIELD, PARAMETERS_FIELD));

    private static final long serialVersionUID = 1L;

    private final List<Column> columns;

    private final String location;

    private final String inputFormat;

    private final String outputFormat;

    private final SerDeInfo serdeInfo;

    private final Map<String, String> parameters;

    private StorageDescriptor(BuilderImpl builder) {
        this.columns = builder.columns;
        this.location = builder.location;
        this.inputFormat = builder.inputFormat;
        this.outputFormat = builder.outputFormat;
        this.serdeInfo = builder.serdeInfo;
        this.parameters = builder.parameters;
    }

    /**
     * For responses, this returns true if the service returned a value for the Columns property. This DOES NOT check
     * that the value is non-empty (for which, you should check the {@code isEmpty()} method on the property). This is
     * useful because the SDK will never return a null collection or map, but you may need to differentiate between the
     * service returning nothing (or null) and the service returning an empty collection or map. For requests, this
     * returns true if a value for the property was specified in the request builder, and false if a value was not
     * specified.
     */
    public final boolean hasColumns() {
        return columns != null && !(columns instanceof SdkAutoConstructList);
    }

    /**
     * Returns the value of the Columns property for this object.
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasColumns} method.
     * </p>
     * 
     * @return The value of the Columns property for this object.
     */
    public final List<Column> columns() {
        return columns;
    }

    /**
     * Returns the value of the Location property for this object.
     * 
     * @return The value of the Location property for this object.
     */
    public final String location() {
        return location;
    }

    /**
     * Returns the value of the InputFormat property for this object.
     * 
     * @return The value of the InputFormat property for this object.
     */
    public final String inputFormat() {
        return inputFormat;
    }

    /**
     * Returns the value of the OutputFormat property for this object.
     * 
     * @return The value of the OutputFormat property for this object.
     */
    public final String outputFormat() {
        return outputFormat;
    }

    /**
     * Returns the value of the SerdeInfo property for this object.
     * 
     * @return The value of the SerdeInfo property for this object.
     */
    public final SerDeInfo serdeInfo() {
        return serdeInfo;
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
        hashCode = 31 * hashCode + Objects.hashCode(hasColumns() ? columns() : null);
        hashCode = 31 * hashCode + Objects.hashCode(location());
        hashCode = 31 * hashCode + Objects.hashCode(inputFormat());
        hashCode = 31 * hashCode + Objects.hashCode(outputFormat());
        hashCode = 31 * hashCode + Objects.hashCode(serdeInfo());
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
        if (!(obj instanceof StorageDescriptor)) {
            return false;
        }
        StorageDescriptor other = (StorageDescriptor) obj;
        return hasColumns() == other.hasColumns() && Objects.equals(columns(), other.columns())
                && Objects.equals(location(), other.location()) && Objects.equals(inputFormat(), other.inputFormat())
                && Objects.equals(outputFormat(), other.outputFormat()) && Objects.equals(serdeInfo(), other.serdeInfo())
                && hasParameters() == other.hasParameters() && Objects.equals(parameters(), other.parameters());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("StorageDescriptor").add("Columns", hasColumns() ? columns() : null).add("Location", location())
                .add("InputFormat", inputFormat()).add("OutputFormat", outputFormat()).add("SerdeInfo", serdeInfo())
                .add("Parameters", hasParameters() ? parameters() : null).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Columns":
            return Optional.ofNullable(clazz.cast(columns()));
        case "Location":
            return Optional.ofNullable(clazz.cast(location()));
        case "InputFormat":
            return Optional.ofNullable(clazz.cast(inputFormat()));
        case "OutputFormat":
            return Optional.ofNullable(clazz.cast(outputFormat()));
        case "SerdeInfo":
            return Optional.ofNullable(clazz.cast(serdeInfo()));
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

    private static <T> Function<Object, T> getter(Function<StorageDescriptor, T> g) {
        return obj -> g.apply((StorageDescriptor) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    public interface Builder extends SdkPojo, CopyableBuilder<Builder, StorageDescriptor> {
        /**
         * Sets the value of the Columns property for this object.
         *
         * @param columns
         *        The new value for the Columns property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder columns(Collection<Column> columns);

        /**
         * Sets the value of the Columns property for this object.
         *
         * @param columns
         *        The new value for the Columns property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder columns(Column... columns);

        /**
         * Sets the value of the Columns property for this object.
         *
         * This is a convenience that creates an instance of the {@link List<Column>.Builder} avoiding the need to
         * create one manually via {@link List<Column>#builder()}.
         *
         * When the {@link Consumer} completes, {@link List<Column>.Builder#build()} is called immediately and its
         * result is passed to {@link #columns(List<Column>)}.
         * 
         * @param columns
         *        a consumer that will call methods on {@link List<Column>.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #columns(List<Column>)
         */
        Builder columns(Consumer<Column.Builder>... columns);

        /**
         * Sets the value of the Location property for this object.
         *
         * @param location
         *        The new value for the Location property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder location(String location);

        /**
         * Sets the value of the InputFormat property for this object.
         *
         * @param inputFormat
         *        The new value for the InputFormat property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder inputFormat(String inputFormat);

        /**
         * Sets the value of the OutputFormat property for this object.
         *
         * @param outputFormat
         *        The new value for the OutputFormat property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder outputFormat(String outputFormat);

        /**
         * Sets the value of the SerdeInfo property for this object.
         *
         * @param serdeInfo
         *        The new value for the SerdeInfo property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder serdeInfo(SerDeInfo serdeInfo);

        /**
         * Sets the value of the SerdeInfo property for this object.
         *
         * This is a convenience that creates an instance of the {@link SerDeInfo.Builder} avoiding the need to create
         * one manually via {@link SerDeInfo#builder()}.
         *
         * When the {@link Consumer} completes, {@link SerDeInfo.Builder#build()} is called immediately and its result
         * is passed to {@link #serdeInfo(SerDeInfo)}.
         * 
         * @param serdeInfo
         *        a consumer that will call methods on {@link SerDeInfo.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #serdeInfo(SerDeInfo)
         */
        default Builder serdeInfo(Consumer<SerDeInfo.Builder> serdeInfo) {
            return serdeInfo(SerDeInfo.builder().applyMutation(serdeInfo).build());
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
        private List<Column> columns = DefaultSdkAutoConstructList.getInstance();

        private String location;

        private String inputFormat;

        private String outputFormat;

        private SerDeInfo serdeInfo;

        private Map<String, String> parameters = DefaultSdkAutoConstructMap.getInstance();

        private BuilderImpl() {
        }

        private BuilderImpl(StorageDescriptor model) {
            columns(model.columns);
            location(model.location);
            inputFormat(model.inputFormat);
            outputFormat(model.outputFormat);
            serdeInfo(model.serdeInfo);
            parameters(model.parameters);
        }

        public final List<Column.Builder> getColumns() {
            List<Column.Builder> result = ColumnListCopier.copyToBuilder(this.columns);
            if (result instanceof SdkAutoConstructList) {
                return null;
            }
            return result;
        }

        public final void setColumns(Collection<Column.BuilderImpl> columns) {
            this.columns = ColumnListCopier.copyFromBuilder(columns);
        }

        @Override
        @Transient
        public final Builder columns(Collection<Column> columns) {
            this.columns = ColumnListCopier.copy(columns);
            return this;
        }

        @Override
        @Transient
        @SafeVarargs
        public final Builder columns(Column... columns) {
            columns(Arrays.asList(columns));
            return this;
        }

        @Override
        @Transient
        @SafeVarargs
        public final Builder columns(Consumer<Column.Builder>... columns) {
            columns(Stream.of(columns).map(c -> Column.builder().applyMutation(c).build()).collect(Collectors.toList()));
            return this;
        }

        public final String getLocation() {
            return location;
        }

        public final void setLocation(String location) {
            this.location = location;
        }

        @Override
        @Transient
        public final Builder location(String location) {
            this.location = location;
            return this;
        }

        public final String getInputFormat() {
            return inputFormat;
        }

        public final void setInputFormat(String inputFormat) {
            this.inputFormat = inputFormat;
        }

        @Override
        @Transient
        public final Builder inputFormat(String inputFormat) {
            this.inputFormat = inputFormat;
            return this;
        }

        public final String getOutputFormat() {
            return outputFormat;
        }

        public final void setOutputFormat(String outputFormat) {
            this.outputFormat = outputFormat;
        }

        @Override
        @Transient
        public final Builder outputFormat(String outputFormat) {
            this.outputFormat = outputFormat;
            return this;
        }

        public final SerDeInfo.Builder getSerdeInfo() {
            return serdeInfo != null ? serdeInfo.toBuilder() : null;
        }

        public final void setSerdeInfo(SerDeInfo.BuilderImpl serdeInfo) {
            this.serdeInfo = serdeInfo != null ? serdeInfo.build() : null;
        }

        @Override
        @Transient
        public final Builder serdeInfo(SerDeInfo serdeInfo) {
            this.serdeInfo = serdeInfo;
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
        public StorageDescriptor build() {
            return new StorageDescriptor(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }
}
