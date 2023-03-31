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
public final class CallerIdentity implements SdkPojo, Serializable, ToCopyableBuilder<CallerIdentity.Builder, CallerIdentity> {
    private static final SdkField<String> CALLER_USER_ARN_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("CallerUserArn").getter(getter(CallerIdentity::callerUserArn)).setter(setter(Builder::callerUserArn))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("CallerUserArn").build()).build();

    private static final SdkField<String> LAKE_FORMATION_USER_ARN_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("LakeFormationUserArn").getter(getter(CallerIdentity::lakeFormationUserArn))
            .setter(setter(Builder::lakeFormationUserArn))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("LakeFormationUserArn").build())
            .build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(CALLER_USER_ARN_FIELD,
            LAKE_FORMATION_USER_ARN_FIELD));

    private static final long serialVersionUID = 1L;

    private final String callerUserArn;

    private final String lakeFormationUserArn;

    private CallerIdentity(BuilderImpl builder) {
        this.callerUserArn = builder.callerUserArn;
        this.lakeFormationUserArn = builder.lakeFormationUserArn;
    }

    /**
     * Returns the value of the CallerUserArn property for this object.
     * 
     * @return The value of the CallerUserArn property for this object.
     */
    public final String callerUserArn() {
        return callerUserArn;
    }

    /**
     * Returns the value of the LakeFormationUserArn property for this object.
     * 
     * @return The value of the LakeFormationUserArn property for this object.
     */
    public final String lakeFormationUserArn() {
        return lakeFormationUserArn;
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
        hashCode = 31 * hashCode + Objects.hashCode(callerUserArn());
        hashCode = 31 * hashCode + Objects.hashCode(lakeFormationUserArn());
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
        if (!(obj instanceof CallerIdentity)) {
            return false;
        }
        CallerIdentity other = (CallerIdentity) obj;
        return Objects.equals(callerUserArn(), other.callerUserArn())
                && Objects.equals(lakeFormationUserArn(), other.lakeFormationUserArn());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("CallerIdentity").add("CallerUserArn", callerUserArn())
                .add("LakeFormationUserArn", lakeFormationUserArn()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "CallerUserArn":
            return Optional.ofNullable(clazz.cast(callerUserArn()));
        case "LakeFormationUserArn":
            return Optional.ofNullable(clazz.cast(lakeFormationUserArn()));
        default:
            return Optional.empty();
        }
    }

    @Override
    public final List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    private static <T> Function<Object, T> getter(Function<CallerIdentity, T> g) {
        return obj -> g.apply((CallerIdentity) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    public interface Builder extends SdkPojo, CopyableBuilder<Builder, CallerIdentity> {
        /**
         * Sets the value of the CallerUserArn property for this object.
         *
         * @param callerUserArn
         *        The new value for the CallerUserArn property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder callerUserArn(String callerUserArn);

        /**
         * Sets the value of the LakeFormationUserArn property for this object.
         *
         * @param lakeFormationUserArn
         *        The new value for the LakeFormationUserArn property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder lakeFormationUserArn(String lakeFormationUserArn);
    }

    static final class BuilderImpl implements Builder {
        private String callerUserArn;

        private String lakeFormationUserArn;

        private BuilderImpl() {
        }

        private BuilderImpl(CallerIdentity model) {
            callerUserArn(model.callerUserArn);
            lakeFormationUserArn(model.lakeFormationUserArn);
        }

        public final String getCallerUserArn() {
            return callerUserArn;
        }

        public final void setCallerUserArn(String callerUserArn) {
            this.callerUserArn = callerUserArn;
        }

        @Override
        @Transient
        public final Builder callerUserArn(String callerUserArn) {
            this.callerUserArn = callerUserArn;
            return this;
        }

        public final String getLakeFormationUserArn() {
            return lakeFormationUserArn;
        }

        public final void setLakeFormationUserArn(String lakeFormationUserArn) {
            this.lakeFormationUserArn = lakeFormationUserArn;
        }

        @Override
        @Transient
        public final Builder lakeFormationUserArn(String lakeFormationUserArn) {
            this.lakeFormationUserArn = lakeFormationUserArn;
            return this;
        }

        @Override
        public CallerIdentity build() {
            return new CallerIdentity(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }
}
