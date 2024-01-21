package com.lucas.techchallenge.services;

import com.lucas.techchallenge.domain.Order;
import com.lucas.techchallenge.ports.repositories.OrderRepository;
import com.lucas.techchallenge.ports.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Override
    public Order createOrder() {
        return orderRepository.save(new Order());
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
