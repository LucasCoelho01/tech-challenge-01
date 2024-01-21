package com.lucas.techchallenge.services;

import com.lucas.techchallenge.domain.Customer;
import com.lucas.techchallenge.domain.dto.CustomerDto;
import com.lucas.techchallenge.ports.repositories.CustomerRepository;
import com.lucas.techchallenge.ports.services.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    public CustomerRepository customerRepository;
    @Override
    public Customer createCustomer(CustomerDto customerDto) {
        Customer customer = new Customer(customerDto);
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findByCpf(String cpf) {
        return customerRepository.findByCpf(cpf);
    }
}