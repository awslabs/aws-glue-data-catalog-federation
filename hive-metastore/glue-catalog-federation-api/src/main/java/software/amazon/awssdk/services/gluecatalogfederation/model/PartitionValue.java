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
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;
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
public final class PartitionValue implements SdkPojo, Serializable, ToCopyableBuilder<PartitionValue.Builder, PartitionValue> {
    private static final SdkField<List<String>> VALUES_FIELD = SdkField
            .<List<String>> builder(MarshallingType.LIST)
            .memberName("Values")
            .getter(getter(PartitionValue::values))
            .setter(setter(Builder::values))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Values").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<String> builder(MarshallingType.STRING)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").build()).build()).build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(VALUES_FIELD));

    private static final long serialVersionUID = 1L;

    private final List<String> values;

    private PartitionValue(BuilderImpl builder) {
        this.values = builder.values;
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
        hashCode = 31 * hashCode + Objects.hashCode(hasValues() ? values() : null);
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
        if (!(obj instanceof PartitionValue)) {
            return false;
        }
        PartitionValue other = (PartitionValue) obj;
        return hasValues() == other.hasValues() && Objects.equals(values(), other.values());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("PartitionValue").add("Values", hasValues() ? values() : null).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Values":
            return Optional.ofNullable(clazz.cast(values()));
        default:
            return Optional.empty();
        }
    }

    @Override
    public final List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    private static <T> Function<Object, T> getter(Function<PartitionValue, T> g) {
        return obj -> g.apply((PartitionValue) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    public interface Builder extends SdkPojo, CopyableBuilder<Builder, PartitionValue> {
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
    }

    static final class BuilderImpl implements Builder {
        private List<String> values = DefaultSdkAutoConstructList.getInstance();

        private BuilderImpl() {
        }

        private BuilderImpl(PartitionValue model) {
            values(model.values);
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

        @Override
        public PartitionValue build() {
            return new PartitionValue(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }
}
