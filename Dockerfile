FROM amazoncorretto:17 AS build
WORKDIR /workspace

COPY gradlew .
COPY gradle/ gradle/
COPY build.gradle settings.gradle ./
RUN chmod +x gradlew && ./gradlew --no-daemon dependencies

COPY src/ src/
RUN ./gradlew --no-daemon clean bootJar

FROM amazoncorretto:17-alpine
WORKDIR /app
COPY --from=build /workspace/build/libs/*.jar app.jar
EXPOSE 80
ENTRYPOINT ["java","-jar","/app/app.jar"]
