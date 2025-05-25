package com.microservices.root.orderservice.orderservice;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.root.orderservice.dto.OrderDTO;
import com.microservices.root.orderservice.dto.ProductDTO;
import com.microservices.root.orderservice.util.InterServiceCommunicationHandler;
import org.springframework.beans.factory.annotation.Value;
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
    private final ObjectMapper objectMapper = new ObjectMapper();
    public OrderDTO getFinalizeOrder(OrderDTO orderDTO){
        try {
            final HttpResponse<String> response = InterServiceCommunicationHandler.interServiceCall(productServiceURL);
            if(response.statusCode() == 200){
                List<ProductDTO> productDTOList = objectMapper.readValue(response.body(), new TypeReference<>() {});
                if(isAllOrderItemExists(orderDTO, productDTOList)){
                    return orderDTO;
                }
                return null;
            }
            return null;
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isAllOrderItemExists(OrderDTO orderDTO, List<ProductDTO> productDTOList){
        List<Long> productIds = orderDTO.getProductIds();
        Set<Long> availableProductIds = productDTOList.stream()
                .map(ProductDTO::getId)
                .collect(Collectors.toSet());
        return availableProductIds.containsAll(productIds);
    }
}
