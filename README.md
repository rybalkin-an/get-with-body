# GET Request with body

Example of endpoint that use GET Request with body

## Table of Contents

- [Installation](#installation)
- [Run the Application](#run-the-application)
- [Usage](#usage)
- [Tests](#tests)
- [Built With](#built-with)


### Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/rybalkin-an/get-with-body.git
    ```
2. **Install dependencies**
   ```bash
   ./gradlew build
   ```
   
### Run the Application

1. **If you have installed Java 17 and Gradle 8.3 on you PC:**

   ```bash
   ./gradlew build

   ./gradlew bootRun
   ```

If you don't have JAVA you can run application inside a Docker container:

1. **Build the Docker image using the Dockerfile and run the container:**

   ```bash
   docker build https://github.com/rybalkin-an/get-with-body.git -t image-name:latest
   docker run -p 8080:8080 image-name
   ```
The application will start on http://localhost:8080.

### Usage

```
Request method:	GET
Request URI:	http://localhost:8080/api/getExample
Proxy:			<none>
Request params:	<none>
Query params:	<none>
Form params:	<none>
Path params:	<none>
Headers:		Content-Type=text/plain
Cookies:		<none>
Multiparts:		<none>
Body:
someText
200
Content-Type: text/plain;charset=ISO-8859-1
Content-Length: 49

Response from GET request with body: someText
```
```
Request method:	POST
Request URI:	http://localhost:8080/api/postExample
Proxy:			<none>
Request params:	<none>
Query params:	<none>
Form params:	<none>
Path params:	<none>
Headers:		Content-Type=text/plain
Cookies:		<none>
Multiparts:		<none>
Body:			<none>
200
Content-Type: text/plain;charset=ISO-8859-1
Content-Length: 39

Response from POST request without body
```
### Tests
   ```bash
   ./gradlew test
   ```

### Built With
- Spring Boot - The web framework used
- Gradle - Build and dependency management tool
- RestAssured - Testing and validating REST services