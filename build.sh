#!/bin/sh
mvn clean package
cd staf-frontend && npm install && npm run build && cd ..
mkdir -p build
rm -r build/dist
cp -r staf-frontend/dist build/
cp staf-api/target/staf-api-0.0.1-SNAPSHOT.jar build/
cp docker-compose.yml build/
cp staf-frontend/nginx.conf build/
cp staf-frontend/Dockerfile build/front.Dockerfile
cd build && zip -r build.zip . -x tests/**/*.png tests/stark-erp-ui-test/results/*.json