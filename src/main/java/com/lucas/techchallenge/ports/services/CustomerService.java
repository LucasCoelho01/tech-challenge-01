package com.lucas.techchallenge.ports.services;

import com.lucas.techchallenge.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    Customer createCustomer(String username, String email);
    List<Customer> getAllCustomers();

    Customer findByCpf(String cpf);
}