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
    private String email;

    public User (String userName, String email) {
        this.userName = userName;
        this.email = email;
    }
}