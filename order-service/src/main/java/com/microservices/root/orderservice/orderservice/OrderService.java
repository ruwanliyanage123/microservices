package com.microservices.root.orderservice.orderservice;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @RabbitListener(queues = "ruwan")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
    }
}
