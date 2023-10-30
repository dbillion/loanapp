FROM eclipse-temurin:11.0.14.1_1-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT java ${JAVA_OPTS} -jar /app.jar
