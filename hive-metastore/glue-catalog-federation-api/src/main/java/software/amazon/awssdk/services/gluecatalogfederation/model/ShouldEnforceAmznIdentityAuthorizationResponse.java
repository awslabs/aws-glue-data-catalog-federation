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
public final class ShouldEnforceAmznIdentityAuthorizationResponse extends GlueCatalogFederationResponse implements
        ToCopyableBuilder<ShouldEnforceAmznIdentityAuthorizationResponse.Builder, ShouldEnforceAmznIdentityAuthorizationResponse> {
    private static final SdkField<Boolean> SHOULD_ENFORCE_FIELD = SdkField.<Boolean> builder(MarshallingType.BOOLEAN)
            .memberName("ShouldEnforce").getter(getter(ShouldEnforceAmznIdentityAuthorizationResponse::shouldEnforce))
            .setter(setter(Builder::shouldEnforce))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("ShouldEnforce").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(SHOULD_ENFORCE_FIELD));

    private final Boolean shouldEnforce;

    private ShouldEnforceAmznIdentityAuthorizationResponse(BuilderImpl builder) {
        super(builder);
        this.shouldEnforce = builder.shouldEnforce;
    }

    /**
     * Returns the value of the ShouldEnforce property for this object.
     * 
     * @return The value of the ShouldEnforce property for this object.
     */
    public final Boolean shouldEnforce() {
        return shouldEnforce;
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
        hashCode = 31 * hashCode + super.hashCode();
        hashCode = 31 * hashCode + Objects.hashCode(shouldEnforce());
        return hashCode;
    }

    @Override
    public final boolean equals(Object obj) {
        return super.equals(obj) && equalsBySdkFields(obj);
    }

    @Override
    public final boolean equalsBySdkFields(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ShouldEnforceAmznIdentityAuthorizationResponse)) {
            return false;
        }
        ShouldEnforceAmznIdentityAuthorizationResponse other = (ShouldEnforceAmznIdentityAuthorizationResponse) obj;
        return Objects.equals(shouldEnforce(), other.shouldEnforce());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("ShouldEnforceAmznIdentityAuthorizationResponse").add("ShouldEnforce", shouldEnforce()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "ShouldEnforce":
            return Optional.ofNullable(clazz.cast(shouldEnforce()));
        default:
            return Optional.empty();
        }
    }

    @Override
    public final List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    private static <T> Function<Object, T> getter(Function<ShouldEnforceAmznIdentityAuthorizationResponse, T> g) {
        return obj -> g.apply((ShouldEnforceAmznIdentityAuthorizationResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    public interface Builder extends GlueCatalogFederationResponse.Builder, SdkPojo,
            CopyableBuilder<Builder, ShouldEnforceAmznIdentityAuthorizationResponse> {
        /**
         * Sets the value of the ShouldEnforce property for this object.
         *
         * @param shouldEnforce
         *        The new value for the ShouldEnforce property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder shouldEnforce(Boolean shouldEnforce);
    }

    static final class BuilderImpl extends GlueCatalogFederationResponse.BuilderImpl implements Builder {
        private Boolean shouldEnforce;

        private BuilderImpl() {
        }

        private BuilderImpl(ShouldEnforceAmznIdentityAuthorizationResponse model) {
            super(model);
            shouldEnforce(model.shouldEnforce);
        }

        public final Boolean getShouldEnforce() {
            return shouldEnforce;
        }

        public final void setShouldEnforce(Boolean shouldEnforce) {
            this.shouldEnforce = shouldEnforce;
        }

        @Override
        @Transient
        public final Builder shouldEnforce(Boolean shouldEnforce) {
            this.shouldEnforce = shouldEnforce;
            return this;
        }

        @Override
        public ShouldEnforceAmznIdentityAuthorizationResponse build() {
            return new ShouldEnforceAmznIdentityAuthorizationResponse(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }
}
