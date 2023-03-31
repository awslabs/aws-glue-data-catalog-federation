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
import java.util.Map;
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
import software.amazon.awssdk.core.traits.MapTrait;
import software.amazon.awssdk.core.util.DefaultSdkAutoConstructMap;
import software.amazon.awssdk.core.util.SdkAutoConstructMap;
import software.amazon.awssdk.utils.ToString;
import software.amazon.awssdk.utils.builder.CopyableBuilder;
import software.amazon.awssdk.utils.builder.ToCopyableBuilder;

/**
 */
@Generated("software.amazon.awssdk:codegen")
public final class GetTemporaryTableCredentialsRequest extends GlueCatalogFederationRequest implements
        ToCopyableBuilder<GetTemporaryTableCredentialsRequest.Builder, GetTemporaryTableCredentialsRequest> {
    private static final SdkField<String> TABLE_IDENTIFIER_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("TableIdentifier").getter(getter(GetTemporaryTableCredentialsRequest::tableIdentifier))
            .setter(setter(Builder::tableIdentifier))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("TableIdentifier").build()).build();

    private static final SdkField<String> DATABASE_IDENTIFIER_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("DatabaseIdentifier").getter(getter(GetTemporaryTableCredentialsRequest::databaseIdentifier))
            .setter(setter(Builder::databaseIdentifier))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("DatabaseIdentifier").build())
            .build();

    private static final SdkField<String> DATABASE_NAME_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("DatabaseName").getter(getter(GetTemporaryTableCredentialsRequest::databaseName))
            .setter(setter(Builder::databaseName))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("DatabaseName").build()).build();

    private static final SdkField<String> TABLE_NAME_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("TableName").getter(getter(GetTemporaryTableCredentialsRequest::tableName))
            .setter(setter(Builder::tableName))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("TableName").build()).build();

    private static final SdkField<Actions> ACTIONS_FIELD = SdkField.<Actions> builder(MarshallingType.SDK_POJO)
            .memberName("Actions").getter(getter(GetTemporaryTableCredentialsRequest::actions)).setter(setter(Builder::actions))
            .constructor(Actions::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Actions").build()).build();

    private static final SdkField<Integer> DURATION_SECONDS_FIELD = SdkField.<Integer> builder(MarshallingType.INTEGER)
            .memberName("DurationSeconds").getter(getter(GetTemporaryTableCredentialsRequest::durationSeconds))
            .setter(setter(Builder::durationSeconds))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("DurationSeconds").build()).build();

    private static final SdkField<Map<String, String>> REQUEST_CONTEXT_FIELD = SdkField
            .<Map<String, String>> builder(MarshallingType.MAP)
            .memberName("RequestContext")
            .getter(getter(GetTemporaryTableCredentialsRequest::requestContextAsStrings))
            .setter(setter(Builder::requestContextWithStrings))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("RequestContext").build(),
                    MapTrait.builder()
                            .keyLocationName("key")
                            .valueLocationName("value")
                            .valueFieldInfo(
                                    SdkField.<String> builder(MarshallingType.STRING)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("value").build()).build()).build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(TABLE_IDENTIFIER_FIELD,
            DATABASE_IDENTIFIER_FIELD, DATABASE_NAME_FIELD, TABLE_NAME_FIELD, ACTIONS_FIELD, DURATION_SECONDS_FIELD,
            REQUEST_CONTEXT_FIELD));

    private final String tableIdentifier;

    private final String databaseIdentifier;

    private final String databaseName;

    private final String tableName;

    private final Actions actions;

    private final Integer durationSeconds;

    private final Map<String, String> requestContext;

    private GetTemporaryTableCredentialsRequest(BuilderImpl builder) {
        super(builder);
        this.tableIdentifier = builder.tableIdentifier;
        this.databaseIdentifier = builder.databaseIdentifier;
        this.databaseName = builder.databaseName;
        this.tableName = builder.tableName;
        this.actions = builder.actions;
        this.durationSeconds = builder.durationSeconds;
        this.requestContext = builder.requestContext;
    }

    /**
     * Returns the value of the TableIdentifier property for this object.
     * 
     * @return The value of the TableIdentifier property for this object.
     */
    public final String tableIdentifier() {
        return tableIdentifier;
    }

    /**
     * Returns the value of the DatabaseIdentifier property for this object.
     * 
     * @return The value of the DatabaseIdentifier property for this object.
     */
    public final String databaseIdentifier() {
        return databaseIdentifier;
    }

    /**
     * Returns the value of the DatabaseName property for this object.
     * 
     * @return The value of the DatabaseName property for this object.
     */
    public final String databaseName() {
        return databaseName;
    }

    /**
     * Returns the value of the TableName property for this object.
     * 
     * @return The value of the TableName property for this object.
     */
    public final String tableName() {
        return tableName;
    }

    /**
     * Returns the value of the Actions property for this object.
     * 
     * @return The value of the Actions property for this object.
     */
    public final Actions actions() {
        return actions;
    }

    /**
     * Returns the value of the DurationSeconds property for this object.
     * 
     * @return The value of the DurationSeconds property for this object.
     */
    public final Integer durationSeconds() {
        return durationSeconds;
    }

    /**
     * Returns the value of the RequestContext property for this object.
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasRequestContext} method.
     * </p>
     * 
     * @return The value of the RequestContext property for this object.
     */
    public final Map<RequestContextKey, String> requestContext() {
        return RequestContextMapCopier.copyStringToEnum(requestContext);
    }

    /**
     * For responses, this returns true if the service returned a value for the RequestContext property. This DOES NOT
     * check that the value is non-empty (for which, you should check the {@code isEmpty()} method on the property).
     * This is useful because the SDK will never return a null collection or map, but you may need to differentiate
     * between the service returning nothing (or null) and the service returning an empty collection or map. For
     * requests, this returns true if a value for the property was specified in the request builder, and false if a
     * value was not specified.
     */
    public final boolean hasRequestContext() {
        return requestContext != null && !(requestContext instanceof SdkAutoConstructMap);
    }

    /**
     * Returns the value of the RequestContext property for this object.
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasRequestContext} method.
     * </p>
     * 
     * @return The value of the RequestContext property for this object.
     */
    public final Map<String, String> requestContextAsStrings() {
        return requestContext;
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
        hashCode = 31 * hashCode + Objects.hashCode(tableIdentifier());
        hashCode = 31 * hashCode + Objects.hashCode(databaseIdentifier());
        hashCode = 31 * hashCode + Objects.hashCode(databaseName());
        hashCode = 31 * hashCode + Objects.hashCode(tableName());
        hashCode = 31 * hashCode + Objects.hashCode(actions());
        hashCode = 31 * hashCode + Objects.hashCode(durationSeconds());
        hashCode = 31 * hashCode + Objects.hashCode(hasRequestContext() ? requestContextAsStrings() : null);
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
        if (!(obj instanceof GetTemporaryTableCredentialsRequest)) {
            return false;
        }
        GetTemporaryTableCredentialsRequest other = (GetTemporaryTableCredentialsRequest) obj;
        return Objects.equals(tableIdentifier(), other.tableIdentifier())
                && Objects.equals(databaseIdentifier(), other.databaseIdentifier())
                && Objects.equals(databaseName(), other.databaseName()) && Objects.equals(tableName(), other.tableName())
                && Objects.equals(actions(), other.actions()) && Objects.equals(durationSeconds(), other.durationSeconds())
                && hasRequestContext() == other.hasRequestContext()
                && Objects.equals(requestContextAsStrings(), other.requestContextAsStrings());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("GetTemporaryTableCredentialsRequest").add("TableIdentifier", tableIdentifier())
                .add("DatabaseIdentifier", databaseIdentifier()).add("DatabaseName", databaseName())
                .add("TableName", tableName()).add("Actions", actions()).add("DurationSeconds", durationSeconds())
                .add("RequestContext", hasRequestContext() ? requestContextAsStrings() : null).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "TableIdentifier":
            return Optional.ofNullable(clazz.cast(tableIdentifier()));
        case "DatabaseIdentifier":
            return Optional.ofNullable(clazz.cast(databaseIdentifier()));
        case "DatabaseName":
            return Optional.ofNullable(clazz.cast(databaseName()));
        case "TableName":
            return Optional.ofNullable(clazz.cast(tableName()));
        case "Actions":
            return Optional.ofNullable(clazz.cast(actions()));
        case "DurationSeconds":
            return Optional.ofNullable(clazz.cast(durationSeconds()));
        case "RequestContext":
            return Optional.ofNullable(clazz.cast(requestContextAsStrings()));
        default:
            return Optional.empty();
        }
    }

    @Override
    public final List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    private static <T> Function<Object, T> getter(Function<GetTemporaryTableCredentialsRequest, T> g) {
        return obj -> g.apply((GetTemporaryTableCredentialsRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    public interface Builder extends GlueCatalogFederationRequest.Builder, SdkPojo,
            CopyableBuilder<Builder, GetTemporaryTableCredentialsRequest> {
        /**
         * Sets the value of the TableIdentifier property for this object.
         *
         * @param tableIdentifier
         *        The new value for the TableIdentifier property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder tableIdentifier(String tableIdentifier);

        /**
         * Sets the value of the DatabaseIdentifier property for this object.
         *
         * @param databaseIdentifier
         *        The new value for the DatabaseIdentifier property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder databaseIdentifier(String databaseIdentifier);

        /**
         * Sets the value of the DatabaseName property for this object.
         *
         * @param databaseName
         *        The new value for the DatabaseName property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder databaseName(String databaseName);

        /**
         * Sets the value of the TableName property for this object.
         *
         * @param tableName
         *        The new value for the TableName property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder tableName(String tableName);

        /**
         * Sets the value of the Actions property for this object.
         *
         * @param actions
         *        The new value for the Actions property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder actions(Actions actions);

        /**
         * Sets the value of the Actions property for this object.
         *
         * This is a convenience that creates an instance of the {@link Actions.Builder} avoiding the need to create one
         * manually via {@link Actions#builder()}.
         *
         * When the {@link Consumer} completes, {@link Actions.Builder#build()} is called immediately and its result is
         * passed to {@link #actions(Actions)}.
         * 
         * @param actions
         *        a consumer that will call methods on {@link Actions.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #actions(Actions)
         */
        default Builder actions(Consumer<Actions.Builder> actions) {
            return actions(Actions.builder().applyMutation(actions).build());
        }

        /**
         * Sets the value of the DurationSeconds property for this object.
         *
         * @param durationSeconds
         *        The new value for the DurationSeconds property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder durationSeconds(Integer durationSeconds);

        /**
         * Sets the value of the RequestContext property for this object.
         *
         * @param requestContext
         *        The new value for the RequestContext property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder requestContextWithStrings(Map<String, String> requestContext);

        /**
         * Sets the value of the RequestContext property for this object.
         *
         * @param requestContext
         *        The new value for the RequestContext property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder requestContext(Map<RequestContextKey, String> requestContext);

        @Override
        Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration);

        @Override
        Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer);
    }

    static final class BuilderImpl extends GlueCatalogFederationRequest.BuilderImpl implements Builder {
        private String tableIdentifier;

        private String databaseIdentifier;

        private String databaseName;

        private String tableName;

        private Actions actions;

        private Integer durationSeconds;

        private Map<String, String> requestContext = DefaultSdkAutoConstructMap.getInstance();

        private BuilderImpl() {
        }

        private BuilderImpl(GetTemporaryTableCredentialsRequest model) {
            super(model);
            tableIdentifier(model.tableIdentifier);
            databaseIdentifier(model.databaseIdentifier);
            databaseName(model.databaseName);
            tableName(model.tableName);
            actions(model.actions);
            durationSeconds(model.durationSeconds);
            requestContextWithStrings(model.requestContext);
        }

        public final String getTableIdentifier() {
            return tableIdentifier;
        }

        public final void setTableIdentifier(String tableIdentifier) {
            this.tableIdentifier = tableIdentifier;
        }

        @Override
        @Transient
        public final Builder tableIdentifier(String tableIdentifier) {
            this.tableIdentifier = tableIdentifier;
            return this;
        }

        public final String getDatabaseIdentifier() {
            return databaseIdentifier;
        }

        public final void setDatabaseIdentifier(String databaseIdentifier) {
            this.databaseIdentifier = databaseIdentifier;
        }

        @Override
        @Transient
        public final Builder databaseIdentifier(String databaseIdentifier) {
            this.databaseIdentifier = databaseIdentifier;
            return this;
        }

        public final String getDatabaseName() {
            return databaseName;
        }

        public final void setDatabaseName(String databaseName) {
            this.databaseName = databaseName;
        }

        @Override
        @Transient
        public final Builder databaseName(String databaseName) {
            this.databaseName = databaseName;
            return this;
        }

        public final String getTableName() {
            return tableName;
        }

        public final void setTableName(String tableName) {
            this.tableName = tableName;
        }

        @Override
        @Transient
        public final Builder tableName(String tableName) {
            this.tableName = tableName;
            return this;
        }

        public final Actions.Builder getActions() {
            return actions != null ? actions.toBuilder() : null;
        }

        public final void setActions(Actions.BuilderImpl actions) {
            this.actions = actions != null ? actions.build() : null;
        }

        @Override
        @Transient
        public final Builder actions(Actions actions) {
            this.actions = actions;
            return this;
        }

        public final Integer getDurationSeconds() {
            return durationSeconds;
        }

        public final void setDurationSeconds(Integer durationSeconds) {
            this.durationSeconds = durationSeconds;
        }

        @Override
        @Transient
        public final Builder durationSeconds(Integer durationSeconds) {
            this.durationSeconds = durationSeconds;
            return this;
        }

        public final Map<String, String> getRequestContext() {
            if (requestContext instanceof SdkAutoConstructMap) {
                return null;
            }
            return requestContext;
        }

        public final void setRequestContext(Map<String, String> requestContext) {
            this.requestContext = RequestContextMapCopier.copy(requestContext);
        }

        @Override
        @Transient
        public final Builder requestContextWithStrings(Map<String, String> requestContext) {
            this.requestContext = RequestContextMapCopier.copy(requestContext);
            return this;
        }

        @Override
        @Transient
        public final Builder requestContext(Map<RequestContextKey, String> requestContext) {
            this.requestContext = RequestContextMapCopier.copyEnumToString(requestContext);
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
        public GetTemporaryTableCredentialsRequest build() {
            return new GetTemporaryTableCredentialsRequest(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }
}
