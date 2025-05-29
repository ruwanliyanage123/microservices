package com.microservices.root.orderservice.orderservice;

import com.microservices.root.orderservice.dto.OrderDTO;
import com.microservices.root.orderservice.dto.ProductDTO;
import com.microservices.root.orderservice.util.InterServiceCommunicationHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private InterServiceCommunicationHandler interServiceCommunicationHandler;

    public OrderDTO getFinalizeOrder(OrderDTO orderDTO) {
        final List<ProductDTO> productDTOList = interServiceCommunicationHandler.interServiceCallByWebClient();
        if (!Objects.isNull(productDTOList) && !productDTOList.isEmpty()) {
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
