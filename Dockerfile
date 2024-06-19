FROM openjdk:17-jdk-alpine
WORKDIR app/
COPY . .
ENTRYPOINT ["java", "-jar", "/app/webF1-1.jar"]
