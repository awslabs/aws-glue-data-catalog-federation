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
import java.io.Serializable;
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
public final class PermissionBoundary implements SdkPojo, Serializable,
        ToCopyableBuilder<PermissionBoundary.Builder, PermissionBoundary> {
    private static final SdkField<List<String>> AUTHORIZED_COLUMNS_FIELD = SdkField
            .<List<String>> builder(MarshallingType.LIST)
            .memberName("AuthorizedColumns")
            .getter(getter(PermissionBoundary::authorizedColumns))
            .setter(setter(Builder::authorizedColumns))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("AuthorizedColumns").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<String> builder(MarshallingType.STRING)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").build()).build()).build()).build();

    private static final SdkField<List<String>> NOT_AUTHORIZED_COLUMNS_FIELD = SdkField
            .<List<String>> builder(MarshallingType.LIST)
            .memberName("NotAuthorizedColumns")
            .getter(getter(PermissionBoundary::notAuthorizedColumns))
            .setter(setter(Builder::notAuthorizedColumns))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("NotAuthorizedColumns").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<String> builder(MarshallingType.STRING)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").build()).build()).build()).build();

    private static final SdkField<Boolean> TREAT_COLUMNS_ALLOWED_BY_DEFAULT_FIELD = SdkField
            .<Boolean> builder(MarshallingType.BOOLEAN)
            .memberName("TreatColumnsAllowedByDefault")
            .getter(getter(PermissionBoundary::treatColumnsAllowedByDefault))
            .setter(setter(Builder::treatColumnsAllowedByDefault))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("TreatColumnsAllowedByDefault")
                    .build()).build();

    private static final SdkField<String> ROW_FILTER_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("RowFilter").getter(getter(PermissionBoundary::rowFilter)).setter(setter(Builder::rowFilter))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("RowFilter").build()).build();

    private static final SdkField<List<ColumnFilter>> COLUMN_FILTERS_FIELD = SdkField
            .<List<ColumnFilter>> builder(MarshallingType.LIST)
            .memberName("ColumnFilters")
            .getter(getter(PermissionBoundary::columnFilters))
            .setter(setter(Builder::columnFilters))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("ColumnFilters").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<ColumnFilter> builder(MarshallingType.SDK_POJO)
                                            .constructor(ColumnFilter::builder)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").build()).build()).build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(AUTHORIZED_COLUMNS_FIELD,
            NOT_AUTHORIZED_COLUMNS_FIELD, TREAT_COLUMNS_ALLOWED_BY_DEFAULT_FIELD, ROW_FILTER_FIELD, COLUMN_FILTERS_FIELD));

    private static final long serialVersionUID = 1L;

    private final List<String> authorizedColumns;

    private final List<String> notAuthorizedColumns;

    private final Boolean treatColumnsAllowedByDefault;

    private final String rowFilter;

    private final List<ColumnFilter> columnFilters;

    private PermissionBoundary(BuilderImpl builder) {
        this.authorizedColumns = builder.authorizedColumns;
        this.notAuthorizedColumns = builder.notAuthorizedColumns;
        this.treatColumnsAllowedByDefault = builder.treatColumnsAllowedByDefault;
        this.rowFilter = builder.rowFilter;
        this.columnFilters = builder.columnFilters;
    }

    /**
     * For responses, this returns true if the service returned a value for the AuthorizedColumns property. This DOES
     * NOT check that the value is non-empty (for which, you should check the {@code isEmpty()} method on the property).
     * This is useful because the SDK will never return a null collection or map, but you may need to differentiate
     * between the service returning nothing (or null) and the service returning an empty collection or map. For
     * requests, this returns true if a value for the property was specified in the request builder, and false if a
     * value was not specified.
     */
    public final boolean hasAuthorizedColumns() {
        return authorizedColumns != null && !(authorizedColumns instanceof SdkAutoConstructList);
    }

    /**
     * Returns the value of the AuthorizedColumns property for this object.
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasAuthorizedColumns} method.
     * </p>
     * 
     * @return The value of the AuthorizedColumns property for this object.
     */
    public final List<String> authorizedColumns() {
        return authorizedColumns;
    }

    /**
     * For responses, this returns true if the service returned a value for the NotAuthorizedColumns property. This DOES
     * NOT check that the value is non-empty (for which, you should check the {@code isEmpty()} method on the property).
     * This is useful because the SDK will never return a null collection or map, but you may need to differentiate
     * between the service returning nothing (or null) and the service returning an empty collection or map. For
     * requests, this returns true if a value for the property was specified in the request builder, and false if a
     * value was not specified.
     */
    public final boolean hasNotAuthorizedColumns() {
        return notAuthorizedColumns != null && !(notAuthorizedColumns instanceof SdkAutoConstructList);
    }

    /**
     * Returns the value of the NotAuthorizedColumns property for this object.
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasNotAuthorizedColumns} method.
     * </p>
     * 
     * @return The value of the NotAuthorizedColumns property for this object.
     */
    public final List<String> notAuthorizedColumns() {
        return notAuthorizedColumns;
    }

    /**
     * Returns the value of the TreatColumnsAllowedByDefault property for this object.
     * 
     * @return The value of the TreatColumnsAllowedByDefault property for this object.
     */
    public final Boolean treatColumnsAllowedByDefault() {
        return treatColumnsAllowedByDefault;
    }

    /**
     * Returns the value of the RowFilter property for this object.
     * 
     * @return The value of the RowFilter property for this object.
     */
    public final String rowFilter() {
        return rowFilter;
    }

    /**
     * For responses, this returns true if the service returned a value for the ColumnFilters property. This DOES NOT
     * check that the value is non-empty (for which, you should check the {@code isEmpty()} method on the property).
     * This is useful because the SDK will never return a null collection or map, but you may need to differentiate
     * between the service returning nothing (or null) and the service returning an empty collection or map. For
     * requests, this returns true if a value for the property was specified in the request builder, and false if a
     * value was not specified.
     */
    public final boolean hasColumnFilters() {
        return columnFilters != null && !(columnFilters instanceof SdkAutoConstructList);
    }

    /**
     * Returns the value of the ColumnFilters property for this object.
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasColumnFilters} method.
     * </p>
     * 
     * @return The value of the ColumnFilters property for this object.
     */
    public final List<ColumnFilter> columnFilters() {
        return columnFilters;
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
        hashCode = 31 * hashCode + Objects.hashCode(hasAuthorizedColumns() ? authorizedColumns() : null);
        hashCode = 31 * hashCode + Objects.hashCode(hasNotAuthorizedColumns() ? notAuthorizedColumns() : null);
        hashCode = 31 * hashCode + Objects.hashCode(treatColumnsAllowedByDefault());
        hashCode = 31 * hashCode + Objects.hashCode(rowFilter());
        hashCode = 31 * hashCode + Objects.hashCode(hasColumnFilters() ? columnFilters() : null);
        return hashCode;
    }

    @Override
    public final boolean equals(Object obj) {
        return equalsBySdkFields(obj);
    }

    @Override
    public final boolean equalsBySdkFields(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof PermissionBoundary)) {
            return false;
        }
        PermissionBoundary other = (PermissionBoundary) obj;
        return hasAuthorizedColumns() == other.hasAuthorizedColumns()
                && Objects.equals(authorizedColumns(), other.authorizedColumns())
                && hasNotAuthorizedColumns() == other.hasNotAuthorizedColumns()
                && Objects.equals(notAuthorizedColumns(), other.notAuthorizedColumns())
                && Objects.equals(treatColumnsAllowedByDefault(), other.treatColumnsAllowedByDefault())
                && Objects.equals(rowFilter(), other.rowFilter()) && hasColumnFilters() == other.hasColumnFilters()
                && Objects.equals(columnFilters(), other.columnFilters());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("PermissionBoundary")
                .add("AuthorizedColumns", hasAuthorizedColumns() ? authorizedColumns() : null)
                .add("NotAuthorizedColumns", hasNotAuthorizedColumns() ? notAuthorizedColumns() : null)
                .add("TreatColumnsAllowedByDefault", treatColumnsAllowedByDefault()).add("RowFilter", rowFilter())
                .add("ColumnFilters", hasColumnFilters() ? columnFilters() : null).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "AuthorizedColumns":
            return Optional.ofNullable(clazz.cast(authorizedColumns()));
        case "NotAuthorizedColumns":
            return Optional.ofNullable(clazz.cast(notAuthorizedColumns()));
        case "TreatColumnsAllowedByDefault":
            return Optional.ofNullable(clazz.cast(treatColumnsAllowedByDefault()));
        case "RowFilter":
            return Optional.ofNullable(clazz.cast(rowFilter()));
        case "ColumnFilters":
            return Optional.ofNullable(clazz.cast(columnFilters()));
        default:
            return Optional.empty();
        }
    }

    @Override
    public final List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    private static <T> Function<Object, T> getter(Function<PermissionBoundary, T> g) {
        return obj -> g.apply((PermissionBoundary) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    public interface Builder extends SdkPojo, CopyableBuilder<Builder, PermissionBoundary> {
        /**
         * Sets the value of the AuthorizedColumns property for this object.
         *
         * @param authorizedColumns
         *        The new value for the AuthorizedColumns property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder authorizedColumns(Collection<String> authorizedColumns);

        /**
         * Sets the value of the AuthorizedColumns property for this object.
         *
         * @param authorizedColumns
         *        The new value for the AuthorizedColumns property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder authorizedColumns(String... authorizedColumns);

        /**
         * Sets the value of the NotAuthorizedColumns property for this object.
         *
         * @param notAuthorizedColumns
         *        The new value for the NotAuthorizedColumns property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder notAuthorizedColumns(Collection<String> notAuthorizedColumns);

        /**
         * Sets the value of the NotAuthorizedColumns property for this object.
         *
         * @param notAuthorizedColumns
         *        The new value for the NotAuthorizedColumns property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder notAuthorizedColumns(String... notAuthorizedColumns);

        /**
         * Sets the value of the TreatColumnsAllowedByDefault property for this object.
         *
         * @param treatColumnsAllowedByDefault
         *        The new value for the TreatColumnsAllowedByDefault property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder treatColumnsAllowedByDefault(Boolean treatColumnsAllowedByDefault);

        /**
         * Sets the value of the RowFilter property for this object.
         *
         * @param rowFilter
         *        The new value for the RowFilter property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder rowFilter(String rowFilter);

        /**
         * Sets the value of the ColumnFilters property for this object.
         *
         * @param columnFilters
         *        The new value for the ColumnFilters property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder columnFilters(Collection<ColumnFilter> columnFilters);

        /**
         * Sets the value of the ColumnFilters property for this object.
         *
         * @param columnFilters
         *        The new value for the ColumnFilters property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder columnFilters(ColumnFilter... columnFilters);

        /**
         * Sets the value of the ColumnFilters property for this object.
         *
         * This is a convenience that creates an instance of the {@link List<ColumnFilter>.Builder} avoiding the need to
         * create one manually via {@link List<ColumnFilter>#builder()}.
         *
         * When the {@link Consumer} completes, {@link List<ColumnFilter>.Builder#build()} is called immediately and its
         * result is passed to {@link #columnFilters(List<ColumnFilter>)}.
         * 
         * @param columnFilters
         *        a consumer that will call methods on {@link List<ColumnFilter>.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #columnFilters(List<ColumnFilter>)
         */
        Builder columnFilters(Consumer<ColumnFilter.Builder>... columnFilters);
    }

    static final class BuilderImpl implements Builder {
        private List<String> authorizedColumns = DefaultSdkAutoConstructList.getInstance();

        private List<String> notAuthorizedColumns = DefaultSdkAutoConstructList.getInstance();

        private Boolean treatColumnsAllowedByDefault;

        private String rowFilter;

        private List<ColumnFilter> columnFilters = DefaultSdkAutoConstructList.getInstance();

        private BuilderImpl() {
        }

        private BuilderImpl(PermissionBoundary model) {
            authorizedColumns(model.authorizedColumns);
            notAuthorizedColumns(model.notAuthorizedColumns);
            treatColumnsAllowedByDefault(model.treatColumnsAllowedByDefault);
            rowFilter(model.rowFilter);
            columnFilters(model.columnFilters);
        }

        public final Collection<String> getAuthorizedColumns() {
            if (authorizedColumns instanceof SdkAutoConstructList) {
                return null;
            }
            return authorizedColumns;
        }

        public final void setAuthorizedColumns(Collection<String> authorizedColumns) {
            this.authorizedColumns = ColumnNamesCopier.copy(authorizedColumns);
        }

        @Override
        @Transient
        public final Builder authorizedColumns(Collection<String> authorizedColumns) {
            this.authorizedColumns = ColumnNamesCopier.copy(authorizedColumns);
            return this;
        }

        @Override
        @Transient
        @SafeVarargs
        public final Builder authorizedColumns(String... authorizedColumns) {
            authorizedColumns(Arrays.asList(authorizedColumns));
            return this;
        }

        public final Collection<String> getNotAuthorizedColumns() {
            if (notAuthorizedColumns instanceof SdkAutoConstructList) {
                return null;
            }
            return notAuthorizedColumns;
        }

        public final void setNotAuthorizedColumns(Collection<String> notAuthorizedColumns) {
            this.notAuthorizedColumns = ColumnNamesCopier.copy(notAuthorizedColumns);
        }

        @Override
        @Transient
        public final Builder notAuthorizedColumns(Collection<String> notAuthorizedColumns) {
            this.notAuthorizedColumns = ColumnNamesCopier.copy(notAuthorizedColumns);
            return this;
        }

        @Override
        @Transient
        @SafeVarargs
        public final Builder notAuthorizedColumns(String... notAuthorizedColumns) {
            notAuthorizedColumns(Arrays.asList(notAuthorizedColumns));
            return this;
        }

        public final Boolean getTreatColumnsAllowedByDefault() {
            return treatColumnsAllowedByDefault;
        }

        public final void setTreatColumnsAllowedByDefault(Boolean treatColumnsAllowedByDefault) {
            this.treatColumnsAllowedByDefault = treatColumnsAllowedByDefault;
        }

        @Override
        @Transient
        public final Builder treatColumnsAllowedByDefault(Boolean treatColumnsAllowedByDefault) {
            this.treatColumnsAllowedByDefault = treatColumnsAllowedByDefault;
            return this;
        }

        public final String getRowFilter() {
            return rowFilter;
        }

        public final void setRowFilter(String rowFilter) {
            this.rowFilter = rowFilter;
        }

        @Override
        @Transient
        public final Builder rowFilter(String rowFilter) {
            this.rowFilter = rowFilter;
            return this;
        }

        public final List<ColumnFilter.Builder> getColumnFilters() {
            List<ColumnFilter.Builder> result = ColumnFiltersCopier.copyToBuilder(this.columnFilters);
            if (result instanceof SdkAutoConstructList) {
                return null;
            }
            return result;
        }

        public final void setColumnFilters(Collection<ColumnFilter.BuilderImpl> columnFilters) {
            this.columnFilters = ColumnFiltersCopier.copyFromBuilder(columnFilters);
        }

        @Override
        @Transient
        public final Builder columnFilters(Collection<ColumnFilter> columnFilters) {
            this.columnFilters = ColumnFiltersCopier.copy(columnFilters);
            return this;
        }

        @Override
        @Transient
        @SafeVarargs
        public final Builder columnFilters(ColumnFilter... columnFilters) {
            columnFilters(Arrays.asList(columnFilters));
            return this;
        }

        @Override
        @Transient
        @SafeVarargs
        public final Builder columnFilters(Consumer<ColumnFilter.Builder>... columnFilters) {
            columnFilters(Stream.of(columnFilters).map(c -> ColumnFilter.builder().applyMutation(c).build())
                    .collect(Collectors.toList()));
            return this;
        }

        @Override
        public PermissionBoundary build() {
            return new PermissionBoundary(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }
}
