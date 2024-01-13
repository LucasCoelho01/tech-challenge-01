package com.lucas.techchallenge.controllers;

import com.lucas.techchallenge.domain.Customer;
import com.lucas.techchallenge.domain.dto.CustomerDto;
import com.lucas.techchallenge.ports.services.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    public CustomerService customerService;
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDto customerDto) {
        Customer customer = customerService.createCustomer(customerDto.getCustomerName(), customerDto.getCpf());
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Customer> findCustomerByCpf(@PathVariable String cpf) {
        return new ResponseEntity<>(customerService.findByCpf(cpf), HttpStatus.OK);
    }
}