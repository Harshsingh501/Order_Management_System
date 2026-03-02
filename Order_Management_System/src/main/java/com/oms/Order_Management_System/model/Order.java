package com.oms.Order_Management_System.model;

import java.time.LocalDateTime;

public class Order {

    private Long id;
    private String customerName;
    private OrderType type;
    private double price;
    private int quantity;
    private OrderStatus status;
    private LocalDateTime createdAt;

    public Order() {}

    public Order(Long id, String customerName, OrderType type, double price, int quantity) {
        this.id = id;
        this.customerName = customerName;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.status = OrderStatus.NEW;
        this.createdAt = LocalDateTime.now();
    }

    public double getTotalAmount() {
        return price * quantity;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public String getCustomerName() { return customerName; }
    public OrderType getType() { return type; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public OrderStatus getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setStatus(OrderStatus status) { this.status = status; }
}