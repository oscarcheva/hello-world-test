FROM openjdk:17-jdk-alpine
MAINTAINER oscarcheva
ADD target/hello-world-0.0.1.jar hello-world-0.0.1.jar
ENTRYPOINT ["java","-jar","/hello-world-0.0.1.jar"]