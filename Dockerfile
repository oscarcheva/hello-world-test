FROM openjdk:17-jdk-alpine
MAINTAINER oscarcheva
WORKDIR /app
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]