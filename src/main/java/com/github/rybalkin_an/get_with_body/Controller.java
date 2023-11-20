package com.github.rybalkin_an.get_with_body;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {

    private final Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping(value = "/getExample", produces = "text/plain")
    public String getExample(@RequestBody String requestBody) {
        return service.getExample(requestBody);
    }

    @PostMapping(value = "/postExample", produces = "text/plain")
    public String postExample() {
        return service.postExample();
    }
}
