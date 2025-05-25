package com.microservices.root.orderservice.controller;

import com.microservices.root.orderservice.dto.OrderDTO;
import com.microservices.root.orderservice.orderservice.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping(consumes = "application/json", produces ="application/json")
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO) {
        final OrderDTO dto = orderService.getFinalizeOrder(orderDTO);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
