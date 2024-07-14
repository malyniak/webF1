FROM openjdk:19-jdk-alpine
WORKDIR app/
COPY build/libs/webF1-1.jar /app/
ENTRYPOINT ["java", "-jar", "/app/webF1-1.jar"]
