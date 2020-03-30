FROM java:8-jdk-alpine
COPY target/staf-1.0-SNAPSHOT-jar-with-dependencies.jar /usr/app/
COPY script.staf /usr/app
WORKDIR /usr/app
ENTRYPOINT ["java", "-jar", "staf-1.0-SNAPSHOT-jar-with-dependencies.jar"]