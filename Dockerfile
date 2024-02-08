FROM openjdk:17-jdk-alpine
MAINTAINER oscarcheva
COPY ./target/hello-world-0.0.1.jar /app
ENTRYPOINT ["java","-jar","/hello-world-0.0.1.jar"]