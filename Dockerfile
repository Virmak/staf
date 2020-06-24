FROM java:8-jdk-alpine
COPY staf-api-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8081
ENTRYPOINT ["java","-jar","staf-api-0.0.1-SNAPSHOT.jar", "tests"]