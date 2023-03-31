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
import java.util.function.Function;
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
public final class Actions implements SdkPojo, Serializable, ToCopyableBuilder<Actions.Builder, Actions> {
    private static final SdkField<List<String>> S3_ACTIONS_FIELD = SdkField
            .<List<String>> builder(MarshallingType.LIST)
            .memberName("S3Actions")
            .getter(getter(Actions::s3ActionsAsStrings))
            .setter(setter(Builder::s3ActionsWithStrings))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("S3Actions").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<String> builder(MarshallingType.STRING)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").build()).build()).build()).build();

    private static final SdkField<List<String>> KMS_ACTIONS_FIELD = SdkField
            .<List<String>> builder(MarshallingType.LIST)
            .memberName("KMSActions")
            .getter(getter(Actions::kmsActionsAsStrings))
            .setter(setter(Builder::kmsActionsWithStrings))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KMSActions").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<String> builder(MarshallingType.STRING)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").build()).build()).build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(S3_ACTIONS_FIELD,
            KMS_ACTIONS_FIELD));

    private static final long serialVersionUID = 1L;

    private final List<String> s3Actions;

    private final List<String> kmsActions;

    private Actions(BuilderImpl builder) {
        this.s3Actions = builder.s3Actions;
        this.kmsActions = builder.kmsActions;
    }

    /**
     * Returns the value of the S3Actions property for this object.
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasS3Actions} method.
     * </p>
     * 
     * @return The value of the S3Actions property for this object.
     */
    public final List<S3Action> s3Actions() {
        return S3ActionsCopier.copyStringToEnum(s3Actions);
    }

    /**
     * For responses, this returns true if the service returned a value for the S3Actions property. This DOES NOT check
     * that the value is non-empty (for which, you should check the {@code isEmpty()} method on the property). This is
     * useful because the SDK will never return a null collection or map, but you may need to differentiate between the
     * service returning nothing (or null) and the service returning an empty collection or map. For requests, this
     * returns true if a value for the property was specified in the request builder, and false if a value was not
     * specified.
     */
    public final boolean hasS3Actions() {
        return s3Actions != null && !(s3Actions instanceof SdkAutoConstructList);
    }

    /**
     * Returns the value of the S3Actions property for this object.
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasS3Actions} method.
     * </p>
     * 
     * @return The value of the S3Actions property for this object.
     */
    public final List<String> s3ActionsAsStrings() {
        return s3Actions;
    }

    /**
     * Returns the value of the KMSActions property for this object.
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasKmsActions} method.
     * </p>
     * 
     * @return The value of the KMSActions property for this object.
     */
    public final List<KMSAction> kmsActions() {
        return KMSActionsCopier.copyStringToEnum(kmsActions);
    }

    /**
     * For responses, this returns true if the service returned a value for the KMSActions property. This DOES NOT check
     * that the value is non-empty (for which, you should check the {@code isEmpty()} method on the property). This is
     * useful because the SDK will never return a null collection or map, but you may need to differentiate between the
     * service returning nothing (or null) and the service returning an empty collection or map. For requests, this
     * returns true if a value for the property was specified in the request builder, and false if a value was not
     * specified.
     */
    public final boolean hasKmsActions() {
        return kmsActions != null && !(kmsActions instanceof SdkAutoConstructList);
    }

    /**
     * Returns the value of the KMSActions property for this object.
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasKmsActions} method.
     * </p>
     * 
     * @return The value of the KMSActions property for this object.
     */
    public final List<String> kmsActionsAsStrings() {
        return kmsActions;
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
        hashCode = 31 * hashCode + Objects.hashCode(hasS3Actions() ? s3ActionsAsStrings() : null);
        hashCode = 31 * hashCode + Objects.hashCode(hasKmsActions() ? kmsActionsAsStrings() : null);
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
        if (!(obj instanceof Actions)) {
            return false;
        }
        Actions other = (Actions) obj;
        return hasS3Actions() == other.hasS3Actions() && Objects.equals(s3ActionsAsStrings(), other.s3ActionsAsStrings())
                && hasKmsActions() == other.hasKmsActions() && Objects.equals(kmsActionsAsStrings(), other.kmsActionsAsStrings());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("Actions").add("S3Actions", hasS3Actions() ? s3ActionsAsStrings() : null)
                .add("KMSActions", hasKmsActions() ? kmsActionsAsStrings() : null).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "S3Actions":
            return Optional.ofNullable(clazz.cast(s3ActionsAsStrings()));
        case "KMSActions":
            return Optional.ofNullable(clazz.cast(kmsActionsAsStrings()));
        default:
            return Optional.empty();
        }
    }

    @Override
    public final List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    private static <T> Function<Object, T> getter(Function<Actions, T> g) {
        return obj -> g.apply((Actions) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    public interface Builder extends SdkPojo, CopyableBuilder<Builder, Actions> {
        /**
         * Sets the value of the S3Actions property for this object.
         *
         * @param s3Actions
         *        The new value for the S3Actions property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder s3ActionsWithStrings(Collection<String> s3Actions);

        /**
         * Sets the value of the S3Actions property for this object.
         *
         * @param s3Actions
         *        The new value for the S3Actions property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder s3ActionsWithStrings(String... s3Actions);

        /**
         * Sets the value of the S3Actions property for this object.
         *
         * @param s3Actions
         *        The new value for the S3Actions property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder s3Actions(Collection<S3Action> s3Actions);

        /**
         * Sets the value of the S3Actions property for this object.
         *
         * @param s3Actions
         *        The new value for the S3Actions property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder s3Actions(S3Action... s3Actions);

        /**
         * Sets the value of the KMSActions property for this object.
         *
         * @param kmsActions
         *        The new value for the KMSActions property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder kmsActionsWithStrings(Collection<String> kmsActions);

        /**
         * Sets the value of the KMSActions property for this object.
         *
         * @param kmsActions
         *        The new value for the KMSActions property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder kmsActionsWithStrings(String... kmsActions);

        /**
         * Sets the value of the KMSActions property for this object.
         *
         * @param kmsActions
         *        The new value for the KMSActions property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder kmsActions(Collection<KMSAction> kmsActions);

        /**
         * Sets the value of the KMSActions property for this object.
         *
         * @param kmsActions
         *        The new value for the KMSActions property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder kmsActions(KMSAction... kmsActions);
    }

    static final class BuilderImpl implements Builder {
        private List<String> s3Actions = DefaultSdkAutoConstructList.getInstance();

        private List<String> kmsActions = DefaultSdkAutoConstructList.getInstance();

        private BuilderImpl() {
        }

        private BuilderImpl(Actions model) {
            s3ActionsWithStrings(model.s3Actions);
            kmsActionsWithStrings(model.kmsActions);
        }

        public final Collection<String> getS3Actions() {
            if (s3Actions instanceof SdkAutoConstructList) {
                return null;
            }
            return s3Actions;
        }

        public final void setS3Actions(Collection<String> s3Actions) {
            this.s3Actions = S3ActionsCopier.copy(s3Actions);
        }

        @Override
        @Transient
        public final Builder s3ActionsWithStrings(Collection<String> s3Actions) {
            this.s3Actions = S3ActionsCopier.copy(s3Actions);
            return this;
        }

        @Override
        @Transient
        @SafeVarargs
        public final Builder s3ActionsWithStrings(String... s3Actions) {
            s3ActionsWithStrings(Arrays.asList(s3Actions));
            return this;
        }

        @Override
        @Transient
        public final Builder s3Actions(Collection<S3Action> s3Actions) {
            this.s3Actions = S3ActionsCopier.copyEnumToString(s3Actions);
            return this;
        }

        @Override
        @Transient
        @SafeVarargs
        public final Builder s3Actions(S3Action... s3Actions) {
            s3Actions(Arrays.asList(s3Actions));
            return this;
        }

        public final Collection<String> getKmsActions() {
            if (kmsActions instanceof SdkAutoConstructList) {
                return null;
            }
            return kmsActions;
        }

        public final void setKmsActions(Collection<String> kmsActions) {
            this.kmsActions = KMSActionsCopier.copy(kmsActions);
        }

        @Override
        @Transient
        public final Builder kmsActionsWithStrings(Collection<String> kmsActions) {
            this.kmsActions = KMSActionsCopier.copy(kmsActions);
            return this;
        }

        @Override
        @Transient
        @SafeVarargs
        public final Builder kmsActionsWithStrings(String... kmsActions) {
            kmsActionsWithStrings(Arrays.asList(kmsActions));
            return this;
        }

        @Override
        @Transient
        public final Builder kmsActions(Collection<KMSAction> kmsActions) {
            this.kmsActions = KMSActionsCopier.copyEnumToString(kmsActions);
            return this;
        }

        @Override
        @Transient
        @SafeVarargs
        public final Builder kmsActions(KMSAction... kmsActions) {
            kmsActions(Arrays.asList(kmsActions));
            return this;
        }

        @Override
        public Actions build() {
            return new Actions(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }
}
