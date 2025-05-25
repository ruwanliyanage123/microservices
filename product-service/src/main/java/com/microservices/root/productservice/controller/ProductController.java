package com.microservices.root.productservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
class ProductController {

    @GetMapping()
    public ResponseEntity<?> getProducts() {
        return null;
    }
}
