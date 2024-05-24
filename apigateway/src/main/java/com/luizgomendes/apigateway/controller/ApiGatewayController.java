package com.luizgomendes.apigateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gateway")
public class ApiGatewayController {

    @GetMapping("/test")
    public ResponseEntity<String> getTest() {
        return ResponseEntity.ok("Gateway service is up");
    }
}
