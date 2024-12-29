FROM openjdk:17-jdk-slim as builder

WORKDIR /app

COPY . /app

RUN ./mvnw package -DskipTests

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=builder /app/target/jenkinsgreetingproject-*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]