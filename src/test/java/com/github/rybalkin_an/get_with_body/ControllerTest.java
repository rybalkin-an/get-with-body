package com.github.rybalkin_an.get_with_body;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.http.ContentType.TEXT;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
public class ControllerTest {

    @Autowired
    private Controller controller;

    @BeforeEach
    public void setUp() {
        RestAssuredMockMvc.standaloneSetup(controller);
    }

    @Test
    public void testGetExample() {
        String requestBody = "someText";

        given().contentType(TEXT).body(requestBody)
                .when().get("/api/getExample")
                .then().statusCode(SC_OK)
                .and().body(equalTo("Response from GET request with body: " + requestBody));
    }

    @Test
    public void testPostExample() {
        given().contentType(TEXT)
                .when().post("/api/postExample")
                .then().statusCode(SC_OK)
                .and().body(equalTo("Response from POST request without body"));
    }
}
