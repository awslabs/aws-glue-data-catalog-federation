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
public final class SerDeInfo implements SdkPojo, Serializable, ToCopyableBuilder<SerDeInfo.Builder, SerDeInfo> {
    private static final SdkField<String> NAME_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("Name")
            .getter(getter(SerDeInfo::name)).setter(setter(Builder::name))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Name").build()).build();

    private static final SdkField<String> SERIALIZATION_LIBRARY_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("SerializationLibrary").getter(getter(SerDeInfo::serializationLibrary))
            .setter(setter(Builder::serializationLibrary))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("SerializationLibrary").build())
            .build();

    private static final SdkField<Map<String, String>> PARAMETERS_FIELD = SdkField
            .<Map<String, String>> builder(MarshallingType.MAP)
            .memberName("Parameters")
            .getter(getter(SerDeInfo::parameters))
            .setter(setter(Builder::parameters))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Parameters").build(),
                    MapTrait.builder()
                            .keyLocationName("key")
                            .valueLocationName("value")
                            .valueFieldInfo(
                                    SdkField.<String> builder(MarshallingType.STRING)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("value").build()).build()).build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(NAME_FIELD,
            SERIALIZATION_LIBRARY_FIELD, PARAMETERS_FIELD));

    private static final long serialVersionUID = 1L;

    private final String name;

    private final String serializationLibrary;

    private final Map<String, String> parameters;

    private SerDeInfo(BuilderImpl builder) {
        this.name = builder.name;
        this.serializationLibrary = builder.serializationLibrary;
        this.parameters = builder.parameters;
    }

    /**
     * Returns the value of the Name property for this object.
     * 
     * @return The value of the Name property for this object.
     */
    public final String name() {
        return name;
    }

    /**
     * Returns the value of the SerializationLibrary property for this object.
     * 
     * @return The value of the SerializationLibrary property for this object.
     */
    public final String serializationLibrary() {
        return serializationLibrary;
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
        hashCode = 31 * hashCode + Objects.hashCode(name());
        hashCode = 31 * hashCode + Objects.hashCode(serializationLibrary());
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
        if (!(obj instanceof SerDeInfo)) {
            return false;
        }
        SerDeInfo other = (SerDeInfo) obj;
        return Objects.equals(name(), other.name()) && Objects.equals(serializationLibrary(), other.serializationLibrary())
                && hasParameters() == other.hasParameters() && Objects.equals(parameters(), other.parameters());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("SerDeInfo").add("Name", name()).add("SerializationLibrary", serializationLibrary())
                .add("Parameters", hasParameters() ? parameters() : null).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Name":
            return Optional.ofNullable(clazz.cast(name()));
        case "SerializationLibrary":
            return Optional.ofNullable(clazz.cast(serializationLibrary()));
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

    private static <T> Function<Object, T> getter(Function<SerDeInfo, T> g) {
        return obj -> g.apply((SerDeInfo) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    public interface Builder extends SdkPojo, CopyableBuilder<Builder, SerDeInfo> {
        /**
         * Sets the value of the Name property for this object.
         *
         * @param name
         *        The new value for the Name property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder name(String name);

        /**
         * Sets the value of the SerializationLibrary property for this object.
         *
         * @param serializationLibrary
         *        The new value for the SerializationLibrary property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder serializationLibrary(String serializationLibrary);

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
        private String name;

        private String serializationLibrary;

        private Map<String, String> parameters = DefaultSdkAutoConstructMap.getInstance();

        private BuilderImpl() {
        }

        private BuilderImpl(SerDeInfo model) {
            name(model.name);
            serializationLibrary(model.serializationLibrary);
            parameters(model.parameters);
        }

        public final String getName() {
            return name;
        }

        public final void setName(String name) {
            this.name = name;
        }

        @Override
        @Transient
        public final Builder name(String name) {
            this.name = name;
            return this;
        }

        public final String getSerializationLibrary() {
            return serializationLibrary;
        }

        public final void setSerializationLibrary(String serializationLibrary) {
            this.serializationLibrary = serializationLibrary;
        }

        @Override
        @Transient
        public final Builder serializationLibrary(String serializationLibrary) {
            this.serializationLibrary = serializationLibrary;
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
        public SerDeInfo build() {
            return new SerDeInfo(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }
}
