package org.example.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class SimpleController {

    @GetMapping("/api-version")
    public String getApiVersion() {
        return "0.0.1";
    }
}
