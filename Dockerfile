# Base image
FROM eclipse-temurin:17-alpine
RUN mkdir -p logs/spring/logback
WORKDIR /app
COPY api/build/libs/api-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Dfile.encoding=UTF-8", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]
