package com.lucas.techchallenge.ports.services;

import com.lucas.techchallenge.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User createUser(String username, String email);
    List<User> getAllUsers();
    //User getUserByCpf(String cpf);
}