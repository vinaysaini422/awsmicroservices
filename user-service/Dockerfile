FROM openjdk:latest

ADD target/userserviceapp-1.0-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]

EXPOSE 8080