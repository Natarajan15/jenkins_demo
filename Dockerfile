#FROM ubuntu:latest
#LABEL authors="USER"
#
#ENTRYPOINT ["top", "-b"]


#FROM openjdk:21
FROM eclipse-temurin:21-jdk

WORKDIR /apps

COPY target/demo_docker-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8081

CMD ["java", "-jar", "app.jar"]