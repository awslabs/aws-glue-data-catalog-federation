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
import java.util.function.Consumer;
import java.util.function.Function;
import software.amazon.awssdk.annotations.Generated;
import software.amazon.awssdk.awscore.AwsRequestOverrideConfiguration;
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
public final class ShouldEnforceAmznIdentityAuthorizationRequest extends GlueCatalogFederationRequest implements
        ToCopyableBuilder<ShouldEnforceAmznIdentityAuthorizationRequest.Builder, ShouldEnforceAmznIdentityAuthorizationRequest> {
    private static final SdkField<String> CALLER_ACCOUNT_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("CallerAccountId").getter(getter(ShouldEnforceAmznIdentityAuthorizationRequest::callerAccountId))
            .setter(setter(Builder::callerAccountId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("CallerAccountId").build()).build();

    private static final SdkField<String> GLUE_RESOURCE_ARN_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("GlueResourceArn").getter(getter(ShouldEnforceAmznIdentityAuthorizationRequest::glueResourceArn))
            .setter(setter(Builder::glueResourceArn))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("GlueResourceArn").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(CALLER_ACCOUNT_ID_FIELD,
            GLUE_RESOURCE_ARN_FIELD));

    private final String callerAccountId;

    private final String glueResourceArn;

    private ShouldEnforceAmznIdentityAuthorizationRequest(BuilderImpl builder) {
        super(builder);
        this.callerAccountId = builder.callerAccountId;
        this.glueResourceArn = builder.glueResourceArn;
    }

    /**
     * Returns the value of the CallerAccountId property for this object.
     * 
     * @return The value of the CallerAccountId property for this object.
     */
    public final String callerAccountId() {
        return callerAccountId;
    }

    /**
     * Returns the value of the GlueResourceArn property for this object.
     * 
     * @return The value of the GlueResourceArn property for this object.
     */
    public final String glueResourceArn() {
        return glueResourceArn;
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
        hashCode = 31 * hashCode + Objects.hashCode(callerAccountId());
        hashCode = 31 * hashCode + Objects.hashCode(glueResourceArn());
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
        if (!(obj instanceof ShouldEnforceAmznIdentityAuthorizationRequest)) {
            return false;
        }
        ShouldEnforceAmznIdentityAuthorizationRequest other = (ShouldEnforceAmznIdentityAuthorizationRequest) obj;
        return Objects.equals(callerAccountId(), other.callerAccountId())
                && Objects.equals(glueResourceArn(), other.glueResourceArn());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("ShouldEnforceAmznIdentityAuthorizationRequest").add("CallerAccountId", callerAccountId())
                .add("GlueResourceArn", glueResourceArn()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "CallerAccountId":
            return Optional.ofNullable(clazz.cast(callerAccountId()));
        case "GlueResourceArn":
            return Optional.ofNullable(clazz.cast(glueResourceArn()));
        default:
            return Optional.empty();
        }
    }

    @Override
    public final List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    private static <T> Function<Object, T> getter(Function<ShouldEnforceAmznIdentityAuthorizationRequest, T> g) {
        return obj -> g.apply((ShouldEnforceAmznIdentityAuthorizationRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    public interface Builder extends GlueCatalogFederationRequest.Builder, SdkPojo,
            CopyableBuilder<Builder, ShouldEnforceAmznIdentityAuthorizationRequest> {
        /**
         * Sets the value of the CallerAccountId property for this object.
         *
         * @param callerAccountId
         *        The new value for the CallerAccountId property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder callerAccountId(String callerAccountId);

        /**
         * Sets the value of the GlueResourceArn property for this object.
         *
         * @param glueResourceArn
         *        The new value for the GlueResourceArn property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder glueResourceArn(String glueResourceArn);

        @Override
        Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration);

        @Override
        Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer);
    }

    static final class BuilderImpl extends GlueCatalogFederationRequest.BuilderImpl implements Builder {
        private String callerAccountId;

        private String glueResourceArn;

        private BuilderImpl() {
        }

        private BuilderImpl(ShouldEnforceAmznIdentityAuthorizationRequest model) {
            super(model);
            callerAccountId(model.callerAccountId);
            glueResourceArn(model.glueResourceArn);
        }

        public final String getCallerAccountId() {
            return callerAccountId;
        }

        public final void setCallerAccountId(String callerAccountId) {
            this.callerAccountId = callerAccountId;
        }

        @Override
        @Transient
        public final Builder callerAccountId(String callerAccountId) {
            this.callerAccountId = callerAccountId;
            return this;
        }

        public final String getGlueResourceArn() {
            return glueResourceArn;
        }

        public final void setGlueResourceArn(String glueResourceArn) {
            this.glueResourceArn = glueResourceArn;
        }

        @Override
        @Transient
        public final Builder glueResourceArn(String glueResourceArn) {
            this.glueResourceArn = glueResourceArn;
            return this;
        }

        @Override
        public Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration) {
            super.overrideConfiguration(overrideConfiguration);
            return this;
        }

        @Override
        public Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer) {
            super.overrideConfiguration(builderConsumer);
            return this;
        }

        @Override
        public ShouldEnforceAmznIdentityAuthorizationRequest build() {
            return new ShouldEnforceAmznIdentityAuthorizationRequest(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }
}
