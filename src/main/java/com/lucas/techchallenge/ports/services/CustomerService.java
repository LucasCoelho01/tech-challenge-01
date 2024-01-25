package com.lucas.techchallenge.ports.services;

import com.lucas.techchallenge.domain.Customer;
import com.lucas.techchallenge.domain.dto.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    Customer createCustomer(CustomerDto customerDto);
    List<Customer> getAllCustomers();

    Customer findByCpf(String cpf);
}