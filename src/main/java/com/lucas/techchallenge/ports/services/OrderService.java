package com.lucas.techchallenge.ports.services;

import com.lucas.techchallenge.domain.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    Order createOrder();

    List<Order> getAllOrders();

    Order findOrderById(Long id);

    Order addProducttoOrder(Order order, Long product_id);

    Order checkoutOrder(Order order, String status);
}
