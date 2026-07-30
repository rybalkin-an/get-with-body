FROM amazoncorretto:17 AS build

WORKDIR /workspace

COPY gradlew .
COPY gradle gradle
COPY settings.gradle .
COPY build.gradle .

RUN chmod +x gradlew

RUN ./gradlew --no-daemon build -x test || true

COPY . .

RUN ./gradlew --no-daemon clean bootJar