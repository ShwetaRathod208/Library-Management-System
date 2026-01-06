package com.example.library_management_system.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library_management_system.entity.User;
import com.example.library_management_system.service.UserService;
import com.example.library_management_system.util.ResponseStructure;

@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/{addressId}")
    public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user,@PathVariable int addressId) {
        return userService.saveUser(user,addressId);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ResponseStructure<User>> findUserById(@PathVariable int userId) {
        return userService.findUserById(userId);
    }

    @PutMapping
    public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @GetMapping
    public ResponseEntity<ResponseStructure<List<User>>> findAllUsers() {
        return userService.findAllUsers();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ResponseStructure<String>> deleteUser(@PathVariable int userId) {
        return userService.deleteUser(userId);
    }
}

