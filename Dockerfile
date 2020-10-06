FROM adoptopenjdk/openjdk11:alpine-jre

EXPOSE 8090

RUN mkdir -p /stack/config
COPY ./target/stack-0.0.1-SNAPSHOT.jar /stack
COPY ./src/main/resources/application.properties /stack

ENTRYPOINT ["java", "-Xms1g", "-Xmx4g","-Dspring.config.location=./stack/application.properties", "-jar", "/stack/stack-0.0.1-SNAPSHOT.jar"]
 