#!/bin/sh
mvn clean package
scp staf-api/target/staf-api-0.0.1-SNAPSHOT.jar docker@192.168.1.203:/home/docker/staf-framework
