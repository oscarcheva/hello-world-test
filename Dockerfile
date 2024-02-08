FROM openjdk:8-jdk-alpine
MAINTAINER oscarcheva
COPY target/hello-world-0.0.1.jar hello-world-0.0.1.jar
ENTRYPOINT ["java","-jar","/message-server-1.0.0.jar"]