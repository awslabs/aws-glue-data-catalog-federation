plugins {
    java
}

group = "com.amazonaws.glue.federation"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":glue-catalog-federation-api"))

    implementation("software.amazon.awssdk:aws-core:2.17.157") {
        exclude(group = "*", module = "*")
    }
    implementation("software.amazon.awssdk:sdk-core:2.17.157") {
        exclude(group = "*", module = "*")
    }
    implementation("software.amazon.awssdk:utils:2.17.157") {
        exclude(group = "*", module = "*")
    }

    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.13.2")
    implementation("org.apache.hive:hive-standalone-metastore:3.1.2")
    implementation("com.amazonaws:aws-lambda-java-core:1.2.1")
    implementation("com.amazonaws:aws-lambda-java-events:3.11.0")
}
