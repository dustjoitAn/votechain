package com.votechain.controller;

import com.votechain.entity.User;
import com.votechain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userServiceImpl;

    @GetMapping("/users")
    private List<User> getAllUsers() {
        return userServiceImpl.getAllUsers();
    }

    @GetMapping("/users/{id}")
    private User getUser(@PathVariable("id") int id) {
        return userServiceImpl.getUserById(id);
    }

    @DeleteMapping("/users/{id}")
    private void deleteUser(@PathVariable("id") int id) {
        userServiceImpl.delete(id);
    }

    @PostMapping("/users")
    private long saveUser(@RequestBody User user) {
        userServiceImpl.saveOrUpdate(user);
        return user.getId();
    }
}
