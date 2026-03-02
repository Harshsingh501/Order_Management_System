package com.oms.Order_Management_System.controller;

import com.oms.Order_Management_System.model.Order;
import com.oms.Order_Management_System.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public String createOrder(@RequestBody Order order) {
        service.createOrder(order);
        return "Order Submitted Successfully";
    }

    @GetMapping
    public Collection<Order> getAllOrders() {
        return service.getAllOrders();
    }

    @GetMapping("/analytics/total")
    public double totalAmount() {
        return service.getTotalOrderAmount();
    }

    @GetMapping("/analytics/buy-sell")
    public Map<?, ?> buySell() {
        return service.getBuyVsSellCount();
    }

    @GetMapping("/analytics/top-customer")
    public String topCustomer() {
        return service.getTopCustomer();
    }

    @GetMapping("/analytics/group-status")
    public Map<?, ?> groupByStatus() {
        return service.groupByStatus();
    }
}
