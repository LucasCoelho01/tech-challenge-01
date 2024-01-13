package com.lucas.techchallenge.ports.services;

import com.lucas.techchallenge.domain.Customer;
import com.lucas.techchallenge.ports.repositories.CustomerRepository;
import com.lucas.techchallenge.services.CustomerServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Test
    @DisplayName("Create customer")
    void createCustomer() {
        String customerName = "Lucas";
        String customerCpf = "12345678910";
        when(customerRepository.save(any(Customer.class))).thenReturn(new Customer(customerName, customerCpf));

        var customer = customerService.createCustomer(customerName, customerCpf);

        assertEquals(customerName, customer.getCustomerName());
        assertEquals(customerCpf, customer.getCpf());
    }

    @Test
    @DisplayName("Get all customers")
    void getAllCustomers() {
        List<Customer> listOfCustomers = new ArrayList<>();
        var customer1 = new Customer("Lucas", "12345678910");
        var customer2 = new Customer("Rafaela", "01987654321");

        when(customerRepository.findAll()).thenReturn(listOfCustomers);

        var customers = customerService.getAllCustomers();

        assertNotNull(customers);
    }
}