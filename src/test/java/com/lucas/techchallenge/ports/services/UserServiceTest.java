package com.lucas.techchallenge.ports.services;

import com.lucas.techchallenge.domain.User;
import com.lucas.techchallenge.ports.repositories.UserRepository;
import com.lucas.techchallenge.services.UserServiceImpl;
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
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    @DisplayName("Create user")
    void createUser() {
        String userName = "Lucas";
        String userCpf = "12345678910";
        when(userRepository.save(any(User.class))).thenReturn(new User(userName, userCpf));

        var user = userService.createUser(userName, userCpf);

        assertEquals(userName, user.getUserName());
        assertEquals(userCpf, user.getCpf());
    }

    @Test
    @DisplayName("Get all users")
    void getAllUsers() {
        List<User> listOfUsers = new ArrayList<>();
        var user1 = new User("Lucas", "12345678910");
        var user2 = new User("Rafaela", "01987654321");

        when(userRepository.findAll()).thenReturn(listOfUsers);

        var users = userService.getAllUsers();

        assertNotNull(users);
    }

//    @Test
//    @DisplayName("Get user by CPF")
//    void getUserByCpf() {
//        var user = new User("Lucas", "12345678910");
//
//        when(userRepository.getUserByCpf(user.getCpf())).thenReturn(user);
//
//        var userFound = userService.getUserByCpf(user.getCpf());
//
//        assertEquals(user.getUserName(), userFound.getUserName());
//    }
}