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
public final class AccessDeniedException extends GlueCatalogFederationException implements
        ToCopyableBuilder<AccessDeniedException.Builder, AccessDeniedException> {
    private static final SdkField<String> RESOURCE_NAME_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("ResourceName").getter(getter(AccessDeniedException::resourceName)).setter(setter(Builder::resourceName))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("ResourceName").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(RESOURCE_NAME_FIELD));

    private static final long serialVersionUID = 1L;

    private final String resourceName;

    private AccessDeniedException(BuilderImpl builder) {
        super(builder);
        this.resourceName = builder.resourceName;
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
     * Returns the value of the ResourceName property for this object.
     * 
     * @return The value of the ResourceName property for this object.
     */
    public String resourceName() {
        return resourceName;
    }

    @Override
    public final List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    private static <T> Function<Object, T> getter(Function<AccessDeniedException, T> g) {
        return obj -> g.apply((AccessDeniedException) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    public interface Builder extends SdkPojo, CopyableBuilder<Builder, AccessDeniedException>,
            GlueCatalogFederationException.Builder {
        /**
         * Sets the value of the ResourceName property for this object.
         *
         * @param resourceName
         *        The new value for the ResourceName property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder resourceName(String resourceName);

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
        private String resourceName;

        private BuilderImpl() {
        }

        private BuilderImpl(AccessDeniedException model) {
            super(model);
            resourceName(model.resourceName);
        }

        public final String getResourceName() {
            return resourceName;
        }

        public final void setResourceName(String resourceName) {
            this.resourceName = resourceName;
        }

        @Override
        @Transient
        public final Builder resourceName(String resourceName) {
            this.resourceName = resourceName;
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
        public AccessDeniedException build() {
            return new AccessDeniedException(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }
}
