package com.lucas.techchallenge.controllers;

import com.lucas.techchallenge.domain.Customer;
import com.lucas.techchallenge.domain.Product;
import com.lucas.techchallenge.domain.dto.CustomerDto;
import com.lucas.techchallenge.domain.dto.ProductDto;
import com.lucas.techchallenge.ports.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    public ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto) {
        Product product = productService.createProduct(productDto);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<Product>> findProductById(@PathVariable Long id) {
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

//    @PutMapping()
//    public ResponseEntity<Optional<Product>> editProduct(@RequestBody ProductDto productDto) {
//
//    }
}
