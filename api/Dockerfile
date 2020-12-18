FROM openjdk:13-alpine

RUN apk add --update bash && rm -rf /var/cache/apk/*

USER root
RUN  apk update && apk upgrade && apk add netcat-openbsd
RUN mkdir -p /usr/local/service
ADD build/libs/api-0.0.1-SNAPSHOT.jar /usr/local/api-app/api-0.0.1-SNAPSHOT.jar

ADD ./run.sh /root/
RUN chmod +x /root/run.sh
RUN ls -ltr /usr/local/api-app
RUN ls -ltr /root
CMD sh /root/run.sh