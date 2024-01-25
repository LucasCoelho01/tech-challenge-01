package com.lucas.techchallenge.domain;

import com.lucas.techchallenge.domain.dto.CustomerDto;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String cpf;

    public Customer() {}

    public Customer (CustomerDto customerDto) {
        this.customerName = customerDto.getCustomerName();
        this.cpf = customerDto.getCpf();
    }
}