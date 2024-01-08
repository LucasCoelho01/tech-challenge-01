package com.lucas.techchallenge.services;

import com.lucas.techchallenge.domain.User;
import com.lucas.techchallenge.ports.repositories.UserRepository;
import com.lucas.techchallenge.ports.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;
    List<User> users = new ArrayList<User>();
    @Override
    public User createUser(String userName, String email) {
        User user = new User(userName, email);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

//    @Override
//    public User getUserByCpf(String cpf) {
//        return userRepository.getUserByCpf(cpf);
//    }
}