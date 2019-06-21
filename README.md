
# bookmark-service4j

## Requirements

* AWS CLI already configured with Administrator permission
* [SAM CLI installed](https://github.com/awslabs/aws-sam-cli)
* [Docker installed](https://www.docker.com/community-edition)


## Initial setup & deployment

### Prepare the infrastructure

1. Create an S3 bucket
`aws s3 mb s3://bookmark-service-infra4j`

2. Run `make infrastructure` to deploy the infrastructure

### Deploy the application

1. Add a `git remote` and point it at the CodeCommit repo created by `make infrastructure`.

2. `git push` your changes and the pipeline should kick off a build

4. Run the following command:
```
aws lambda add-permission
--function-name [Lambda GET function name]
--source-arn [ARN]
--principal apigateway.amazonaws.com
--statement-id apigateway-beta-2
--action lambda:InvokeFunction
```

#### To find ARN:
**API Gateway** -> **APIs** -> **bookmark-service** -> **/bookmark/{title} GET** -> Copy ARN from **Method Request**

## Local development

### Invoking function locally through local API Gateway

```bash
make dev

or

sam local start-api
```

### Invoking function locally using a local sample payload

```bash
sam local invoke HelloWorldFunction --event event.json
```

### Running the Swagger editor

1. Start the service
```bash
make swagger-start
```

2. Point your browser to http://0.0.0.0:8080

3. When done, stop the service
```bash
make swagger-stop
```
