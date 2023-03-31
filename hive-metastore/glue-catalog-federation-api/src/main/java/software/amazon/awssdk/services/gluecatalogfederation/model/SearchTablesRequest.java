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
import software.amazon.awssdk.core.util.DefaultSdkAutoConstructList;
import software.amazon.awssdk.core.util.SdkAutoConstructList;
import software.amazon.awssdk.utils.ToString;
import software.amazon.awssdk.utils.builder.CopyableBuilder;
import software.amazon.awssdk.utils.builder.ToCopyableBuilder;

/**
 */
@Generated("software.amazon.awssdk:codegen")
public final class SearchTablesRequest extends GlueCatalogFederationRequest implements
        ToCopyableBuilder<SearchTablesRequest.Builder, SearchTablesRequest> {
    private static final SdkField<String> AS_OF_ACCOUNT_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("AsOfAccountId").getter(getter(SearchTablesRequest::asOfAccountId))
            .setter(setter(Builder::asOfAccountId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("AsOfAccountId").build()).build();

    private static final SdkField<String> DATABASE_IDENTIFIER_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("DatabaseIdentifier").getter(getter(SearchTablesRequest::databaseIdentifier))
            .setter(setter(Builder::databaseIdentifier))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("DatabaseIdentifier").build())
            .build();

    private static final SdkField<String> DATABASE_NAME_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("DatabaseName").getter(getter(SearchTablesRequest::databaseName)).setter(setter(Builder::databaseName))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("DatabaseName").build()).build();

    private static final SdkField<List<PropertyPredicate>> FILTERS_FIELD = SdkField
            .<List<PropertyPredicate>> builder(MarshallingType.LIST)
            .memberName("Filters")
            .getter(getter(SearchTablesRequest::filters))
            .setter(setter(Builder::filters))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Filters").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<PropertyPredicate> builder(MarshallingType.SDK_POJO)
                                            .constructor(PropertyPredicate::builder)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").build()).build()).build()).build();

    private static final SdkField<String> SEARCH_TEXT_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("SearchText").getter(getter(SearchTablesRequest::searchText)).setter(setter(Builder::searchText))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("SearchText").build()).build();

    private static final SdkField<List<SortCriterion>> SORT_CRITERIA_FIELD = SdkField
            .<List<SortCriterion>> builder(MarshallingType.LIST)
            .memberName("SortCriteria")
            .getter(getter(SearchTablesRequest::sortCriteria))
            .setter(setter(Builder::sortCriteria))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("SortCriteria").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<SortCriterion> builder(MarshallingType.SDK_POJO)
                                            .constructor(SortCriterion::builder)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").build()).build()).build()).build();

    private static final SdkField<String> NEXT_TOKEN_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("NextToken").getter(getter(SearchTablesRequest::nextToken)).setter(setter(Builder::nextToken))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("NextToken").build()).build();

    private static final SdkField<Integer> MAX_RESULTS_FIELD = SdkField.<Integer> builder(MarshallingType.INTEGER)
            .memberName("MaxResults").getter(getter(SearchTablesRequest::maxResults)).setter(setter(Builder::maxResults))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("MaxResults").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(AS_OF_ACCOUNT_ID_FIELD,
            DATABASE_IDENTIFIER_FIELD, DATABASE_NAME_FIELD, FILTERS_FIELD, SEARCH_TEXT_FIELD, SORT_CRITERIA_FIELD,
            NEXT_TOKEN_FIELD, MAX_RESULTS_FIELD));

    private final String asOfAccountId;

    private final String databaseIdentifier;

    private final String databaseName;

    private final List<PropertyPredicate> filters;

    private final String searchText;

    private final List<SortCriterion> sortCriteria;

    private final String nextToken;

    private final Integer maxResults;

    private SearchTablesRequest(BuilderImpl builder) {
        super(builder);
        this.asOfAccountId = builder.asOfAccountId;
        this.databaseIdentifier = builder.databaseIdentifier;
        this.databaseName = builder.databaseName;
        this.filters = builder.filters;
        this.searchText = builder.searchText;
        this.sortCriteria = builder.sortCriteria;
        this.nextToken = builder.nextToken;
        this.maxResults = builder.maxResults;
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
     * Returns the value of the DatabaseName property for this object.
     * 
     * @return The value of the DatabaseName property for this object.
     */
    public final String databaseName() {
        return databaseName;
    }

    /**
     * For responses, this returns true if the service returned a value for the Filters property. This DOES NOT check
     * that the value is non-empty (for which, you should check the {@code isEmpty()} method on the property). This is
     * useful because the SDK will never return a null collection or map, but you may need to differentiate between the
     * service returning nothing (or null) and the service returning an empty collection or map. For requests, this
     * returns true if a value for the property was specified in the request builder, and false if a value was not
     * specified.
     */
    public final boolean hasFilters() {
        return filters != null && !(filters instanceof SdkAutoConstructList);
    }

    /**
     * Returns the value of the Filters property for this object.
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasFilters} method.
     * </p>
     * 
     * @return The value of the Filters property for this object.
     */
    public final List<PropertyPredicate> filters() {
        return filters;
    }

    /**
     * Returns the value of the SearchText property for this object.
     * 
     * @return The value of the SearchText property for this object.
     */
    public final String searchText() {
        return searchText;
    }

    /**
     * For responses, this returns true if the service returned a value for the SortCriteria property. This DOES NOT
     * check that the value is non-empty (for which, you should check the {@code isEmpty()} method on the property).
     * This is useful because the SDK will never return a null collection or map, but you may need to differentiate
     * between the service returning nothing (or null) and the service returning an empty collection or map. For
     * requests, this returns true if a value for the property was specified in the request builder, and false if a
     * value was not specified.
     */
    public final boolean hasSortCriteria() {
        return sortCriteria != null && !(sortCriteria instanceof SdkAutoConstructList);
    }

    /**
     * Returns the value of the SortCriteria property for this object.
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasSortCriteria} method.
     * </p>
     * 
     * @return The value of the SortCriteria property for this object.
     */
    public final List<SortCriterion> sortCriteria() {
        return sortCriteria;
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
        hashCode = 31 * hashCode + Objects.hashCode(asOfAccountId());
        hashCode = 31 * hashCode + Objects.hashCode(databaseIdentifier());
        hashCode = 31 * hashCode + Objects.hashCode(databaseName());
        hashCode = 31 * hashCode + Objects.hashCode(hasFilters() ? filters() : null);
        hashCode = 31 * hashCode + Objects.hashCode(searchText());
        hashCode = 31 * hashCode + Objects.hashCode(hasSortCriteria() ? sortCriteria() : null);
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
        if (!(obj instanceof SearchTablesRequest)) {
            return false;
        }
        SearchTablesRequest other = (SearchTablesRequest) obj;
        return Objects.equals(asOfAccountId(), other.asOfAccountId())
                && Objects.equals(databaseIdentifier(), other.databaseIdentifier())
                && Objects.equals(databaseName(), other.databaseName()) && hasFilters() == other.hasFilters()
                && Objects.equals(filters(), other.filters()) && Objects.equals(searchText(), other.searchText())
                && hasSortCriteria() == other.hasSortCriteria() && Objects.equals(sortCriteria(), other.sortCriteria())
                && Objects.equals(nextToken(), other.nextToken()) && Objects.equals(maxResults(), other.maxResults());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("SearchTablesRequest").add("AsOfAccountId", asOfAccountId())
                .add("DatabaseIdentifier", databaseIdentifier()).add("DatabaseName", databaseName())
                .add("Filters", hasFilters() ? filters() : null).add("SearchText", searchText())
                .add("SortCriteria", hasSortCriteria() ? sortCriteria() : null).add("NextToken", nextToken())
                .add("MaxResults", maxResults()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "AsOfAccountId":
            return Optional.ofNullable(clazz.cast(asOfAccountId()));
        case "DatabaseIdentifier":
            return Optional.ofNullable(clazz.cast(databaseIdentifier()));
        case "DatabaseName":
            return Optional.ofNullable(clazz.cast(databaseName()));
        case "Filters":
            return Optional.ofNullable(clazz.cast(filters()));
        case "SearchText":
            return Optional.ofNullable(clazz.cast(searchText()));
        case "SortCriteria":
            return Optional.ofNullable(clazz.cast(sortCriteria()));
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

    private static <T> Function<Object, T> getter(Function<SearchTablesRequest, T> g) {
        return obj -> g.apply((SearchTablesRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    public interface Builder extends GlueCatalogFederationRequest.Builder, SdkPojo, CopyableBuilder<Builder, SearchTablesRequest> {
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
         * Sets the value of the DatabaseName property for this object.
         *
         * @param databaseName
         *        The new value for the DatabaseName property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder databaseName(String databaseName);

        /**
         * Sets the value of the Filters property for this object.
         *
         * @param filters
         *        The new value for the Filters property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder filters(Collection<PropertyPredicate> filters);

        /**
         * Sets the value of the Filters property for this object.
         *
         * @param filters
         *        The new value for the Filters property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder filters(PropertyPredicate... filters);

        /**
         * Sets the value of the Filters property for this object.
         *
         * This is a convenience that creates an instance of the {@link List<PropertyPredicate>.Builder} avoiding the
         * need to create one manually via {@link List<PropertyPredicate>#builder()}.
         *
         * When the {@link Consumer} completes, {@link List<PropertyPredicate>.Builder#build()} is called immediately
         * and its result is passed to {@link #filters(List<PropertyPredicate>)}.
         * 
         * @param filters
         *        a consumer that will call methods on {@link List<PropertyPredicate>.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #filters(List<PropertyPredicate>)
         */
        Builder filters(Consumer<PropertyPredicate.Builder>... filters);

        /**
         * Sets the value of the SearchText property for this object.
         *
         * @param searchText
         *        The new value for the SearchText property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder searchText(String searchText);

        /**
         * Sets the value of the SortCriteria property for this object.
         *
         * @param sortCriteria
         *        The new value for the SortCriteria property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder sortCriteria(Collection<SortCriterion> sortCriteria);

        /**
         * Sets the value of the SortCriteria property for this object.
         *
         * @param sortCriteria
         *        The new value for the SortCriteria property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder sortCriteria(SortCriterion... sortCriteria);

        /**
         * Sets the value of the SortCriteria property for this object.
         *
         * This is a convenience that creates an instance of the {@link List<SortCriterion>.Builder} avoiding the need
         * to create one manually via {@link List<SortCriterion>#builder()}.
         *
         * When the {@link Consumer} completes, {@link List<SortCriterion>.Builder#build()} is called immediately and
         * its result is passed to {@link #sortCriteria(List<SortCriterion>)}.
         * 
         * @param sortCriteria
         *        a consumer that will call methods on {@link List<SortCriterion>.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #sortCriteria(List<SortCriterion>)
         */
        Builder sortCriteria(Consumer<SortCriterion.Builder>... sortCriteria);

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
        private String asOfAccountId;

        private String databaseIdentifier;

        private String databaseName;

        private List<PropertyPredicate> filters = DefaultSdkAutoConstructList.getInstance();

        private String searchText;

        private List<SortCriterion> sortCriteria = DefaultSdkAutoConstructList.getInstance();

        private String nextToken;

        private Integer maxResults;

        private BuilderImpl() {
        }

        private BuilderImpl(SearchTablesRequest model) {
            super(model);
            asOfAccountId(model.asOfAccountId);
            databaseIdentifier(model.databaseIdentifier);
            databaseName(model.databaseName);
            filters(model.filters);
            searchText(model.searchText);
            sortCriteria(model.sortCriteria);
            nextToken(model.nextToken);
            maxResults(model.maxResults);
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

        public final List<PropertyPredicate.Builder> getFilters() {
            List<PropertyPredicate.Builder> result = SearchPropertyPredicatesCopier.copyToBuilder(this.filters);
            if (result instanceof SdkAutoConstructList) {
                return null;
            }
            return result;
        }

        public final void setFilters(Collection<PropertyPredicate.BuilderImpl> filters) {
            this.filters = SearchPropertyPredicatesCopier.copyFromBuilder(filters);
        }

        @Override
        @Transient
        public final Builder filters(Collection<PropertyPredicate> filters) {
            this.filters = SearchPropertyPredicatesCopier.copy(filters);
            return this;
        }

        @Override
        @Transient
        @SafeVarargs
        public final Builder filters(PropertyPredicate... filters) {
            filters(Arrays.asList(filters));
            return this;
        }

        @Override
        @Transient
        @SafeVarargs
        public final Builder filters(Consumer<PropertyPredicate.Builder>... filters) {
            filters(Stream.of(filters).map(c -> PropertyPredicate.builder().applyMutation(c).build())
                    .collect(Collectors.toList()));
            return this;
        }

        public final String getSearchText() {
            return searchText;
        }

        public final void setSearchText(String searchText) {
            this.searchText = searchText;
        }

        @Override
        @Transient
        public final Builder searchText(String searchText) {
            this.searchText = searchText;
            return this;
        }

        public final List<SortCriterion.Builder> getSortCriteria() {
            List<SortCriterion.Builder> result = SortCriteriaCopier.copyToBuilder(this.sortCriteria);
            if (result instanceof SdkAutoConstructList) {
                return null;
            }
            return result;
        }

        public final void setSortCriteria(Collection<SortCriterion.BuilderImpl> sortCriteria) {
            this.sortCriteria = SortCriteriaCopier.copyFromBuilder(sortCriteria);
        }

        @Override
        @Transient
        public final Builder sortCriteria(Collection<SortCriterion> sortCriteria) {
            this.sortCriteria = SortCriteriaCopier.copy(sortCriteria);
            return this;
        }

        @Override
        @Transient
        @SafeVarargs
        public final Builder sortCriteria(SortCriterion... sortCriteria) {
            sortCriteria(Arrays.asList(sortCriteria));
            return this;
        }

        @Override
        @Transient
        @SafeVarargs
        public final Builder sortCriteria(Consumer<SortCriterion.Builder>... sortCriteria) {
            sortCriteria(Stream.of(sortCriteria).map(c -> SortCriterion.builder().applyMutation(c).build())
                    .collect(Collectors.toList()));
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
        public SearchTablesRequest build() {
            return new SearchTablesRequest(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }
}
