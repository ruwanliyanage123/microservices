package com.microservices.root.orderservice.dto;

import java.util.List;

public class OrderDTO {
    private Long orderId;
    private String ownerName;
    private String address;
    private List<Long> productIds;
    public OrderDTO() {
    }
    public OrderDTO(Long orderId, String ownerName, String address, List<Long> productIds) {
        this.orderId = orderId;
        this.ownerName = ownerName;
        this.address = address;
        this.productIds = productIds;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;
    }
}