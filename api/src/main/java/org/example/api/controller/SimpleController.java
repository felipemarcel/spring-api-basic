package org.example.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping
public class SimpleController {

    @GetMapping("/api-version")
    public ResponseEntity<String> getApiVersion() {
        return ok("0.0.1");
    }
}
