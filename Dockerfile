FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Cria usuário não-root
RUN addgroup -S spring && adduser -S spring -G spring
USER spring

COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]