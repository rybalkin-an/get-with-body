package com.github.rybalkin_an.get_with_body;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api")
@Tag(name = "Examples")
public class Controller {

    private final Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @Operation(summary = "GET example (with request body)")
    @GetMapping(value = "/getExample", produces = "text/plain")
    public String getExample(@RequestBody String requestBody) {
        return service.getExample(requestBody);
    }

    @Operation(summary = "POST example")
    @PostMapping(value = "/postExample", produces = "text/plain")
    public String postExample() {
        return service.postExample();
    }
}
