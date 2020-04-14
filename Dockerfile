FROM maven:3.5-jdk-8 AS build
COPY . /home/app/
RUN mvn -f /home/app/pom.xml clean package

FROM gcr.io/distroless/java
COPY --from=build /home/app/staf-api/target/staf-api-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8080
ENTRYPOINT ["java","-jar","staf-api-0.0.1-SNAPSHOT.jar", "tests"]