FROM amazoncorretto:17

WORKDIR /app

COPY build.gradle .
COPY settings.gradle .
COPY gradlew .
COPY gradle/ ./gradle/

COPY . .

RUN chmod +x gradlew && ./gradlew build
EXPOSE 8080
CMD ["java", "-jar", "build/libs/get-with-body-0.0.1-SNAPSHOT.jar"]
