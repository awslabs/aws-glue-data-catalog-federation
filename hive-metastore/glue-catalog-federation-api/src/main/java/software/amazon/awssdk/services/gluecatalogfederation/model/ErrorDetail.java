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
public final class ErrorDetail implements SdkPojo, Serializable, ToCopyableBuilder<ErrorDetail.Builder, ErrorDetail> {
    private static final SdkField<String> ERROR_CODE_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("ErrorCode").getter(getter(ErrorDetail::errorCodeAsString)).setter(setter(Builder::errorCode))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("ErrorCode").build()).build();

    private static final SdkField<String> ERROR_MESSAGE_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("ErrorMessage").getter(getter(ErrorDetail::errorMessage)).setter(setter(Builder::errorMessage))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("ErrorMessage").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(ERROR_CODE_FIELD,
            ERROR_MESSAGE_FIELD));

    private static final long serialVersionUID = 1L;

    private final String errorCode;

    private final String errorMessage;

    private ErrorDetail(BuilderImpl builder) {
        this.errorCode = builder.errorCode;
        this.errorMessage = builder.errorMessage;
    }

    /**
     * Returns the value of the ErrorCode property for this object.
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #errorCode} will
     * return {@link ErrorCode#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #errorCodeAsString}.
     * </p>
     * 
     * @return The value of the ErrorCode property for this object.
     * @see ErrorCode
     */
    public final ErrorCode errorCode() {
        return ErrorCode.fromValue(errorCode);
    }

    /**
     * Returns the value of the ErrorCode property for this object.
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #errorCode} will
     * return {@link ErrorCode#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #errorCodeAsString}.
     * </p>
     * 
     * @return The value of the ErrorCode property for this object.
     * @see ErrorCode
     */
    public final String errorCodeAsString() {
        return errorCode;
    }

    /**
     * Returns the value of the ErrorMessage property for this object.
     * 
     * @return The value of the ErrorMessage property for this object.
     */
    public final String errorMessage() {
        return errorMessage;
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
        hashCode = 31 * hashCode + Objects.hashCode(errorCodeAsString());
        hashCode = 31 * hashCode + Objects.hashCode(errorMessage());
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
        if (!(obj instanceof ErrorDetail)) {
            return false;
        }
        ErrorDetail other = (ErrorDetail) obj;
        return Objects.equals(errorCodeAsString(), other.errorCodeAsString())
                && Objects.equals(errorMessage(), other.errorMessage());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("ErrorDetail").add("ErrorCode", errorCodeAsString()).add("ErrorMessage", errorMessage()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "ErrorCode":
            return Optional.ofNullable(clazz.cast(errorCodeAsString()));
        case "ErrorMessage":
            return Optional.ofNullable(clazz.cast(errorMessage()));
        default:
            return Optional.empty();
        }
    }

    @Override
    public final List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    private static <T> Function<Object, T> getter(Function<ErrorDetail, T> g) {
        return obj -> g.apply((ErrorDetail) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    public interface Builder extends SdkPojo, CopyableBuilder<Builder, ErrorDetail> {
        /**
         * Sets the value of the ErrorCode property for this object.
         *
         * @param errorCode
         *        The new value for the ErrorCode property for this object.
         * @see ErrorCode
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ErrorCode
         */
        Builder errorCode(String errorCode);

        /**
         * Sets the value of the ErrorCode property for this object.
         *
         * @param errorCode
         *        The new value for the ErrorCode property for this object.
         * @see ErrorCode
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ErrorCode
         */
        Builder errorCode(ErrorCode errorCode);

        /**
         * Sets the value of the ErrorMessage property for this object.
         *
         * @param errorMessage
         *        The new value for the ErrorMessage property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder errorMessage(String errorMessage);
    }

    static final class BuilderImpl implements Builder {
        private String errorCode;

        private String errorMessage;

        private BuilderImpl() {
        }

        private BuilderImpl(ErrorDetail model) {
            errorCode(model.errorCode);
            errorMessage(model.errorMessage);
        }

        public final String getErrorCode() {
            return errorCode;
        }

        public final void setErrorCode(String errorCode) {
            this.errorCode = errorCode;
        }

        @Override
        @Transient
        public final Builder errorCode(String errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        @Override
        @Transient
        public final Builder errorCode(ErrorCode errorCode) {
            this.errorCode(errorCode == null ? null : errorCode.toString());
            return this;
        }

        public final String getErrorMessage() {
            return errorMessage;
        }

        public final void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        @Override
        @Transient
        public final Builder errorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
            return this;
        }

        @Override
        public ErrorDetail build() {
            return new ErrorDetail(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }
}
