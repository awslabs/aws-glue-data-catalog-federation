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
import software.amazon.awssdk.utils.ToString;
import software.amazon.awssdk.utils.builder.CopyableBuilder;
import software.amazon.awssdk.utils.builder.ToCopyableBuilder;

/**
 */
@Generated("software.amazon.awssdk:codegen")
public final class PropertyPredicate implements SdkPojo, Serializable,
        ToCopyableBuilder<PropertyPredicate.Builder, PropertyPredicate> {
    private static final SdkField<String> KEY_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("Key")
            .getter(getter(PropertyPredicate::key)).setter(setter(Builder::key))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Key").build()).build();

    private static final SdkField<String> VALUE_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("Value")
            .getter(getter(PropertyPredicate::value)).setter(setter(Builder::value))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Value").build()).build();

    private static final SdkField<String> COMPARATOR_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("Comparator").getter(getter(PropertyPredicate::comparatorAsString)).setter(setter(Builder::comparator))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Comparator").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(KEY_FIELD, VALUE_FIELD,
            COMPARATOR_FIELD));

    private static final long serialVersionUID = 1L;

    private final String key;

    private final String value;

    private final String comparator;

    private PropertyPredicate(BuilderImpl builder) {
        this.key = builder.key;
        this.value = builder.value;
        this.comparator = builder.comparator;
    }

    /**
     * Returns the value of the Key property for this object.
     * 
     * @return The value of the Key property for this object.
     */
    public final String key() {
        return key;
    }

    /**
     * Returns the value of the Value property for this object.
     * 
     * @return The value of the Value property for this object.
     */
    public final String value() {
        return value;
    }

    /**
     * Returns the value of the Comparator property for this object.
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #comparator} will
     * return {@link Comparator#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #comparatorAsString}.
     * </p>
     * 
     * @return The value of the Comparator property for this object.
     * @see Comparator
     */
    public final Comparator comparator() {
        return Comparator.fromValue(comparator);
    }

    /**
     * Returns the value of the Comparator property for this object.
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #comparator} will
     * return {@link Comparator#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #comparatorAsString}.
     * </p>
     * 
     * @return The value of the Comparator property for this object.
     * @see Comparator
     */
    public final String comparatorAsString() {
        return comparator;
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
        hashCode = 31 * hashCode + Objects.hashCode(key());
        hashCode = 31 * hashCode + Objects.hashCode(value());
        hashCode = 31 * hashCode + Objects.hashCode(comparatorAsString());
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
        if (!(obj instanceof PropertyPredicate)) {
            return false;
        }
        PropertyPredicate other = (PropertyPredicate) obj;
        return Objects.equals(key(), other.key()) && Objects.equals(value(), other.value())
                && Objects.equals(comparatorAsString(), other.comparatorAsString());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("PropertyPredicate").add("Key", key()).add("Value", value())
                .add("Comparator", comparatorAsString()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Key":
            return Optional.ofNullable(clazz.cast(key()));
        case "Value":
            return Optional.ofNullable(clazz.cast(value()));
        case "Comparator":
            return Optional.ofNullable(clazz.cast(comparatorAsString()));
        default:
            return Optional.empty();
        }
    }

    @Override
    public final List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    private static <T> Function<Object, T> getter(Function<PropertyPredicate, T> g) {
        return obj -> g.apply((PropertyPredicate) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    public interface Builder extends SdkPojo, CopyableBuilder<Builder, PropertyPredicate> {
        /**
         * Sets the value of the Key property for this object.
         *
         * @param key
         *        The new value for the Key property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder key(String key);

        /**
         * Sets the value of the Value property for this object.
         *
         * @param value
         *        The new value for the Value property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder value(String value);

        /**
         * Sets the value of the Comparator property for this object.
         *
         * @param comparator
         *        The new value for the Comparator property for this object.
         * @see Comparator
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see Comparator
         */
        Builder comparator(String comparator);

        /**
         * Sets the value of the Comparator property for this object.
         *
         * @param comparator
         *        The new value for the Comparator property for this object.
         * @see Comparator
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see Comparator
         */
        Builder comparator(Comparator comparator);
    }

    static final class BuilderImpl implements Builder {
        private String key;

        private String value;

        private String comparator;

        private BuilderImpl() {
        }

        private BuilderImpl(PropertyPredicate model) {
            key(model.key);
            value(model.value);
            comparator(model.comparator);
        }

        public final String getKey() {
            return key;
        }

        public final void setKey(String key) {
            this.key = key;
        }

        @Override
        @Transient
        public final Builder key(String key) {
            this.key = key;
            return this;
        }

        public final String getValue() {
            return value;
        }

        public final void setValue(String value) {
            this.value = value;
        }

        @Override
        @Transient
        public final Builder value(String value) {
            this.value = value;
            return this;
        }

        public final String getComparator() {
            return comparator;
        }

        public final void setComparator(String comparator) {
            this.comparator = comparator;
        }

        @Override
        @Transient
        public final Builder comparator(String comparator) {
            this.comparator = comparator;
            return this;
        }

        @Override
        @Transient
        public final Builder comparator(Comparator comparator) {
            this.comparator(comparator == null ? null : comparator.toString());
            return this;
        }

        @Override
        public PropertyPredicate build() {
            return new PropertyPredicate(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }
}
