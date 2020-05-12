FROM gcr.io/distroless/java
COPY --from=build /home/app/staf-api/target/staf-api-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8080
ENTRYPOINT ["java","-jar","staf-api-0.0.1-SNAPSHOT.jar", "tests"]