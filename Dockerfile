FROM openjdk:8-alpine

COPY build/libs/test-vertx-1.jar /test.jar

CMD exec java -jar /test.jar
