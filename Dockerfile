FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/simple_project_spring_boot-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_pets.jar
EXPOSE 8010
ENTRYPOINT ["java", "-jar", "app_pets.jar"]