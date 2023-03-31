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
public final class ColumnFilter implements SdkPojo, Serializable, ToCopyableBuilder<ColumnFilter.Builder, ColumnFilter> {
    private static final SdkField<String> NAME_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("Name")
            .getter(getter(ColumnFilter::name)).setter(setter(Builder::name))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Name").build()).build();

    private static final SdkField<String> FILTER_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("Filter")
            .getter(getter(ColumnFilter::filter)).setter(setter(Builder::filter))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Filter").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(NAME_FIELD, FILTER_FIELD));

    private static final long serialVersionUID = 1L;

    private final String name;

    private final String filter;

    private ColumnFilter(BuilderImpl builder) {
        this.name = builder.name;
        this.filter = builder.filter;
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
     * Returns the value of the Filter property for this object.
     * 
     * @return The value of the Filter property for this object.
     */
    public final String filter() {
        return filter;
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
        hashCode = 31 * hashCode + Objects.hashCode(filter());
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
        if (!(obj instanceof ColumnFilter)) {
            return false;
        }
        ColumnFilter other = (ColumnFilter) obj;
        return Objects.equals(name(), other.name()) && Objects.equals(filter(), other.filter());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("ColumnFilter").add("Name", name()).add("Filter", filter()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Name":
            return Optional.ofNullable(clazz.cast(name()));
        case "Filter":
            return Optional.ofNullable(clazz.cast(filter()));
        default:
            return Optional.empty();
        }
    }

    @Override
    public final List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    private static <T> Function<Object, T> getter(Function<ColumnFilter, T> g) {
        return obj -> g.apply((ColumnFilter) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    public interface Builder extends SdkPojo, CopyableBuilder<Builder, ColumnFilter> {
        /**
         * Sets the value of the Name property for this object.
         *
         * @param name
         *        The new value for the Name property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder name(String name);

        /**
         * Sets the value of the Filter property for this object.
         *
         * @param filter
         *        The new value for the Filter property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder filter(String filter);
    }

    static final class BuilderImpl implements Builder {
        private String name;

        private String filter;

        private BuilderImpl() {
        }

        private BuilderImpl(ColumnFilter model) {
            name(model.name);
            filter(model.filter);
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

        public final String getFilter() {
            return filter;
        }

        public final void setFilter(String filter) {
            this.filter = filter;
        }

        @Override
        @Transient
        public final Builder filter(String filter) {
            this.filter = filter;
            return this;
        }

        @Override
        public ColumnFilter build() {
            return new ColumnFilter(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }
}
