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

import software.amazon.awssdk.annotations.Generated;
import software.amazon.awssdk.awscore.AwsResponse;
import software.amazon.awssdk.awscore.AwsResponseMetadata;

@Generated("software.amazon.awssdk:codegen")
public abstract class GlueCatalogFederationResponse extends AwsResponse {
    private final GlueCatalogFederationResponseMetadata responseMetadata;

    protected GlueCatalogFederationResponse(Builder builder) {
        super(builder);
        this.responseMetadata = builder.responseMetadata();
    }

    @Override
    public GlueCatalogFederationResponseMetadata responseMetadata() {
        return responseMetadata;
    }

    public interface Builder extends AwsResponse.Builder {
        @Override
        GlueCatalogFederationResponse build();

        @Override
        GlueCatalogFederationResponseMetadata responseMetadata();

        @Override
        Builder responseMetadata(AwsResponseMetadata metadata);
    }

    protected abstract static class BuilderImpl extends AwsResponse.BuilderImpl implements Builder {
        private GlueCatalogFederationResponseMetadata responseMetadata;

        protected BuilderImpl() {
        }

        protected BuilderImpl(GlueCatalogFederationResponse response) {
            super(response);
            this.responseMetadata = response.responseMetadata();
        }

        @Override
        public GlueCatalogFederationResponseMetadata responseMetadata() {
            return responseMetadata;
        }

        @Override
        public Builder responseMetadata(AwsResponseMetadata responseMetadata) {
            this.responseMetadata = GlueCatalogFederationResponseMetadata.create(responseMetadata);
            return this;
        }
    }
}
