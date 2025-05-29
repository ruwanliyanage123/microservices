package com.microservices.root.orderservice.orderservice;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.root.orderservice.dto.OrderDTO;
import com.microservices.root.orderservice.dto.ProductDTO;
import com.microservices.root.orderservice.util.InterServiceCommunicationHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Value("${product.service.url}")
    private String productServiceURL;
    @Autowired
    private InterServiceCommunicationHandler interServiceCommunicationHandler;

    public OrderDTO getFinalizeOrder(OrderDTO orderDTO) {
        final ResponseEntity<List<ProductDTO>> response = interServiceCommunicationHandler.interServiceCallByRestTemplate(productServiceURL);
        if (response.getStatusCode().value() == 200) {
            List<ProductDTO> productDTOList = response.getBody();
            if (isAllOrderItemExists(orderDTO, productDTOList)) {
                return orderDTO;
            }
            return null;
        }
        return null;
    }

    private boolean isAllOrderItemExists(OrderDTO orderDTO, List<ProductDTO> productDTOList) {
        List<Long> productIds = orderDTO.getProductIds();
        Set<Long> availableProductIds = productDTOList.stream()
                .map(ProductDTO::getId)
                .collect(Collectors.toSet());
        return availableProductIds.containsAll(productIds);
    }
}
