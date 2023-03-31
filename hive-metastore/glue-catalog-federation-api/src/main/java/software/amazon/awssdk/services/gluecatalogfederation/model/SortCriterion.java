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
public final class SortCriterion implements SdkPojo, Serializable, ToCopyableBuilder<SortCriterion.Builder, SortCriterion> {
    private static final SdkField<String> FIELD_NAME_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("FieldName").getter(getter(SortCriterion::fieldName)).setter(setter(Builder::fieldName))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("FieldName").build()).build();

    private static final SdkField<String> SORT_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("Sort")
            .getter(getter(SortCriterion::sortAsString)).setter(setter(Builder::sort))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Sort").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(FIELD_NAME_FIELD, SORT_FIELD));

    private static final long serialVersionUID = 1L;

    private final String fieldName;

    private final String sort;

    private SortCriterion(BuilderImpl builder) {
        this.fieldName = builder.fieldName;
        this.sort = builder.sort;
    }

    /**
     * Returns the value of the FieldName property for this object.
     * 
     * @return The value of the FieldName property for this object.
     */
    public final String fieldName() {
        return fieldName;
    }

    /**
     * Returns the value of the Sort property for this object.
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #sort} will return
     * {@link Sort#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #sortAsString}.
     * </p>
     * 
     * @return The value of the Sort property for this object.
     * @see Sort
     */
    public final Sort sort() {
        return Sort.fromValue(sort);
    }

    /**
     * Returns the value of the Sort property for this object.
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #sort} will return
     * {@link Sort#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #sortAsString}.
     * </p>
     * 
     * @return The value of the Sort property for this object.
     * @see Sort
     */
    public final String sortAsString() {
        return sort;
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
        hashCode = 31 * hashCode + Objects.hashCode(fieldName());
        hashCode = 31 * hashCode + Objects.hashCode(sortAsString());
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
        if (!(obj instanceof SortCriterion)) {
            return false;
        }
        SortCriterion other = (SortCriterion) obj;
        return Objects.equals(fieldName(), other.fieldName()) && Objects.equals(sortAsString(), other.sortAsString());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("SortCriterion").add("FieldName", fieldName()).add("Sort", sortAsString()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "FieldName":
            return Optional.ofNullable(clazz.cast(fieldName()));
        case "Sort":
            return Optional.ofNullable(clazz.cast(sortAsString()));
        default:
            return Optional.empty();
        }
    }

    @Override
    public final List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    private static <T> Function<Object, T> getter(Function<SortCriterion, T> g) {
        return obj -> g.apply((SortCriterion) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    public interface Builder extends SdkPojo, CopyableBuilder<Builder, SortCriterion> {
        /**
         * Sets the value of the FieldName property for this object.
         *
         * @param fieldName
         *        The new value for the FieldName property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder fieldName(String fieldName);

        /**
         * Sets the value of the Sort property for this object.
         *
         * @param sort
         *        The new value for the Sort property for this object.
         * @see Sort
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see Sort
         */
        Builder sort(String sort);

        /**
         * Sets the value of the Sort property for this object.
         *
         * @param sort
         *        The new value for the Sort property for this object.
         * @see Sort
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see Sort
         */
        Builder sort(Sort sort);
    }

    static final class BuilderImpl implements Builder {
        private String fieldName;

        private String sort;

        private BuilderImpl() {
        }

        private BuilderImpl(SortCriterion model) {
            fieldName(model.fieldName);
            sort(model.sort);
        }

        public final String getFieldName() {
            return fieldName;
        }

        public final void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        @Override
        @Transient
        public final Builder fieldName(String fieldName) {
            this.fieldName = fieldName;
            return this;
        }

        public final String getSort() {
            return sort;
        }

        public final void setSort(String sort) {
            this.sort = sort;
        }

        @Override
        @Transient
        public final Builder sort(String sort) {
            this.sort = sort;
            return this;
        }

        @Override
        @Transient
        public final Builder sort(Sort sort) {
            this.sort(sort == null ? null : sort.toString());
            return this;
        }

        @Override
        public SortCriterion build() {
            return new SortCriterion(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }
}
