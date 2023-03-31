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

import org.apache.hadoop.hive.metastore.api.FieldSchema;
import software.amazon.awssdk.services.gluecatalogfederation.model.Column;
import software.amazon.awssdk.services.gluecatalogfederation.model.Database;
import software.amazon.awssdk.services.gluecatalogfederation.model.Partition;
import software.amazon.awssdk.services.gluecatalogfederation.model.SerDeInfo;
import software.amazon.awssdk.services.gluecatalogfederation.model.StorageDescriptor;
import software.amazon.awssdk.services.gluecatalogfederation.model.Table;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides methods for converting Hive metadata objects to Glue Catalog federation metadata objects.
 */
public class HiveToGlueConverter {

    private static final String ENV_CONVERT_S3N = "CONVERT_S3N";

    private HiveToGlueConverter() {
        throw new UnsupportedOperationException();
    }

    public static Database convertDatabase(org.apache.hadoop.hive.metastore.api.Database hmsDatabase) {
        String location = checkS3Uri(hmsDatabase.getLocationUri());
        return Database.builder()
                .databaseIdentifier(hmsDatabase.getName())
                .description(hmsDatabase.getDescription())
                .locationUri(location)
                .parameters(hmsDatabase.getParameters())
                .createTime(null) // Field not supported in the Hive object
                .build();
    }

    public static Table convertTable(org.apache.hadoop.hive.metastore.api.Table hmsTable, String id) {
        return Table.builder()
                .id(id)
                .databaseIdentifier(hmsTable.getDbName())
                .tableIdentifier(hmsTable.getTableName())
                .createTime(Instant.ofEpochSecond(hmsTable.getCreateTime()))
                .lastAccessTime(Instant.ofEpochSecond(hmsTable.getLastAccessTime()))
                .parameters(hmsTable.getParameters())
                .tableType(hmsTable.getTableType())
                .storageDescriptor(convertStorageDescriptor(hmsTable.getSd()))
                .partitionKeys(convertFieldSchemaList(hmsTable.getPartitionKeys()))
                .description(null) // Field not supported in the Hive object
                .updateTime(null) // Field not supported in the Hive object
                .build();
    }

    public static Partition convertPartition(org.apache.hadoop.hive.metastore.api.Partition hmsPartition) {
        return Partition.builder()
                .databaseIdentifier(hmsPartition.getDbName())
                .tableIdentifier(hmsPartition.getTableName())
                .creationTime(Instant.ofEpochSecond(hmsPartition.getCreateTime()))
                .lastAccessTime(Instant.ofEpochSecond(hmsPartition.getLastAccessTime()))
                .parameters(hmsPartition.getParameters())
                .storageDescriptor(convertStorageDescriptor(hmsPartition.getSd()))
                .values(hmsPartition.getValues())
                .build();
    }

    public static StorageDescriptor convertStorageDescriptor(
            org.apache.hadoop.hive.metastore.api.StorageDescriptor hmsStorageDescriptor) {
        String location = checkS3Uri(hmsStorageDescriptor.getLocation());
        return StorageDescriptor.builder()
                .location(location)
                .columns(convertFieldSchemaList(hmsStorageDescriptor.getCols()))
                .parameters(hmsStorageDescriptor.getParameters())
                .inputFormat(hmsStorageDescriptor.getInputFormat())
                .outputFormat(hmsStorageDescriptor.getOutputFormat())
                .serdeInfo(convertSerDeInfo(hmsStorageDescriptor.getSerdeInfo()))
                .build();
    }

    public static SerDeInfo convertSerDeInfo(org.apache.hadoop.hive.metastore.api.SerDeInfo hmsSerDeInfo) {
        // Glue federation requires a SerDe name which is not always present in HMS
        String serdeName = hmsSerDeInfo.getName() != null ? hmsSerDeInfo.getName() :hmsSerDeInfo.getSerializationLib();
        return SerDeInfo.builder()
                .name(serdeName)
                .serializationLibrary(hmsSerDeInfo.getSerializationLib())
                .parameters(hmsSerDeInfo.getParameters())
                .build();
    }

    public static List<Column> convertFieldSchemaList(List<FieldSchema> hmsFieldSchemaList) {
        List<Column> columnList = new ArrayList<>();
        for (FieldSchema fieldSchema : hmsFieldSchemaList) {
            columnList.add(convertFieldSchema(fieldSchema));
        }
        return columnList;
    }

    public static Column convertFieldSchema(FieldSchema hmsFieldSchema) {
        return Column.builder()
                .name(hmsFieldSchema.getName())
                .type(hmsFieldSchema.getType())
                .comment(hmsFieldSchema.getComment())
                .parameters(null) // Field not supported in the Hive object
                .build();
    }

    private static String checkS3Uri(String uri) {
        if (System.getenv(ENV_CONVERT_S3N).equals("true")) {
            return uri.replaceFirst("s3n://", "s3://");
        }
        return uri;
    }

}
