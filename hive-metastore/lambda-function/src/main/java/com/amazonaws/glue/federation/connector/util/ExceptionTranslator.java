/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.amazonaws.glue.federation.connector.util;

import org.apache.hadoop.hive.metastore.api.InvalidOperationException;
import org.apache.hadoop.hive.metastore.api.MetaException;
import org.apache.hadoop.hive.metastore.api.NoSuchObjectException;
import org.apache.hadoop.hive.metastore.api.UnknownDBException;
import org.apache.thrift.TException;
import software.amazon.awssdk.services.gluecatalogfederation.model.AccessDeniedException;
import software.amazon.awssdk.services.gluecatalogfederation.model.EntityNotFoundException;
import software.amazon.awssdk.services.gluecatalogfederation.model.ErrorCode;
import software.amazon.awssdk.services.gluecatalogfederation.model.ErrorDetail;
import software.amazon.awssdk.services.gluecatalogfederation.model.GlueCatalogFederationException;
import software.amazon.awssdk.services.gluecatalogfederation.model.InternalServiceException;
import software.amazon.awssdk.services.gluecatalogfederation.model.InvalidInputException;
import software.amazon.awssdk.services.gluecatalogfederation.model.OperationNotSupportedException;
import software.amazon.awssdk.services.gluecatalogfederation.model.ThrottlingException;

import java.util.HashMap;
import java.util.Map;

/**
 * Provides methods for exception translation from Hive Metastore exceptions to GlueCatalogFederationException for
 * all operations.
 */
public class ExceptionTranslator {

    private ExceptionTranslator() {
        throw new UnsupportedOperationException();
    }

    private final static Map<Class<? extends GlueCatalogFederationException>, ErrorCode> errorCodeMap;

    static {
        // Initialize error code mapping for GlueCatalogFederationException
        errorCodeMap = new HashMap<>();
        errorCodeMap.put(AccessDeniedException.class, ErrorCode.ACCESS_DENIED_EXCEPTION);
        errorCodeMap.put(EntityNotFoundException.class, ErrorCode.ENTITY_NOT_FOUND_EXCEPTION);
        errorCodeMap.put(InternalServiceException.class, ErrorCode.INTERNAL_SERVICE_EXCEPTION);
        errorCodeMap.put(InvalidInputException.class, ErrorCode.INVALID_INPUT_EXCEPTION);
        errorCodeMap.put(OperationNotSupportedException.class, ErrorCode.OPERATION_NOT_SUPPORTED_EXCEPTION);
        errorCodeMap.put(ThrottlingException.class, ErrorCode.THROTTLING_EXCEPTION);
    }

    public static ErrorDetail errorDetailOf(GlueCatalogFederationException ex) {
        return ErrorDetail.builder()
                .errorMessage(ex.getMessage())
                .errorCode(errorCodeMap.get(ex.getClass()))
                .build();
    }

    /*
        All exception translations should be added here as override methods and then called from within the API
        handler. This keeps all exception translations centralized while still requiring that each Hive Metastore
        exception is handled properly.
     */

    /**
     * InvalidOperationException - invalid operation was attempted on the Hive Metastore due to user input
     */
    public static InvalidInputException translateInvalidOperationException(InvalidOperationException ex) {
        return InvalidInputException.builder()
                .message("Input caused invalid operation in Hive Metastore: " + ex.getMessage())
                .cause(ex)
                .statusCode(400)
                .build();
    }

    /**
     * UnknownDBException - requested database does not exist in Hive Metastore
     */
    public static EntityNotFoundException translateUnknownDBException(UnknownDBException ex) {
        return EntityNotFoundException.builder()
                .message("Unknown Hive Metastore database: " + ex.getMessage())
                .cause(ex)
                .statusCode(400)
                .build();
    }

    /**
     * NoSuchObjectException - requested objects does not exist in Hive Metastore
     */
    public static EntityNotFoundException translateNoSuchObjectException(NoSuchObjectException ex) {
        return EntityNotFoundException.builder()
                .message("Hive Metastore object does not exist: " + ex.getMessage())
                .cause(ex)
                .statusCode(400)
                .build();
    }

    /**
     * MetaException - request reached Hive Metastore but unknown exception was thrown
     */
    public static InternalServiceException translateMetaException(MetaException ex) {
        return InternalServiceException.builder()
                .message("Hive Metastore exception: " + ex.getMessage())
                .cause(ex)
                .statusCode(500)
                .build();
    }

    /**
     * TException - request could not reach the Hive Metastore
     */
    public static InternalServiceException translateTException(TException ex) {
        throw InternalServiceException.builder()
                .message("Issue reaching the Hive Metastore: " + ex.getMessage())
                .cause(ex)
                .statusCode(500)
                .build();
    }
}
