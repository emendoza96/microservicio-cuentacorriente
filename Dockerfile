FROM openjdk:17-jdk-alpine
LABEL maintainer="emendoza96"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ms-currentaccount.jar
ENTRYPOINT ["java", "-jar", "ms-currentaccount.jar"]
EXPOSE 8080
