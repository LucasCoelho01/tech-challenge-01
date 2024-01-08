package com.lucas.techchallenge.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String cpf;

    public User() {}

    public User (String userName, String cpf) {
        this.userName = userName;
        this.cpf = cpf;
    }

//    public User (Long id, String userName, String cpf) {
//        this.id = id;
//        this.userName = userName;
//        this.cpf = cpf;
//    }
}