# GET Request with Body

This project demonstrates a **GET request with a request body** in Spring Boot.

⚠️ **Important note:**  
While Spring Boot (and HTTP in general) technically allows GET requests with a body, **web browsers do not**.  
Swagger UI uses the browser `fetch()` API, which **forbids GET/HEAD requests with a body**.  
As a result, **Swagger UI cannot execute this endpoint**, even though the backend supports it.

Use **curl or other non-browser HTTP clients** to test the GET-with-body endpoint.

---

## Table of Contents

- [Installation](#installation)
- [Run the Application](#run-the-application)
- [Usage (curl)](#usage-curl)
- [Tests](#tests)
- [Built With](#built-with)

---

## Installation

### Clone and build locally

```bash
git clone https://github.com/rybalkin-an/get-with-body.git
cd get-with-body
./gradlew build
```

---

## Run the Application

### Option 1: Run locally (Java 17 required)

```bash
./gradlew bootRun
```

Application starts at:

```
http://localhost
```

---

### Option 2: Run with Docker (build locally)

```bash
docker build -t get-with-body:latest .
docker run --rm -p 80:80 get-with-body:latest
```

Application starts at:

```
http://localhost
```

---

### Option 3: Run using prebuilt image from GHCR

You can pull the prebuilt image directly from GitHub Container Registry:

```bash
docker pull ghcr.io/rybalkin-an/get-with-body:latest
```

Run it:

```bash
docker run --rm -p 80:80 ghcr.io/rybalkin-an/get-with-body:latest
```

---

## Usage (curl)

### GET request with body (NOT supported by browsers / Swagger UI)

```bash
curl -X GET \
  http://localhost/api/getExample \
  -H "Content-Type: text/plain" \
  --data-raw "someText"
```

**Response:**
```text
Response from GET request with body: someText
```

---

### POST request without body

```bash
curl -X POST \
  http://localhost/api/postExample
```

**Response:**
```text
Response from POST request without body
```

---

## Swagger UI limitation

Swagger UI runs in the browser and uses `window.fetch()` internally.

Browsers enforce this rule:

> ❌ **GET / HEAD requests cannot have a request body**

Because of this:
- Swagger UI will either show the input as a query parameter **or**
- Fail with:
  ```
  TypeError: Failed to execute 'fetch' on 'Window':
  Request with GET/HEAD method cannot have body
  ```

This is a **browser restriction**, not a Spring Boot or Swagger bug.

---

## Tests

```bash
./gradlew test
```

---

## Built With

- **Spring Boot** – Web framework
- **Gradle** – Build and dependency management
- **springdoc-openapi** – OpenAPI / Swagger UI integration
- **RestAssured** – REST API testing
