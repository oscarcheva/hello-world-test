FROM openjdk:latest AS build
COPY --from=target/hello-world-0.0.1.jar app.jar .
ENTRYPOINT ["java","-jar","/app.jar"]