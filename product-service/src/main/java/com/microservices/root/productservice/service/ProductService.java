package com.microservices.root.productservice.service;

import com.microservices.root.productservice.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {
    public List<ProductDTO> getAllProducts(){
        return List.of(
            new ProductDTO(1L, "Product 1", "Description for product 1", BigDecimal.valueOf(100.00), 10),
            new ProductDTO(2L, "Product 2", "Description for product 2", BigDecimal.valueOf(200.00), 20),
            new ProductDTO(3L, "Product 3", "Description for product 3", BigDecimal.valueOf(300.00), 30)
        );
    }
}
