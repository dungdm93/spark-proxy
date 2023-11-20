ARG BASE_IMAGE=apache/spark:3.5.0

FROM maven:3.9-eclipse-temurin-8 AS builder
WORKDIR /app

COPY . /app/
RUN --mount=type=cache,target=/root/.m2 \
    --mount=type=cache,target=/root/.sbt \
    mvn clean package

FROM $BASE_IMAGE

COPY --from=builder /app/*/target/*.jar $SPARK_HOME/jars/
COPY --chown=spark:spark ./deploy/scripts/* $SPARK_HOME/sbin/
