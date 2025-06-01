
FROM openjdk:17


COPY "./target/ProyectoCorte2-0.0.1-SNAPSHOT.jar" "app.jar"
EXPOSE 8022
ENTRYPOINT ["java", "-jar", "app.jar"]
