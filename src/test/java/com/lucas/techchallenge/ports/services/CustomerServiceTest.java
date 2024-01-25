package com.lucas.techchallenge.ports.services;

import com.lucas.techchallenge.domain.Customer;
import com.lucas.techchallenge.domain.dto.CustomerDto;
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
    @DisplayName("Create a customer")
    void shouldCreateCustomerTest() {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerName("Lucas");
        customerDto.setCpf("12345678910");

        when(customerRepository.save(any(Customer.class))).thenReturn(new Customer(customerDto));

        var customer = customerService.createCustomer(customerDto);

        assertEquals(customerDto.getCustomerName(), customer.getCustomerName());
        assertEquals(customerDto.getCpf(), customer.getCpf());
    }

    @Test
    @DisplayName("Get all customers")
    void shouldGetAllCustomersTest() {
        var customer = new Customer();
        customer.setId(1L);
        customer.setCustomerName("Lucas");
        customer.setCpf("12345678910");

        List<Customer> listOfCustomers = new ArrayList<>();
        listOfCustomers.add(customer);

        when(customerRepository.findAll()).thenReturn(listOfCustomers);

        var customers = customerService.getAllCustomers();

        assertNotNull(customers);
    }

    @Test
    @DisplayName("Find a customer by CPF")
    void shouldFindCustomerByCpfTest() {
        var customer = new Customer();
        customer.setId(1L);
        customer.setCustomerName("Lucas");
        customer.setCpf("12345678910");

        when(customerRepository.findByCpf(customer.getCpf())).thenReturn(customer);

        var customerFound= customerService.findByCpf(customer.getCpf());

        assertEquals(customer.getId(), customerFound.getId());
        assertEquals(customer.getCustomerName(), customerFound.getCustomerName());
        assertEquals(customer.getCpf(), customerFound.getCpf());
    }
}