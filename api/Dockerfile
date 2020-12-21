FROM openjdk:13-alpine as build-artifact

WORKDIR /workspace/app

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src

RUN sh gradlew bootJar

FROM openjdk:13-alpine

RUN apk add --update bash && rm -rf /var/cache/apk/*

RUN  apk update && apk upgrade && apk add netcat-openbsd
RUN mkdir -p /usr/local/service

COPY --from=build-artifact /workspace/app/build/libs/api-0.0.1-SNAPSHOT.jar /usr/local/api-app/

CMD java -Dserver.port=$SERVER_PORT -jar /usr/local/api-app/api-0.0.1-SNAPSHOT.jar