FROM openjdk:17-alpine
ARG JAR_FILE=/target/*.jar
COPY ${JAR_FILE} apps-2.jar
ENTRYPOINT ["java","-jar","/apps-2.jar"]