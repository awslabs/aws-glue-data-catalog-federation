## AWS Glue Data Catalog Federation - Hive Metastore

The source code includes a basic implementation of an AWS Glue Data Catalog federation connector for the Hive Metastore.

The implementation runs on an [AWS Lambda](https://docs.aws.amazon.com/lambda/latest/dg/welcome.html) function that
can receive requests from the AWS Glue Data Catalog and fulfill them with calls to the Hive Metastore. An
[AWS Serverless Applicaton Model](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/what-is-sam.html)
template is provided and can be used to deploy the Lambda function and all other AWS resources needed to start creating
federated resources in the AWS Glue Data Catalog.

### SAM Resources Overview

- **API Gateway HTTP API:** Represents the endpoint of the federation connector deployed in AWS Lambda. This
gateway serves as a proxy that routes all AWS Glue Data Catalog requests to the AWS Lambda function and routes the
function's responses back to the Data Catalog.
  - This is one of the required parameters for establishing a AWS Glue Data Catalog federation connection.

- **AWS Lambda function:** Runs the service layer that allows federation between AWS Glue Data Catalog and Hive
Metastore. It handles making the necessary calls to a connected Hive Metastore in order to provide the metadata being
polled by AWS Glue Data Catalog requests.

- **AWS IAM role:** Contains a custom policy allowing the AWS Glue Data Catalog to make invocations on the API Gateway
HTTP API endpoint. By default, this role can only be assumed by the AWS Glue service principal. Additionally,
this role enforces [confused deputy prevention](https://docs.aws.amazon.com/IAM/latest/UserGuide/confused-deputy.html)
by restricting its use to the single AWS Glue connection this SAM application creates and the owning account.
  - This is one of the required parameters for establishing a AWS Glue Data Catalog federation connection.

- **AWS Glue connection:** Used by AWS Glue Data Catalog federated resources as a reference to the Hive Metastore from
which metadata can be sourced. It will be auto-created using the API Gateway HTTP API endpoint and AWS IAM role created
by the SAM application.
  