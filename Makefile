dev:
	sam local start-api

infrastructure:
	aws s3 cp ./swagger/bookmark-new.yaml s3://bookmark-service-infra4j
	(cd infra && ./deploy.sh)

swagger-start:
	docker run --name swagger-editor -d -p 8080:8080 swaggerapi/swagger-editor

swagger-stop:
	docker stop swagger-editor
