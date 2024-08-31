# Etapa de construcción
FROM ubuntu:latest AS build
RUN apt-get update && apt-get install openjdk-22-jdk -y
WORKDIR /app
COPY . .
RUN ./gradlew bootJar --no-daemon

# Etapa de producción
FROM openjdk:21-jre-slim
WORKDIR /app
EXPOSE 8080
COPY --from=build /app/build/libs/how-much-pay-api-0.0.1.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
