# Usa una imagen oficial de Java 17
FROM eclipse-temurin:17-jdk

# Crea y usa un directorio de trabajo
WORKDIR /app

# Copia el archivo .jar generado al contenedor
COPY target/*.jar app.jar

# Expón el puerto por defecto de Spring Boot
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
