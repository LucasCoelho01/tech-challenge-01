package com.lucas.techchallenge.domain;

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

    public Customer (String customerName, String cpf) {
        this.customerName = customerName;
        this.cpf = cpf;
    }
}