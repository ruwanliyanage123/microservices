package com.microservices.root.orderservice.util;

import com.microservices.root.orderservice.configuration.WebClientConfig;
import com.microservices.root.orderservice.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class InterServiceCommunicationHandler {

    @Value("${product.service.url}")
    private String productServiceUrl;

    private final WebClient webClient;

    @Autowired
    public InterServiceCommunicationHandler(WebClient webClient) {
        this.webClient = webClient;
    }

    public List<ProductDTO> interServiceCallByWebClient() {
        return webClient.get()
                .uri(productServiceUrl)
                .retrieve()
                .bodyToFlux(ProductDTO.class)
                .collectList()
                .block();
    }
}
