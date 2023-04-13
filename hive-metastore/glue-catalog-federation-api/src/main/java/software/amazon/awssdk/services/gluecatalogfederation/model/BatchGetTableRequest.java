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
public final class BatchGetTableRequest extends GlueCatalogFederationRequest implements
        ToCopyableBuilder<BatchGetTableRequest.Builder, BatchGetTableRequest> {
    private static final SdkField<String> AS_OF_ACCOUNT_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("AsOfAccountId").getter(getter(BatchGetTableRequest::asOfAccountId))
            .setter(setter(Builder::asOfAccountId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("AsOfAccountId").build()).build();

    private static final SdkField<List<BatchGetTableEntry>> ENTRIES_FIELD = SdkField
            .<List<BatchGetTableEntry>> builder(MarshallingType.LIST)
            .memberName("Entries")
            .getter(getter(BatchGetTableRequest::entries))
            .setter(setter(Builder::entries))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Entries").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<BatchGetTableEntry> builder(MarshallingType.SDK_POJO)
                                            .constructor(BatchGetTableEntry::builder)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").build()).build()).build()).build();

    private static final SdkField<CallerIdentity> CALLER_IDENTITY_FIELD = SdkField
            .<CallerIdentity> builder(MarshallingType.SDK_POJO).memberName("CallerIdentity")
            .getter(getter(BatchGetTableRequest::callerIdentity)).setter(setter(Builder::callerIdentity))
            .constructor(CallerIdentity::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("CallerIdentity").build()).build();

    private static final SdkField<Map<String, String>> REQUEST_CONTEXT_FIELD = SdkField
            .<Map<String, String>> builder(MarshallingType.MAP)
            .memberName("RequestContext")
            .getter(getter(BatchGetTableRequest::requestContext))
            .setter(setter(Builder::requestContext))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("RequestContext").build(),
                    MapTrait.builder()
                            .keyLocationName("key")
                            .valueLocationName("value")
                            .valueFieldInfo(
                                    SdkField.<String> builder(MarshallingType.STRING)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("value").build()).build()).build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(AS_OF_ACCOUNT_ID_FIELD,
            ENTRIES_FIELD, CALLER_IDENTITY_FIELD, REQUEST_CONTEXT_FIELD));

    private final String asOfAccountId;

    private final List<BatchGetTableEntry> entries;

    private final CallerIdentity callerIdentity;

    private final Map<String, String> requestContext;

    private BatchGetTableRequest(BuilderImpl builder) {
        super(builder);
        this.asOfAccountId = builder.asOfAccountId;
        this.entries = builder.entries;
        this.callerIdentity = builder.callerIdentity;
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
    public final List<BatchGetTableEntry> entries() {
        return entries;
    }

    /**
     * Returns the value of the CallerIdentity property for this object.
     * 
     * @return The value of the CallerIdentity property for this object.
     */
    public final CallerIdentity callerIdentity() {
        return callerIdentity;
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
    public final Map<String, String> requestContext() {
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
        hashCode = 31 * hashCode + Objects.hashCode(hasEntries() ? entries() : null);
        hashCode = 31 * hashCode + Objects.hashCode(callerIdentity());
        hashCode = 31 * hashCode + Objects.hashCode(hasRequestContext() ? requestContext() : null);
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
        if (!(obj instanceof BatchGetTableRequest)) {
            return false;
        }
        BatchGetTableRequest other = (BatchGetTableRequest) obj;
        return Objects.equals(asOfAccountId(), other.asOfAccountId()) && hasEntries() == other.hasEntries()
                && Objects.equals(entries(), other.entries()) && Objects.equals(callerIdentity(), other.callerIdentity())
                && hasRequestContext() == other.hasRequestContext() && Objects.equals(requestContext(), other.requestContext());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("BatchGetTableRequest").add("AsOfAccountId", asOfAccountId())
                .add("Entries", hasEntries() ? entries() : null).add("CallerIdentity", callerIdentity())
                .add("RequestContext", hasRequestContext() ? requestContext() : null).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
            case "AsOfAccountId":
                return Optional.ofNullable(clazz.cast(asOfAccountId()));
            case "Entries":
                return Optional.ofNullable(clazz.cast(entries()));
            case "CallerIdentity":
                return Optional.ofNullable(clazz.cast(callerIdentity()));
            case "RequestContext":
                return Optional.ofNullable(clazz.cast(requestContext()));
            default:
                return Optional.empty();
        }
    }

    @Override
    public final List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    private static <T> Function<Object, T> getter(Function<BatchGetTableRequest, T> g) {
        return obj -> g.apply((BatchGetTableRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    public interface Builder extends GlueCatalogFederationRequest.Builder, SdkPojo,
            CopyableBuilder<Builder, BatchGetTableRequest> {
        /**
         * Sets the value of the AsOfAccountId property for this object.
         *
         * @param asOfAccountId
         *        The new value for the AsOfAccountId property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder asOfAccountId(String asOfAccountId);

        /**
         * Sets the value of the Entries property for this object.
         *
         * @param entries
         *        The new value for the Entries property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder entries(Collection<BatchGetTableEntry> entries);

        /**
         * Sets the value of the Entries property for this object.
         *
         * @param entries
         *        The new value for the Entries property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder entries(BatchGetTableEntry... entries);

        /**
         * Sets the value of the Entries property for this object.
         *
         * This is a convenience method that creates an instance of the
         * {@link software.amazon.awssdk.services.gluecatalogfederation.model.BatchGetTableEntry.Builder} avoiding the
         * need to create one manually via
         * {@link software.amazon.awssdk.services.gluecatalogfederation.model.BatchGetTableEntry#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes,
         * {@link software.amazon.awssdk.services.gluecatalogfederation.model.BatchGetTableEntry.Builder#build()} is
         * called immediately and its result is passed to {@link #entries(List<BatchGetTableEntry>)}.
         *
         * @param entries
         *        a consumer that will call methods on
         *        {@link software.amazon.awssdk.services.gluecatalogfederation.model.BatchGetTableEntry.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #entries(java.util.Collection<BatchGetTableEntry>)
         */
        Builder entries(Consumer<BatchGetTableEntry.Builder>... entries);

        /**
         * Sets the value of the CallerIdentity property for this object.
         *
         * @param callerIdentity
         *        The new value for the CallerIdentity property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder callerIdentity(CallerIdentity callerIdentity);

        /**
         * Sets the value of the CallerIdentity property for this object.
         *
         * This is a convenience method that creates an instance of the {@link CallerIdentity.Builder} avoiding the need
         * to create one manually via {@link CallerIdentity#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link CallerIdentity.Builder#build()} is called immediately and its
         * result is passed to {@link #callerIdentity(CallerIdentity)}.
         * 
         * @param callerIdentity
         *        a consumer that will call methods on {@link CallerIdentity.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #callerIdentity(CallerIdentity)
         */
        default Builder callerIdentity(Consumer<CallerIdentity.Builder> callerIdentity) {
            return callerIdentity(CallerIdentity.builder().applyMutation(callerIdentity).build());
        }

        /**
         * Sets the value of the RequestContext property for this object.
         *
         * @param requestContext
         *        The new value for the RequestContext property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder requestContext(Map<String, String> requestContext);

        @Override
        Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration);

        @Override
        Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer);
    }

    static final class BuilderImpl extends GlueCatalogFederationRequest.BuilderImpl implements Builder {
        private String asOfAccountId;

        private List<BatchGetTableEntry> entries = DefaultSdkAutoConstructList.getInstance();

        private CallerIdentity callerIdentity;

        private Map<String, String> requestContext = DefaultSdkAutoConstructMap.getInstance();

        private BuilderImpl() {
        }

        private BuilderImpl(BatchGetTableRequest model) {
            super(model);
            asOfAccountId(model.asOfAccountId);
            entries(model.entries);
            callerIdentity(model.callerIdentity);
            requestContext(model.requestContext);
        }

        public final String getAsOfAccountId() {
            return asOfAccountId;
        }

        public final void setAsOfAccountId(String asOfAccountId) {
            this.asOfAccountId = asOfAccountId;
        }

        @Override
        public final Builder asOfAccountId(String asOfAccountId) {
            this.asOfAccountId = asOfAccountId;
            return this;
        }

        public final List<BatchGetTableEntry.Builder> getEntries() {
            List<BatchGetTableEntry.Builder> result = BatchGetTableRequestEntryListCopier.copyToBuilder(this.entries);
            if (result instanceof SdkAutoConstructList) {
                return null;
            }
            return result;
        }

        public final void setEntries(Collection<BatchGetTableEntry.BuilderImpl> entries) {
            this.entries = BatchGetTableRequestEntryListCopier.copyFromBuilder(entries);
        }

        @Override
        public final Builder entries(Collection<BatchGetTableEntry> entries) {
            this.entries = BatchGetTableRequestEntryListCopier.copy(entries);
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder entries(BatchGetTableEntry... entries) {
            entries(Arrays.asList(entries));
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder entries(Consumer<BatchGetTableEntry.Builder>... entries) {
            entries(Stream.of(entries).map(c -> BatchGetTableEntry.builder().applyMutation(c).build())
                    .collect(Collectors.toList()));
            return this;
        }

        public final CallerIdentity.Builder getCallerIdentity() {
            return callerIdentity != null ? callerIdentity.toBuilder() : null;
        }

        public final void setCallerIdentity(CallerIdentity.BuilderImpl callerIdentity) {
            this.callerIdentity = callerIdentity != null ? callerIdentity.build() : null;
        }

        @Override
        public final Builder callerIdentity(CallerIdentity callerIdentity) {
            this.callerIdentity = callerIdentity;
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
        public final Builder requestContext(Map<String, String> requestContext) {
            this.requestContext = RequestContextMapCopier.copy(requestContext);
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
        public BatchGetTableRequest build() {
            return new BatchGetTableRequest(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }
}
