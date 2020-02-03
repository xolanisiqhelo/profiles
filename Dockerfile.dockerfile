FROM openjdk:8-jdk-alpine


VOLUME /tmp
ARG JAR_FILE
COPY target/profiles-0.0.1-SNAPSHOT.jar service-server.jar
EXPOSE 8080

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/service-server.jar"]