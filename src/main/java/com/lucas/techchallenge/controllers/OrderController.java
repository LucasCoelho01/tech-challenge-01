package com.lucas.techchallenge.controllers;

import com.lucas.techchallenge.domain.Category;
import com.lucas.techchallenge.domain.Order;
import com.lucas.techchallenge.domain.Product;
import com.lucas.techchallenge.domain.dto.CategoryDto;
import com.lucas.techchallenge.domain.dto.OrderDto;
import com.lucas.techchallenge.ports.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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

    @GetMapping("/id/{id}")
    public ResponseEntity<?> findOrderById(@PathVariable Long id) {
        Order order = orderService.findOrderById(id);

        if (Objects.isNull(order.getId())) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping("/add/{order_id}/{product_id}")
    public ResponseEntity<?> addProducttoOrder(@PathVariable Long order_id, @PathVariable Long product_id) {
        Order orderFound = orderService.findOrderById(order_id);

        if (Objects.isNull(orderFound.getId())) {
            return new ResponseEntity<>("Order not found", HttpStatus.NO_CONTENT);
        }

        Order orderUpdated = orderService.addProducttoOrder(orderFound, product_id);

        return new ResponseEntity<>(orderUpdated, HttpStatus.OK);
    }

    @PutMapping("/checkout/{order_id}")
    public ResponseEntity<?> checkputOrder(@PathVariable Long order_id) {
        Order orderFound = orderService.findOrderById(order_id);

        if (Objects.isNull(orderFound.getId())) {
            return new ResponseEntity<>("Order not found", HttpStatus.NO_CONTENT);
        }

        Order orderUpdated = orderService.checkoutOrder(orderFound, "Pedido enviado");

        return new ResponseEntity<>(orderUpdated, HttpStatus.OK);
    }
}
