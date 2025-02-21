FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8095

CMD [ "java", "-jar", "app.jar" ]