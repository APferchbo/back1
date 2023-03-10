FROM amazoncorretto:8-alpine-jdk

maintainer ferchbo

COPY target/fhbo-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
