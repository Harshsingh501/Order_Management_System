package com.oms.Order_Management_System.service;

import com.oms.Order_Management_System.exception.InvalidOrderException;
import com.oms.Order_Management_System.model.*;
import com.oms.Order_Management_System.repository.OrderRepository;
import com.oms.Order_Management_System.util.OrderFileLogger;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository repository;
    private final OrderFileLogger fileLogger;
    private final ExecutorService executor = Executors.newFixedThreadPool(5);

    public OrderService(OrderRepository repository, OrderFileLogger fileLogger) {
        this.repository = repository;
        this.fileLogger = fileLogger;
    }

    public void createOrder(Order order) {

        if (order.getQuantity() <= 0 || order.getPrice() <= 0) {
            throw new InvalidOrderException("Invalid order details");
        }

        repository.save(order);

        executor.submit(() -> processOrder(order));
    }

    private void processOrder(Order order) {
        try {
            order.setStatus(OrderStatus.PROCESSING);
            Thread.sleep(1000); // simulate processing
            order.setStatus(OrderStatus.COMPLETED);
        } catch (Exception e) {
            order.setStatus(OrderStatus.FAILED);
        }
        fileLogger.log(order);
    }

    public Collection<Order> getAllOrders() {
        return repository.findAll();
    }

    // ----------- Analytics ------------

    public double getTotalOrderAmount() {
        return repository.findAll()
                .stream()
                .mapToDouble(Order::getTotalAmount)
                .sum();
    }

    public Map<OrderType, Long> getBuyVsSellCount() {
        return repository.findAll()
                .stream()
                .collect(Collectors.groupingBy(Order::getType, Collectors.counting()));
    }

    public String getTopCustomer() {
        return repository.findAll()
                .stream()
                .collect(Collectors.groupingBy(
                        Order::getCustomerName,
                        Collectors.summingDouble(Order::getTotalAmount)))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No Orders");
    }

    public Map<OrderStatus, List<Order>> groupByStatus() {
        return repository.findAll()
                .stream()
                .collect(Collectors.groupingBy(Order::getStatus));
    }
}