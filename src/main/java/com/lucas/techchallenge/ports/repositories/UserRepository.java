package com.lucas.techchallenge.ports.repositories;

import com.lucas.techchallenge.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    @Query("select u from users u where u.cpf = ?1")
//    User getUserByCpf(String cpf);
}