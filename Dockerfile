# Etapa 1: Build con Maven y Java 8
FROM maven:3.8.6-openjdk-8 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Runtime con Java 8
FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/ProyectoCorte2-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
