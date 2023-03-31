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
public final class GetGroupsForUserRequest extends GlueCatalogFederationRequest implements
        ToCopyableBuilder<GetGroupsForUserRequest.Builder, GetGroupsForUserRequest> {
    private static final SdkField<String> USER_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("User")
            .getter(getter(GetGroupsForUserRequest::user)).setter(setter(Builder::user))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("User").build()).build();

    private static final SdkField<String> NEXT_TOKEN_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("NextToken").getter(getter(GetGroupsForUserRequest::nextToken)).setter(setter(Builder::nextToken))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("NextToken").build()).build();

    private static final SdkField<Integer> MAX_RESULTS_FIELD = SdkField.<Integer> builder(MarshallingType.INTEGER)
            .memberName("MaxResults").getter(getter(GetGroupsForUserRequest::maxResults)).setter(setter(Builder::maxResults))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("MaxResults").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(USER_FIELD, NEXT_TOKEN_FIELD,
            MAX_RESULTS_FIELD));

    private final String user;

    private final String nextToken;

    private final Integer maxResults;

    private GetGroupsForUserRequest(BuilderImpl builder) {
        super(builder);
        this.user = builder.user;
        this.nextToken = builder.nextToken;
        this.maxResults = builder.maxResults;
    }

    /**
     * Returns the value of the User property for this object.
     * 
     * @return The value of the User property for this object.
     */
    public final String user() {
        return user;
    }

    /**
     * Returns the value of the NextToken property for this object.
     * 
     * @return The value of the NextToken property for this object.
     */
    public final String nextToken() {
        return nextToken;
    }

    /**
     * Returns the value of the MaxResults property for this object.
     * 
     * @return The value of the MaxResults property for this object.
     */
    public final Integer maxResults() {
        return maxResults;
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
        hashCode = 31 * hashCode + Objects.hashCode(user());
        hashCode = 31 * hashCode + Objects.hashCode(nextToken());
        hashCode = 31 * hashCode + Objects.hashCode(maxResults());
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
        if (!(obj instanceof GetGroupsForUserRequest)) {
            return false;
        }
        GetGroupsForUserRequest other = (GetGroupsForUserRequest) obj;
        return Objects.equals(user(), other.user()) && Objects.equals(nextToken(), other.nextToken())
                && Objects.equals(maxResults(), other.maxResults());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("GetGroupsForUserRequest").add("User", user()).add("NextToken", nextToken())
                .add("MaxResults", maxResults()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "User":
            return Optional.ofNullable(clazz.cast(user()));
        case "NextToken":
            return Optional.ofNullable(clazz.cast(nextToken()));
        case "MaxResults":
            return Optional.ofNullable(clazz.cast(maxResults()));
        default:
            return Optional.empty();
        }
    }

    @Override
    public final List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    private static <T> Function<Object, T> getter(Function<GetGroupsForUserRequest, T> g) {
        return obj -> g.apply((GetGroupsForUserRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    public interface Builder extends GlueCatalogFederationRequest.Builder, SdkPojo,
            CopyableBuilder<Builder, GetGroupsForUserRequest> {
        /**
         * Sets the value of the User property for this object.
         *
         * @param user
         *        The new value for the User property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder user(String user);

        /**
         * Sets the value of the NextToken property for this object.
         *
         * @param nextToken
         *        The new value for the NextToken property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder nextToken(String nextToken);

        /**
         * Sets the value of the MaxResults property for this object.
         *
         * @param maxResults
         *        The new value for the MaxResults property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder maxResults(Integer maxResults);

        @Override
        Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration);

        @Override
        Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer);
    }

    static final class BuilderImpl extends GlueCatalogFederationRequest.BuilderImpl implements Builder {
        private String user;

        private String nextToken;

        private Integer maxResults;

        private BuilderImpl() {
        }

        private BuilderImpl(GetGroupsForUserRequest model) {
            super(model);
            user(model.user);
            nextToken(model.nextToken);
            maxResults(model.maxResults);
        }

        public final String getUser() {
            return user;
        }

        public final void setUser(String user) {
            this.user = user;
        }

        @Override
        @Transient
        public final Builder user(String user) {
            this.user = user;
            return this;
        }

        public final String getNextToken() {
            return nextToken;
        }

        public final void setNextToken(String nextToken) {
            this.nextToken = nextToken;
        }

        @Override
        @Transient
        public final Builder nextToken(String nextToken) {
            this.nextToken = nextToken;
            return this;
        }

        public final Integer getMaxResults() {
            return maxResults;
        }

        public final void setMaxResults(Integer maxResults) {
            this.maxResults = maxResults;
        }

        @Override
        @Transient
        public final Builder maxResults(Integer maxResults) {
            this.maxResults = maxResults;
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
        public GetGroupsForUserRequest build() {
            return new GetGroupsForUserRequest(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }
}
