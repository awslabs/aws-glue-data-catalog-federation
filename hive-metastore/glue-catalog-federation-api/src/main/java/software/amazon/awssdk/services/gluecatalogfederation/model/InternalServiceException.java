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
import java.util.function.BiConsumer;
import java.util.function.Function;
import software.amazon.awssdk.annotations.Generated;
import software.amazon.awssdk.awscore.exception.AwsErrorDetails;
import software.amazon.awssdk.core.SdkField;
import software.amazon.awssdk.core.SdkPojo;
import software.amazon.awssdk.core.protocol.MarshallLocation;
import software.amazon.awssdk.core.protocol.MarshallingType;
import software.amazon.awssdk.core.traits.LocationTrait;
import software.amazon.awssdk.utils.builder.CopyableBuilder;
import software.amazon.awssdk.utils.builder.ToCopyableBuilder;

/**
 */
@Generated("software.amazon.awssdk:codegen")
public final class InternalServiceException extends GlueCatalogFederationException implements
        ToCopyableBuilder<InternalServiceException.Builder, InternalServiceException> {
    private static final SdkField<Boolean> SHOULD_RETRY_FIELD = SdkField.<Boolean> builder(MarshallingType.BOOLEAN)
            .memberName("ShouldRetry").getter(getter(InternalServiceException::shouldRetry)).setter(setter(Builder::shouldRetry))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("ShouldRetry").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(SHOULD_RETRY_FIELD));

    private static final long serialVersionUID = 1L;

    private final Boolean shouldRetry;

    private InternalServiceException(BuilderImpl builder) {
        super(builder);
        this.shouldRetry = builder.shouldRetry;
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

    /**
     * Returns the value of the ShouldRetry property for this object.
     * 
     * @return The value of the ShouldRetry property for this object.
     */
    public Boolean shouldRetry() {
        return shouldRetry;
    }

    @Override
    public final List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    private static <T> Function<Object, T> getter(Function<InternalServiceException, T> g) {
        return obj -> g.apply((InternalServiceException) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    public interface Builder extends SdkPojo, CopyableBuilder<Builder, InternalServiceException>,
            GlueCatalogFederationException.Builder {
        /**
         * Sets the value of the ShouldRetry property for this object.
         *
         * @param shouldRetry
         *        The new value for the ShouldRetry property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder shouldRetry(Boolean shouldRetry);

        @Override
        Builder awsErrorDetails(AwsErrorDetails awsErrorDetails);

        @Override
        Builder message(String message);

        @Override
        Builder requestId(String requestId);

        @Override
        Builder statusCode(int statusCode);

        @Override
        Builder cause(Throwable cause);
    }

    static final class BuilderImpl extends GlueCatalogFederationException.BuilderImpl implements Builder {
        private Boolean shouldRetry;

        private BuilderImpl() {
        }

        private BuilderImpl(InternalServiceException model) {
            super(model);
            shouldRetry(model.shouldRetry);
        }

        public final Boolean getShouldRetry() {
            return shouldRetry;
        }

        public final void setShouldRetry(Boolean shouldRetry) {
            this.shouldRetry = shouldRetry;
        }

        @Override
        @Transient
        public final Builder shouldRetry(Boolean shouldRetry) {
            this.shouldRetry = shouldRetry;
            return this;
        }

        @Override
        public BuilderImpl awsErrorDetails(AwsErrorDetails awsErrorDetails) {
            this.awsErrorDetails = awsErrorDetails;
            return this;
        }

        @Override
        public BuilderImpl message(String message) {
            this.message = message;
            return this;
        }

        @Override
        public BuilderImpl requestId(String requestId) {
            this.requestId = requestId;
            return this;
        }

        @Override
        public BuilderImpl statusCode(int statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        @Override
        public BuilderImpl cause(Throwable cause) {
            this.cause = cause;
            return this;
        }

        @Override
        public InternalServiceException build() {
            return new InternalServiceException(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }
}
