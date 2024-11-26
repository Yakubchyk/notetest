FROM maven:3.8.5-openjdk-17 as build
WORKDIR /app
COPY pom.xml .
#RUN mvn dependency:go-offline
COPY src/ ./src/
RUN mvn clean package -DskipTests=true

FROM openjdk:17-jdk-slim as run
RUN mkdir /app
COPY --from=build /app/target/*.jar /app/app.jar
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]