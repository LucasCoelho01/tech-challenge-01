package com.lucas.techchallenge.ports.repositories;

import com.lucas.techchallenge.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}