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
public final class GetPartitionResponse extends GlueCatalogFederationResponse implements
        ToCopyableBuilder<GetPartitionResponse.Builder, GetPartitionResponse> {
    private static final SdkField<Partition> PARTITION_FIELD = SdkField.<Partition> builder(MarshallingType.SDK_POJO)
            .memberName("Partition").getter(getter(GetPartitionResponse::partition)).setter(setter(Builder::partition))
            .constructor(Partition::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Partition").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(PARTITION_FIELD));

    private final Partition partition;

    private GetPartitionResponse(BuilderImpl builder) {
        super(builder);
        this.partition = builder.partition;
    }

    /**
     * Returns the value of the Partition property for this object.
     * 
     * @return The value of the Partition property for this object.
     */
    public final Partition partition() {
        return partition;
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
        hashCode = 31 * hashCode + Objects.hashCode(partition());
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
        if (!(obj instanceof GetPartitionResponse)) {
            return false;
        }
        GetPartitionResponse other = (GetPartitionResponse) obj;
        return Objects.equals(partition(), other.partition());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("GetPartitionResponse").add("Partition", partition()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Partition":
            return Optional.ofNullable(clazz.cast(partition()));
        default:
            return Optional.empty();
        }
    }

    @Override
    public final List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    private static <T> Function<Object, T> getter(Function<GetPartitionResponse, T> g) {
        return obj -> g.apply((GetPartitionResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    public interface Builder extends GlueCatalogFederationResponse.Builder, SdkPojo,
            CopyableBuilder<Builder, GetPartitionResponse> {
        /**
         * Sets the value of the Partition property for this object.
         *
         * @param partition
         *        The new value for the Partition property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder partition(Partition partition);

        /**
         * Sets the value of the Partition property for this object.
         *
         * This is a convenience that creates an instance of the {@link Partition.Builder} avoiding the need to create
         * one manually via {@link Partition#builder()}.
         *
         * When the {@link Consumer} completes, {@link Partition.Builder#build()} is called immediately and its result
         * is passed to {@link #partition(Partition)}.
         * 
         * @param partition
         *        a consumer that will call methods on {@link Partition.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #partition(Partition)
         */
        default Builder partition(Consumer<Partition.Builder> partition) {
            return partition(Partition.builder().applyMutation(partition).build());
        }
    }

    static final class BuilderImpl extends GlueCatalogFederationResponse.BuilderImpl implements Builder {
        private Partition partition;

        private BuilderImpl() {
        }

        private BuilderImpl(GetPartitionResponse model) {
            super(model);
            partition(model.partition);
        }

        public final Partition.Builder getPartition() {
            return partition != null ? partition.toBuilder() : null;
        }

        public final void setPartition(Partition.BuilderImpl partition) {
            this.partition = partition != null ? partition.build() : null;
        }

        @Override
        @Transient
        public final Builder partition(Partition partition) {
            this.partition = partition;
            return this;
        }

        @Override
        public GetPartitionResponse build() {
            return new GetPartitionResponse(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }
}
