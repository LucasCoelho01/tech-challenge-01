package com.lucas.techchallenge.controllers;

import com.lucas.techchallenge.domain.User;
import com.lucas.techchallenge.domain.dto.UserDto;
import com.lucas.techchallenge.ports.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    public UserService userService;
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto) {
        User user = userService.createUser(userDto.getUserName(), userDto.getCpf());
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<User> findUserByCpf(@PathVariable String cpf) {
        return new ResponseEntity<>(userService.findByCpf(cpf), HttpStatus.OK);
    }
}