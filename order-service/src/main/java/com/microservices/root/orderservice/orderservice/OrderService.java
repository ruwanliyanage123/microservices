package com.microservices.root.orderservice.orderservice;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.root.orderservice.dto.OrderDTO;
import com.microservices.root.orderservice.dto.ProductDTO;
import com.microservices.root.orderservice.util.InterServiceCommunicationHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @RabbitListener(queues = "ruwan")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
    }
}
