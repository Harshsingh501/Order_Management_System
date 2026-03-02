package com.oms.Order_Management_System.util;

import com.oms.Order_Management_System.model.Order;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;

@Component
public class OrderFileLogger {

    private static final String FILE_NAME = "order-logs.txt";

    public synchronized void log(Order order) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(order.getId() + "," +
                    order.getCustomerName() + "," +
                    order.getType() + "," +
                    order.getTotalAmount() + "," +
                    order.getStatus() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}