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
import java.util.Collection;
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
import software.amazon.awssdk.core.traits.ListTrait;
import software.amazon.awssdk.core.traits.LocationTrait;
import software.amazon.awssdk.core.traits.MapTrait;
import software.amazon.awssdk.core.util.DefaultSdkAutoConstructList;
import software.amazon.awssdk.core.util.DefaultSdkAutoConstructMap;
import software.amazon.awssdk.core.util.SdkAutoConstructList;
import software.amazon.awssdk.core.util.SdkAutoConstructMap;
import software.amazon.awssdk.utils.ToString;
import software.amazon.awssdk.utils.builder.CopyableBuilder;
import software.amazon.awssdk.utils.builder.ToCopyableBuilder;

/**
 */
@Generated("software.amazon.awssdk:codegen")
public final class GetTablePermissionBoundaryRequest extends GlueCatalogFederationRequest implements
        ToCopyableBuilder<GetTablePermissionBoundaryRequest.Builder, GetTablePermissionBoundaryRequest> {
    private static final SdkField<String> LAKE_FORMATION_PRINCIPAL_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("LakeFormationPrincipal").getter(getter(GetTablePermissionBoundaryRequest::lakeFormationPrincipal))
            .setter(setter(Builder::lakeFormationPrincipal))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("LakeFormationPrincipal").build())
            .build();

    private static final SdkField<String> TABLE_IDENTIFIER_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("TableIdentifier").getter(getter(GetTablePermissionBoundaryRequest::tableIdentifier))
            .setter(setter(Builder::tableIdentifier))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("TableIdentifier").build()).build();

    private static final SdkField<String> TABLE_NAME_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("TableName").getter(getter(GetTablePermissionBoundaryRequest::tableName))
            .setter(setter(Builder::tableName))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("TableName").build()).build();

    private static final SdkField<List<String>> COLUMNS_TO_EVALUATE_FIELD = SdkField
            .<List<String>> builder(MarshallingType.LIST)
            .memberName("ColumnsToEvaluate")
            .getter(getter(GetTablePermissionBoundaryRequest::columnsToEvaluate))
            .setter(setter(Builder::columnsToEvaluate))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("ColumnsToEvaluate").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<String> builder(MarshallingType.STRING)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").build()).build()).build()).build();

    private static final SdkField<Map<String, String>> REQUEST_CONTEXT_FIELD = SdkField
            .<Map<String, String>> builder(MarshallingType.MAP)
            .memberName("RequestContext")
            .getter(getter(GetTablePermissionBoundaryRequest::requestContextAsStrings))
            .setter(setter(Builder::requestContextWithStrings))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("RequestContext").build(),
                    MapTrait.builder()
                            .keyLocationName("key")
                            .valueLocationName("value")
                            .valueFieldInfo(
                                    SdkField.<String> builder(MarshallingType.STRING)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("value").build()).build()).build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(
            LAKE_FORMATION_PRINCIPAL_FIELD, TABLE_IDENTIFIER_FIELD, TABLE_NAME_FIELD, COLUMNS_TO_EVALUATE_FIELD,
            REQUEST_CONTEXT_FIELD));

    private final String lakeFormationPrincipal;

    private final String tableIdentifier;

    private final String tableName;

    private final List<String> columnsToEvaluate;

    private final Map<String, String> requestContext;

    private GetTablePermissionBoundaryRequest(BuilderImpl builder) {
        super(builder);
        this.lakeFormationPrincipal = builder.lakeFormationPrincipal;
        this.tableIdentifier = builder.tableIdentifier;
        this.tableName = builder.tableName;
        this.columnsToEvaluate = builder.columnsToEvaluate;
        this.requestContext = builder.requestContext;
    }

    /**
     * Returns the value of the LakeFormationPrincipal property for this object.
     * 
     * @return The value of the LakeFormationPrincipal property for this object.
     */
    public final String lakeFormationPrincipal() {
        return lakeFormationPrincipal;
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
     * Returns the value of the TableName property for this object.
     * 
     * @return The value of the TableName property for this object.
     */
    public final String tableName() {
        return tableName;
    }

    /**
     * For responses, this returns true if the service returned a value for the ColumnsToEvaluate property. This DOES
     * NOT check that the value is non-empty (for which, you should check the {@code isEmpty()} method on the property).
     * This is useful because the SDK will never return a null collection or map, but you may need to differentiate
     * between the service returning nothing (or null) and the service returning an empty collection or map. For
     * requests, this returns true if a value for the property was specified in the request builder, and false if a
     * value was not specified.
     */
    public final boolean hasColumnsToEvaluate() {
        return columnsToEvaluate != null && !(columnsToEvaluate instanceof SdkAutoConstructList);
    }

    /**
     * Returns the value of the ColumnsToEvaluate property for this object.
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasColumnsToEvaluate} method.
     * </p>
     * 
     * @return The value of the ColumnsToEvaluate property for this object.
     */
    public final List<String> columnsToEvaluate() {
        return columnsToEvaluate;
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
        hashCode = 31 * hashCode + Objects.hashCode(lakeFormationPrincipal());
        hashCode = 31 * hashCode + Objects.hashCode(tableIdentifier());
        hashCode = 31 * hashCode + Objects.hashCode(tableName());
        hashCode = 31 * hashCode + Objects.hashCode(hasColumnsToEvaluate() ? columnsToEvaluate() : null);
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
        if (!(obj instanceof GetTablePermissionBoundaryRequest)) {
            return false;
        }
        GetTablePermissionBoundaryRequest other = (GetTablePermissionBoundaryRequest) obj;
        return Objects.equals(lakeFormationPrincipal(), other.lakeFormationPrincipal())
                && Objects.equals(tableIdentifier(), other.tableIdentifier()) && Objects.equals(tableName(), other.tableName())
                && hasColumnsToEvaluate() == other.hasColumnsToEvaluate()
                && Objects.equals(columnsToEvaluate(), other.columnsToEvaluate())
                && hasRequestContext() == other.hasRequestContext()
                && Objects.equals(requestContextAsStrings(), other.requestContextAsStrings());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("GetTablePermissionBoundaryRequest").add("LakeFormationPrincipal", lakeFormationPrincipal())
                .add("TableIdentifier", tableIdentifier()).add("TableName", tableName())
                .add("ColumnsToEvaluate", hasColumnsToEvaluate() ? columnsToEvaluate() : null)
                .add("RequestContext", hasRequestContext() ? requestContextAsStrings() : null).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "LakeFormationPrincipal":
            return Optional.ofNullable(clazz.cast(lakeFormationPrincipal()));
        case "TableIdentifier":
            return Optional.ofNullable(clazz.cast(tableIdentifier()));
        case "TableName":
            return Optional.ofNullable(clazz.cast(tableName()));
        case "ColumnsToEvaluate":
            return Optional.ofNullable(clazz.cast(columnsToEvaluate()));
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

    private static <T> Function<Object, T> getter(Function<GetTablePermissionBoundaryRequest, T> g) {
        return obj -> g.apply((GetTablePermissionBoundaryRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    public interface Builder extends GlueCatalogFederationRequest.Builder, SdkPojo,
            CopyableBuilder<Builder, GetTablePermissionBoundaryRequest> {
        /**
         * Sets the value of the LakeFormationPrincipal property for this object.
         *
         * @param lakeFormationPrincipal
         *        The new value for the LakeFormationPrincipal property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder lakeFormationPrincipal(String lakeFormationPrincipal);

        /**
         * Sets the value of the TableIdentifier property for this object.
         *
         * @param tableIdentifier
         *        The new value for the TableIdentifier property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder tableIdentifier(String tableIdentifier);

        /**
         * Sets the value of the TableName property for this object.
         *
         * @param tableName
         *        The new value for the TableName property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder tableName(String tableName);

        /**
         * Sets the value of the ColumnsToEvaluate property for this object.
         *
         * @param columnsToEvaluate
         *        The new value for the ColumnsToEvaluate property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder columnsToEvaluate(Collection<String> columnsToEvaluate);

        /**
         * Sets the value of the ColumnsToEvaluate property for this object.
         *
         * @param columnsToEvaluate
         *        The new value for the ColumnsToEvaluate property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder columnsToEvaluate(String... columnsToEvaluate);

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
        private String lakeFormationPrincipal;

        private String tableIdentifier;

        private String tableName;

        private List<String> columnsToEvaluate = DefaultSdkAutoConstructList.getInstance();

        private Map<String, String> requestContext = DefaultSdkAutoConstructMap.getInstance();

        private BuilderImpl() {
        }

        private BuilderImpl(GetTablePermissionBoundaryRequest model) {
            super(model);
            lakeFormationPrincipal(model.lakeFormationPrincipal);
            tableIdentifier(model.tableIdentifier);
            tableName(model.tableName);
            columnsToEvaluate(model.columnsToEvaluate);
            requestContextWithStrings(model.requestContext);
        }

        public final String getLakeFormationPrincipal() {
            return lakeFormationPrincipal;
        }

        public final void setLakeFormationPrincipal(String lakeFormationPrincipal) {
            this.lakeFormationPrincipal = lakeFormationPrincipal;
        }

        @Override
        @Transient
        public final Builder lakeFormationPrincipal(String lakeFormationPrincipal) {
            this.lakeFormationPrincipal = lakeFormationPrincipal;
            return this;
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

        public final Collection<String> getColumnsToEvaluate() {
            if (columnsToEvaluate instanceof SdkAutoConstructList) {
                return null;
            }
            return columnsToEvaluate;
        }

        public final void setColumnsToEvaluate(Collection<String> columnsToEvaluate) {
            this.columnsToEvaluate = ColumnNamesCopier.copy(columnsToEvaluate);
        }

        @Override
        @Transient
        public final Builder columnsToEvaluate(Collection<String> columnsToEvaluate) {
            this.columnsToEvaluate = ColumnNamesCopier.copy(columnsToEvaluate);
            return this;
        }

        @Override
        @Transient
        @SafeVarargs
        public final Builder columnsToEvaluate(String... columnsToEvaluate) {
            columnsToEvaluate(Arrays.asList(columnsToEvaluate));
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
        public GetTablePermissionBoundaryRequest build() {
            return new GetTablePermissionBoundaryRequest(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }
}
