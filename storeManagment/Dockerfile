FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} storeManagment-0.0.1-SNAPSHOT
ENTRYPOINT ["java","-jar","/storeManagment-0.0.1-SNAPSHOT"]