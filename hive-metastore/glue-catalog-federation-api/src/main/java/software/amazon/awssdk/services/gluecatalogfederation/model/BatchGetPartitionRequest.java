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
import java.util.stream.Collectors;
import java.util.stream.Stream;
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
public final class BatchGetPartitionRequest extends GlueCatalogFederationRequest implements
        ToCopyableBuilder<BatchGetPartitionRequest.Builder, BatchGetPartitionRequest> {
    private static final SdkField<String> AS_OF_ACCOUNT_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("AsOfAccountId").getter(getter(BatchGetPartitionRequest::asOfAccountId))
            .setter(setter(Builder::asOfAccountId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("AsOfAccountId").build()).build();

    private static final SdkField<String> DATABASE_IDENTIFIER_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("DatabaseIdentifier").getter(getter(BatchGetPartitionRequest::databaseIdentifier))
            .setter(setter(Builder::databaseIdentifier))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("DatabaseIdentifier").build())
            .build();

    private static final SdkField<String> TABLE_IDENTIFIER_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("TableIdentifier").getter(getter(BatchGetPartitionRequest::tableIdentifier))
            .setter(setter(Builder::tableIdentifier))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("TableIdentifier").build()).build();

    private static final SdkField<String> DATABASE_NAME_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("DatabaseName").getter(getter(BatchGetPartitionRequest::databaseName))
            .setter(setter(Builder::databaseName))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("DatabaseName").build()).build();

    private static final SdkField<String> TABLE_NAME_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("TableName").getter(getter(BatchGetPartitionRequest::tableName)).setter(setter(Builder::tableName))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("TableName").build()).build();

    private static final SdkField<List<PartitionValue>> ENTRIES_FIELD = SdkField
            .<List<PartitionValue>> builder(MarshallingType.LIST)
            .memberName("Entries")
            .getter(getter(BatchGetPartitionRequest::entries))
            .setter(setter(Builder::entries))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Entries").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<PartitionValue> builder(MarshallingType.SDK_POJO)
                                            .constructor(PartitionValue::builder)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").build()).build()).build()).build();

    private static final SdkField<Map<String, String>> REQUEST_CONTEXT_FIELD = SdkField
            .<Map<String, String>> builder(MarshallingType.MAP)
            .memberName("RequestContext")
            .getter(getter(BatchGetPartitionRequest::requestContextAsStrings))
            .setter(setter(Builder::requestContextWithStrings))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("RequestContext").build(),
                    MapTrait.builder()
                            .keyLocationName("key")
                            .valueLocationName("value")
                            .valueFieldInfo(
                                    SdkField.<String> builder(MarshallingType.STRING)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("value").build()).build()).build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(AS_OF_ACCOUNT_ID_FIELD,
            DATABASE_IDENTIFIER_FIELD, TABLE_IDENTIFIER_FIELD, DATABASE_NAME_FIELD, TABLE_NAME_FIELD, ENTRIES_FIELD,
            REQUEST_CONTEXT_FIELD));

    private final String asOfAccountId;

    private final String databaseIdentifier;

    private final String tableIdentifier;

    private final String databaseName;

    private final String tableName;

    private final List<PartitionValue> entries;

    private final Map<String, String> requestContext;

    private BatchGetPartitionRequest(BuilderImpl builder) {
        super(builder);
        this.asOfAccountId = builder.asOfAccountId;
        this.databaseIdentifier = builder.databaseIdentifier;
        this.tableIdentifier = builder.tableIdentifier;
        this.databaseName = builder.databaseName;
        this.tableName = builder.tableName;
        this.entries = builder.entries;
        this.requestContext = builder.requestContext;
    }

    /**
     * Returns the value of the AsOfAccountId property for this object.
     * 
     * @return The value of the AsOfAccountId property for this object.
     */
    public final String asOfAccountId() {
        return asOfAccountId;
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
     * Returns the value of the TableIdentifier property for this object.
     * 
     * @return The value of the TableIdentifier property for this object.
     */
    public final String tableIdentifier() {
        return tableIdentifier;
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
     * For responses, this returns true if the service returned a value for the Entries property. This DOES NOT check
     * that the value is non-empty (for which, you should check the {@code isEmpty()} method on the property). This is
     * useful because the SDK will never return a null collection or map, but you may need to differentiate between the
     * service returning nothing (or null) and the service returning an empty collection or map. For requests, this
     * returns true if a value for the property was specified in the request builder, and false if a value was not
     * specified.
     */
    public final boolean hasEntries() {
        return entries != null && !(entries instanceof SdkAutoConstructList);
    }

    /**
     * Returns the value of the Entries property for this object.
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasEntries} method.
     * </p>
     * 
     * @return The value of the Entries property for this object.
     */
    public final List<PartitionValue> entries() {
        return entries;
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
        hashCode = 31 * hashCode + Objects.hashCode(asOfAccountId());
        hashCode = 31 * hashCode + Objects.hashCode(databaseIdentifier());
        hashCode = 31 * hashCode + Objects.hashCode(tableIdentifier());
        hashCode = 31 * hashCode + Objects.hashCode(databaseName());
        hashCode = 31 * hashCode + Objects.hashCode(tableName());
        hashCode = 31 * hashCode + Objects.hashCode(hasEntries() ? entries() : null);
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
        if (!(obj instanceof BatchGetPartitionRequest)) {
            return false;
        }
        BatchGetPartitionRequest other = (BatchGetPartitionRequest) obj;
        return Objects.equals(asOfAccountId(), other.asOfAccountId())
                && Objects.equals(databaseIdentifier(), other.databaseIdentifier())
                && Objects.equals(tableIdentifier(), other.tableIdentifier())
                && Objects.equals(databaseName(), other.databaseName()) && Objects.equals(tableName(), other.tableName())
                && hasEntries() == other.hasEntries() && Objects.equals(entries(), other.entries())
                && hasRequestContext() == other.hasRequestContext()
                && Objects.equals(requestContextAsStrings(), other.requestContextAsStrings());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("BatchGetPartitionRequest").add("AsOfAccountId", asOfAccountId())
                .add("DatabaseIdentifier", databaseIdentifier()).add("TableIdentifier", tableIdentifier())
                .add("DatabaseName", databaseName()).add("TableName", tableName())
                .add("Entries", hasEntries() ? entries() : null)
                .add("RequestContext", hasRequestContext() ? requestContextAsStrings() : null).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "AsOfAccountId":
            return Optional.ofNullable(clazz.cast(asOfAccountId()));
        case "DatabaseIdentifier":
            return Optional.ofNullable(clazz.cast(databaseIdentifier()));
        case "TableIdentifier":
            return Optional.ofNullable(clazz.cast(tableIdentifier()));
        case "DatabaseName":
            return Optional.ofNullable(clazz.cast(databaseName()));
        case "TableName":
            return Optional.ofNullable(clazz.cast(tableName()));
        case "Entries":
            return Optional.ofNullable(clazz.cast(entries()));
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

    private static <T> Function<Object, T> getter(Function<BatchGetPartitionRequest, T> g) {
        return obj -> g.apply((BatchGetPartitionRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    public interface Builder extends GlueCatalogFederationRequest.Builder, SdkPojo,
            CopyableBuilder<Builder, BatchGetPartitionRequest> {
        /**
         * Sets the value of the AsOfAccountId property for this object.
         *
         * @param asOfAccountId
         *        The new value for the AsOfAccountId property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder asOfAccountId(String asOfAccountId);

        /**
         * Sets the value of the DatabaseIdentifier property for this object.
         *
         * @param databaseIdentifier
         *        The new value for the DatabaseIdentifier property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder databaseIdentifier(String databaseIdentifier);

        /**
         * Sets the value of the TableIdentifier property for this object.
         *
         * @param tableIdentifier
         *        The new value for the TableIdentifier property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder tableIdentifier(String tableIdentifier);

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
         * Sets the value of the Entries property for this object.
         *
         * @param entries
         *        The new value for the Entries property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder entries(Collection<PartitionValue> entries);

        /**
         * Sets the value of the Entries property for this object.
         *
         * @param entries
         *        The new value for the Entries property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder entries(PartitionValue... entries);

        /**
         * Sets the value of the Entries property for this object.
         *
         * This is a convenience that creates an instance of the {@link List<PartitionValue>.Builder} avoiding the need
         * to create one manually via {@link List<PartitionValue>#builder()}.
         *
         * When the {@link Consumer} completes, {@link List<PartitionValue>.Builder#build()} is called immediately and
         * its result is passed to {@link #entries(List<PartitionValue>)}.
         * 
         * @param entries
         *        a consumer that will call methods on {@link List<PartitionValue>.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #entries(List<PartitionValue>)
         */
        Builder entries(Consumer<PartitionValue.Builder>... entries);

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
        private String asOfAccountId;

        private String databaseIdentifier;

        private String tableIdentifier;

        private String databaseName;

        private String tableName;

        private List<PartitionValue> entries = DefaultSdkAutoConstructList.getInstance();

        private Map<String, String> requestContext = DefaultSdkAutoConstructMap.getInstance();

        private BuilderImpl() {
        }

        private BuilderImpl(BatchGetPartitionRequest model) {
            super(model);
            asOfAccountId(model.asOfAccountId);
            databaseIdentifier(model.databaseIdentifier);
            tableIdentifier(model.tableIdentifier);
            databaseName(model.databaseName);
            tableName(model.tableName);
            entries(model.entries);
            requestContextWithStrings(model.requestContext);
        }

        public final String getAsOfAccountId() {
            return asOfAccountId;
        }

        public final void setAsOfAccountId(String asOfAccountId) {
            this.asOfAccountId = asOfAccountId;
        }

        @Override
        @Transient
        public final Builder asOfAccountId(String asOfAccountId) {
            this.asOfAccountId = asOfAccountId;
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

        public final List<PartitionValue.Builder> getEntries() {
            List<PartitionValue.Builder> result = BatchGetPartitionRequestEntryListCopier.copyToBuilder(this.entries);
            if (result instanceof SdkAutoConstructList) {
                return null;
            }
            return result;
        }

        public final void setEntries(Collection<PartitionValue.BuilderImpl> entries) {
            this.entries = BatchGetPartitionRequestEntryListCopier.copyFromBuilder(entries);
        }

        @Override
        @Transient
        public final Builder entries(Collection<PartitionValue> entries) {
            this.entries = BatchGetPartitionRequestEntryListCopier.copy(entries);
            return this;
        }

        @Override
        @Transient
        @SafeVarargs
        public final Builder entries(PartitionValue... entries) {
            entries(Arrays.asList(entries));
            return this;
        }

        @Override
        @Transient
        @SafeVarargs
        public final Builder entries(Consumer<PartitionValue.Builder>... entries) {
            entries(Stream.of(entries).map(c -> PartitionValue.builder().applyMutation(c).build()).collect(Collectors.toList()));
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
        public BatchGetPartitionRequest build() {
            return new BatchGetPartitionRequest(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }
}
