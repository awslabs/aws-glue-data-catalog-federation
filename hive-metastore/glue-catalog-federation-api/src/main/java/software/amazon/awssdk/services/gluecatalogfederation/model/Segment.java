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
public final class Segment implements SdkPojo, Serializable, ToCopyableBuilder<Segment.Builder, Segment> {
    private static final SdkField<Integer> SEGMENT_NUMBER_FIELD = SdkField.<Integer> builder(MarshallingType.INTEGER)
            .memberName("SegmentNumber").getter(getter(Segment::segmentNumber)).setter(setter(Builder::segmentNumber))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("SegmentNumber").build()).build();

    private static final SdkField<Integer> TOTAL_SEGMENTS_FIELD = SdkField.<Integer> builder(MarshallingType.INTEGER)
            .memberName("TotalSegments").getter(getter(Segment::totalSegments)).setter(setter(Builder::totalSegments))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("TotalSegments").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(SEGMENT_NUMBER_FIELD,
            TOTAL_SEGMENTS_FIELD));

    private static final long serialVersionUID = 1L;

    private final Integer segmentNumber;

    private final Integer totalSegments;

    private Segment(BuilderImpl builder) {
        this.segmentNumber = builder.segmentNumber;
        this.totalSegments = builder.totalSegments;
    }

    /**
     * Returns the value of the SegmentNumber property for this object.
     * 
     * @return The value of the SegmentNumber property for this object.
     */
    public final Integer segmentNumber() {
        return segmentNumber;
    }

    /**
     * Returns the value of the TotalSegments property for this object.
     * 
     * @return The value of the TotalSegments property for this object.
     */
    public final Integer totalSegments() {
        return totalSegments;
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
        hashCode = 31 * hashCode + Objects.hashCode(segmentNumber());
        hashCode = 31 * hashCode + Objects.hashCode(totalSegments());
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
        if (!(obj instanceof Segment)) {
            return false;
        }
        Segment other = (Segment) obj;
        return Objects.equals(segmentNumber(), other.segmentNumber()) && Objects.equals(totalSegments(), other.totalSegments());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("Segment").add("SegmentNumber", segmentNumber()).add("TotalSegments", totalSegments()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "SegmentNumber":
            return Optional.ofNullable(clazz.cast(segmentNumber()));
        case "TotalSegments":
            return Optional.ofNullable(clazz.cast(totalSegments()));
        default:
            return Optional.empty();
        }
    }

    @Override
    public final List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    private static <T> Function<Object, T> getter(Function<Segment, T> g) {
        return obj -> g.apply((Segment) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    public interface Builder extends SdkPojo, CopyableBuilder<Builder, Segment> {
        /**
         * Sets the value of the SegmentNumber property for this object.
         *
         * @param segmentNumber
         *        The new value for the SegmentNumber property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder segmentNumber(Integer segmentNumber);

        /**
         * Sets the value of the TotalSegments property for this object.
         *
         * @param totalSegments
         *        The new value for the TotalSegments property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder totalSegments(Integer totalSegments);
    }

    static final class BuilderImpl implements Builder {
        private Integer segmentNumber;

        private Integer totalSegments;

        private BuilderImpl() {
        }

        private BuilderImpl(Segment model) {
            segmentNumber(model.segmentNumber);
            totalSegments(model.totalSegments);
        }

        public final Integer getSegmentNumber() {
            return segmentNumber;
        }

        public final void setSegmentNumber(Integer segmentNumber) {
            this.segmentNumber = segmentNumber;
        }

        @Override
        @Transient
        public final Builder segmentNumber(Integer segmentNumber) {
            this.segmentNumber = segmentNumber;
            return this;
        }

        public final Integer getTotalSegments() {
            return totalSegments;
        }

        public final void setTotalSegments(Integer totalSegments) {
            this.totalSegments = totalSegments;
        }

        @Override
        @Transient
        public final Builder totalSegments(Integer totalSegments) {
            this.totalSegments = totalSegments;
            return this;
        }

        @Override
        public Segment build() {
            return new Segment(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }
}
