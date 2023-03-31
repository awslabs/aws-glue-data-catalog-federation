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
import java.time.Instant;
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
public final class GetTemporaryTableCredentialsResponse extends GlueCatalogFederationResponse implements
        ToCopyableBuilder<GetTemporaryTableCredentialsResponse.Builder, GetTemporaryTableCredentialsResponse> {
    private static final SdkField<String> ACCESS_KEY_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("AccessKeyId").getter(getter(GetTemporaryTableCredentialsResponse::accessKeyId))
            .setter(setter(Builder::accessKeyId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("AccessKeyId").build()).build();

    private static final SdkField<String> SECRET_ACCESS_KEY_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("SecretAccessKey").getter(getter(GetTemporaryTableCredentialsResponse::secretAccessKey))
            .setter(setter(Builder::secretAccessKey))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("SecretAccessKey").build()).build();

    private static final SdkField<String> SESSION_TOKEN_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("SessionToken").getter(getter(GetTemporaryTableCredentialsResponse::sessionToken))
            .setter(setter(Builder::sessionToken))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("SessionToken").build()).build();

    private static final SdkField<Instant> EXPIRATION_FIELD = SdkField.<Instant> builder(MarshallingType.INSTANT)
            .memberName("Expiration").getter(getter(GetTemporaryTableCredentialsResponse::expiration))
            .setter(setter(Builder::expiration))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Expiration").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(ACCESS_KEY_ID_FIELD,
            SECRET_ACCESS_KEY_FIELD, SESSION_TOKEN_FIELD, EXPIRATION_FIELD));

    private final String accessKeyId;

    private final String secretAccessKey;

    private final String sessionToken;

    private final Instant expiration;

    private GetTemporaryTableCredentialsResponse(BuilderImpl builder) {
        super(builder);
        this.accessKeyId = builder.accessKeyId;
        this.secretAccessKey = builder.secretAccessKey;
        this.sessionToken = builder.sessionToken;
        this.expiration = builder.expiration;
    }

    /**
     * Returns the value of the AccessKeyId property for this object.
     * 
     * @return The value of the AccessKeyId property for this object.
     */
    public final String accessKeyId() {
        return accessKeyId;
    }

    /**
     * Returns the value of the SecretAccessKey property for this object.
     * 
     * @return The value of the SecretAccessKey property for this object.
     */
    public final String secretAccessKey() {
        return secretAccessKey;
    }

    /**
     * Returns the value of the SessionToken property for this object.
     * 
     * @return The value of the SessionToken property for this object.
     */
    public final String sessionToken() {
        return sessionToken;
    }

    /**
     * Returns the value of the Expiration property for this object.
     * 
     * @return The value of the Expiration property for this object.
     */
    public final Instant expiration() {
        return expiration;
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
        hashCode = 31 * hashCode + Objects.hashCode(accessKeyId());
        hashCode = 31 * hashCode + Objects.hashCode(secretAccessKey());
        hashCode = 31 * hashCode + Objects.hashCode(sessionToken());
        hashCode = 31 * hashCode + Objects.hashCode(expiration());
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
        if (!(obj instanceof GetTemporaryTableCredentialsResponse)) {
            return false;
        }
        GetTemporaryTableCredentialsResponse other = (GetTemporaryTableCredentialsResponse) obj;
        return Objects.equals(accessKeyId(), other.accessKeyId()) && Objects.equals(secretAccessKey(), other.secretAccessKey())
                && Objects.equals(sessionToken(), other.sessionToken()) && Objects.equals(expiration(), other.expiration());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("GetTemporaryTableCredentialsResponse")
                .add("AccessKeyId", accessKeyId() == null ? null : "*** Sensitive Data Redacted ***")
                .add("SecretAccessKey", secretAccessKey() == null ? null : "*** Sensitive Data Redacted ***")
                .add("SessionToken", sessionToken() == null ? null : "*** Sensitive Data Redacted ***")
                .add("Expiration", expiration()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "AccessKeyId":
            return Optional.ofNullable(clazz.cast(accessKeyId()));
        case "SecretAccessKey":
            return Optional.ofNullable(clazz.cast(secretAccessKey()));
        case "SessionToken":
            return Optional.ofNullable(clazz.cast(sessionToken()));
        case "Expiration":
            return Optional.ofNullable(clazz.cast(expiration()));
        default:
            return Optional.empty();
        }
    }

    @Override
    public final List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    private static <T> Function<Object, T> getter(Function<GetTemporaryTableCredentialsResponse, T> g) {
        return obj -> g.apply((GetTemporaryTableCredentialsResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    public interface Builder extends GlueCatalogFederationResponse.Builder, SdkPojo,
            CopyableBuilder<Builder, GetTemporaryTableCredentialsResponse> {
        /**
         * Sets the value of the AccessKeyId property for this object.
         *
         * @param accessKeyId
         *        The new value for the AccessKeyId property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder accessKeyId(String accessKeyId);

        /**
         * Sets the value of the SecretAccessKey property for this object.
         *
         * @param secretAccessKey
         *        The new value for the SecretAccessKey property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder secretAccessKey(String secretAccessKey);

        /**
         * Sets the value of the SessionToken property for this object.
         *
         * @param sessionToken
         *        The new value for the SessionToken property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder sessionToken(String sessionToken);

        /**
         * Sets the value of the Expiration property for this object.
         *
         * @param expiration
         *        The new value for the Expiration property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder expiration(Instant expiration);
    }

    static final class BuilderImpl extends GlueCatalogFederationResponse.BuilderImpl implements Builder {
        private String accessKeyId;

        private String secretAccessKey;

        private String sessionToken;

        private Instant expiration;

        private BuilderImpl() {
        }

        private BuilderImpl(GetTemporaryTableCredentialsResponse model) {
            super(model);
            accessKeyId(model.accessKeyId);
            secretAccessKey(model.secretAccessKey);
            sessionToken(model.sessionToken);
            expiration(model.expiration);
        }

        public final String getAccessKeyId() {
            return accessKeyId;
        }

        public final void setAccessKeyId(String accessKeyId) {
            this.accessKeyId = accessKeyId;
        }

        @Override
        @Transient
        public final Builder accessKeyId(String accessKeyId) {
            this.accessKeyId = accessKeyId;
            return this;
        }

        public final String getSecretAccessKey() {
            return secretAccessKey;
        }

        public final void setSecretAccessKey(String secretAccessKey) {
            this.secretAccessKey = secretAccessKey;
        }

        @Override
        @Transient
        public final Builder secretAccessKey(String secretAccessKey) {
            this.secretAccessKey = secretAccessKey;
            return this;
        }

        public final String getSessionToken() {
            return sessionToken;
        }

        public final void setSessionToken(String sessionToken) {
            this.sessionToken = sessionToken;
        }

        @Override
        @Transient
        public final Builder sessionToken(String sessionToken) {
            this.sessionToken = sessionToken;
            return this;
        }

        public final Instant getExpiration() {
            return expiration;
        }

        public final void setExpiration(Instant expiration) {
            this.expiration = expiration;
        }

        @Override
        @Transient
        public final Builder expiration(Instant expiration) {
            this.expiration = expiration;
            return this;
        }

        @Override
        public GetTemporaryTableCredentialsResponse build() {
            return new GetTemporaryTableCredentialsResponse(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }
}
