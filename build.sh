#!/bin/sh
mvn clean package
cd staf-frontend && ng build --prod && cd ..
mkdir -p build
cp -r staf-frontend/dist build/
cp staf-api/target/staf-api-0.0.1-SNAPSHOT.jar build/
cp docker-compose.yml build/
cp staf-frontend/nginx.conf build/
cp staf-frontend/Dockerfile build/front.Dockerfile