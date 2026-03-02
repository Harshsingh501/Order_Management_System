package com.oms.Order_Management_System.repository;

import com.oms.Order_Management_System.model.Order;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class OrderRepository {

    private final Map<Long, Order> orderMap = new ConcurrentHashMap<>();

    public void save(Order order) {
        orderMap.put(order.getId(), order);
    }

    public Order findById(Long id) {
        return orderMap.get(id);
    }

    public Collection<Order> findAll() {
        return orderMap.values();
    }
}