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
public final class GetTablePermissionBoundaryResponse extends GlueCatalogFederationResponse implements
        ToCopyableBuilder<GetTablePermissionBoundaryResponse.Builder, GetTablePermissionBoundaryResponse> {
    private static final SdkField<PermissionBoundary> PERMISSION_BOUNDARY_FIELD = SdkField
            .<PermissionBoundary> builder(MarshallingType.SDK_POJO).memberName("PermissionBoundary")
            .getter(getter(GetTablePermissionBoundaryResponse::permissionBoundary)).setter(setter(Builder::permissionBoundary))
            .constructor(PermissionBoundary::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("PermissionBoundary").build())
            .build();

    private static final SdkField<String> RESPONSE_CONTEXT_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("ResponseContext").getter(getter(GetTablePermissionBoundaryResponse::responseContext))
            .setter(setter(Builder::responseContext))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("ResponseContext").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(PERMISSION_BOUNDARY_FIELD,
            RESPONSE_CONTEXT_FIELD));

    private final PermissionBoundary permissionBoundary;

    private final String responseContext;

    private GetTablePermissionBoundaryResponse(BuilderImpl builder) {
        super(builder);
        this.permissionBoundary = builder.permissionBoundary;
        this.responseContext = builder.responseContext;
    }

    /**
     * Returns the value of the PermissionBoundary property for this object.
     * 
     * @return The value of the PermissionBoundary property for this object.
     */
    public final PermissionBoundary permissionBoundary() {
        return permissionBoundary;
    }

    /**
     * Returns the value of the ResponseContext property for this object.
     * 
     * @return The value of the ResponseContext property for this object.
     */
    public final String responseContext() {
        return responseContext;
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
        hashCode = 31 * hashCode + Objects.hashCode(permissionBoundary());
        hashCode = 31 * hashCode + Objects.hashCode(responseContext());
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
        if (!(obj instanceof GetTablePermissionBoundaryResponse)) {
            return false;
        }
        GetTablePermissionBoundaryResponse other = (GetTablePermissionBoundaryResponse) obj;
        return Objects.equals(permissionBoundary(), other.permissionBoundary())
                && Objects.equals(responseContext(), other.responseContext());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("GetTablePermissionBoundaryResponse").add("PermissionBoundary", permissionBoundary())
                .add("ResponseContext", responseContext()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "PermissionBoundary":
            return Optional.ofNullable(clazz.cast(permissionBoundary()));
        case "ResponseContext":
            return Optional.ofNullable(clazz.cast(responseContext()));
        default:
            return Optional.empty();
        }
    }

    @Override
    public final List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    private static <T> Function<Object, T> getter(Function<GetTablePermissionBoundaryResponse, T> g) {
        return obj -> g.apply((GetTablePermissionBoundaryResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    public interface Builder extends GlueCatalogFederationResponse.Builder, SdkPojo,
            CopyableBuilder<Builder, GetTablePermissionBoundaryResponse> {
        /**
         * Sets the value of the PermissionBoundary property for this object.
         *
         * @param permissionBoundary
         *        The new value for the PermissionBoundary property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder permissionBoundary(PermissionBoundary permissionBoundary);

        /**
         * Sets the value of the PermissionBoundary property for this object.
         *
         * This is a convenience that creates an instance of the {@link PermissionBoundary.Builder} avoiding the need to
         * create one manually via {@link PermissionBoundary#builder()}.
         *
         * When the {@link Consumer} completes, {@link PermissionBoundary.Builder#build()} is called immediately and its
         * result is passed to {@link #permissionBoundary(PermissionBoundary)}.
         * 
         * @param permissionBoundary
         *        a consumer that will call methods on {@link PermissionBoundary.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #permissionBoundary(PermissionBoundary)
         */
        default Builder permissionBoundary(Consumer<PermissionBoundary.Builder> permissionBoundary) {
            return permissionBoundary(PermissionBoundary.builder().applyMutation(permissionBoundary).build());
        }

        /**
         * Sets the value of the ResponseContext property for this object.
         *
         * @param responseContext
         *        The new value for the ResponseContext property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder responseContext(String responseContext);
    }

    static final class BuilderImpl extends GlueCatalogFederationResponse.BuilderImpl implements Builder {
        private PermissionBoundary permissionBoundary;

        private String responseContext;

        private BuilderImpl() {
        }

        private BuilderImpl(GetTablePermissionBoundaryResponse model) {
            super(model);
            permissionBoundary(model.permissionBoundary);
            responseContext(model.responseContext);
        }

        public final PermissionBoundary.Builder getPermissionBoundary() {
            return permissionBoundary != null ? permissionBoundary.toBuilder() : null;
        }

        public final void setPermissionBoundary(PermissionBoundary.BuilderImpl permissionBoundary) {
            this.permissionBoundary = permissionBoundary != null ? permissionBoundary.build() : null;
        }

        @Override
        @Transient
        public final Builder permissionBoundary(PermissionBoundary permissionBoundary) {
            this.permissionBoundary = permissionBoundary;
            return this;
        }

        public final String getResponseContext() {
            return responseContext;
        }

        public final void setResponseContext(String responseContext) {
            this.responseContext = responseContext;
        }

        @Override
        @Transient
        public final Builder responseContext(String responseContext) {
            this.responseContext = responseContext;
            return this;
        }

        @Override
        public GetTablePermissionBoundaryResponse build() {
            return new GetTablePermissionBoundaryResponse(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }
}
