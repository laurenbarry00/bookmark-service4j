#!/usr/bin/env bash

# Configuration
CodeCommitRepoName=bookmark-service4j
StackName=bookmark-service-infra4j
BucketName=bookmark-service-infra4j

# Package and deploy
aws cloudformation package \
--template-file service.yaml \
--s3-bucket ${BucketName} \
--output-template-file packaged-${StackName}-template.yaml

aws cloudformation deploy \
--stack-name ${StackName} \
--template-file packaged-${StackName}-template.yaml \
--parameter-overrides \
"CodeCommitRepoName=${CodeCommitRepoName}" \
--s3-bucket ${BucketName} \
--capabilities CAPABILITY_IAM
