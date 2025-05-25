package com.microservices.root.productservice.controller;

import com.microservices.root.productservice.dto.ProductDTO;
import com.microservices.root.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(value = "/send/{message}")
    public String sendMessage(@PathVariable("message") String message){
        productService.sendMessage(message);
        return message;
    }
}
