package com.github.rybalkin_an.get_with_body;

@org.springframework.stereotype.Service
public class Service {

    public String getExample(String requestBody) {
        return "Response from GET request with body: " + requestBody;
    }

    public String postExample() {
        return "Response from POST request without body";
    }
}
