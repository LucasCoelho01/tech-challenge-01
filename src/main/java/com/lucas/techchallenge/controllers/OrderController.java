package com.lucas.techchallenge.controllers;

import com.lucas.techchallenge.domain.Category;
import com.lucas.techchallenge.domain.Order;
import com.lucas.techchallenge.domain.dto.CategoryDto;
import com.lucas.techchallenge.domain.dto.OrderDto;
import com.lucas.techchallenge.ports.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @PostMapping
    public ResponseEntity<Order> createOrder() {
        Order order = orderService.createOrder();
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }
}
