package com.microservices.root.orderservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/order")
public class OrderController {

    @GetMapping()
    public String createOrder() {
        return null;
    }
}
