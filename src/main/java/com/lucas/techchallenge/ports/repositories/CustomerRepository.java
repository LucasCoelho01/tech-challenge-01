package com.lucas.techchallenge.ports.repositories;

import com.lucas.techchallenge.domain.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByCpf(String cpf);
}