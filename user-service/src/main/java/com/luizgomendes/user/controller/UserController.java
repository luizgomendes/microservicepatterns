package com.luizgomendes.user.controller;

import com.luizgomendes.user.model.User;
import com.luizgomendes.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public Iterable<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/save")
    public void saveUser(@RequestBody User user) {
        if(user.getId() != null && user.getId().isEmpty()) {
            user.setId(null);
        }
        userService.saveUser(user);
    }
}
