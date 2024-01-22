package com.lucas.techchallenge.services;

import com.lucas.techchallenge.domain.Order;
import com.lucas.techchallenge.domain.Product;
import com.lucas.techchallenge.ports.repositories.OrderRepository;
import com.lucas.techchallenge.ports.services.OrderService;
import com.lucas.techchallenge.ports.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Override
    public Order createOrder() {
        return orderRepository.save(new Order());
    }

    @Autowired
    private ProductService productService;
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order findOrderById(Long id) {
        Optional<Order> order = orderRepository.findById(id);

        return order.orElse(new Order());
    }

    @Override
    public Order addProducttoOrder(Order order, Long product_id) {
        Product product = productService.findById(product_id);

        order.getProducts().add(product);

        return orderRepository.save(order);
    }
}
