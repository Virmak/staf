#!/bin/bash
if [[ "$1" == '--all' ]]; then
  front=true
  back=true
elif [ "$1" == '--front-only' ]; then
  echo "front only"
  front=true
elif [ "$1" == '--back-only' ]; then
  echo "back only"
  back=true
else
  echo "Please specify one of the options [ --all, --front-only, --back-only]"
  exit 1
fi

mkdir -p ./build

if [ "$front" == true ]; then
  echo "Building frontend ..."
  cd staf-frontend && npm install && npm run build && cd ..
  rm -r build/dist
  cp -r staf-frontend/dist build/
fi

if [ "$back" == true ]; then
  echo "Building backend ..."
  mvn clean package
  cp staf-api/target/staf-api-0.0.1-SNAPSHOT.jar build/
fi

cp docker-compose.yml build/
cp staf-frontend/nginx.conf build/
cp staf-frontend/Dockerfile build/front.Dockerfile
cd build && zip -r build.zip . -x 'tests/*'