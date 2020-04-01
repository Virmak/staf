FROM java:8-jdk-alpine
COPY staf-api/target/staf-api-0.0.1-SNAPSHOT.jar /usr/app/
# COPY script.staf /usr/app
WORKDIR /usr/app
ENTRYPOINT ["java", "-jar", "staf-api-0.0.1-SNAPSHOT.jar"]