FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} medicalFile-0.0.1-SNAPSHOT
ENTRYPOINT ["java","-jar","/medicalFile-0.0.1-SNAPSHOT"]