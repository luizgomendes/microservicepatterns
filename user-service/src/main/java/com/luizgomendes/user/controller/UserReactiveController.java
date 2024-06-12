package com.luizgomendes.user.controller;

import com.luizgomendes.user.model.User;
import com.luizgomendes.user.service.UserReactiveService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/user/reactive")
public class UserReactiveController {

    private final UserReactiveService userReactiveService;

    public UserReactiveController(UserReactiveService userReactiveService) {
        this.userReactiveService = userReactiveService;
    }


    @GetMapping("/list")
    public Flux<User> getAllUsers() {
        return userReactiveService.listAllUsers();
    }

    @GetMapping("/list/{code}")
    public Flux<User> getUsersByDepartmentCode(@PathVariable String code) {
        return userReactiveService.listUsersByDepartmentCode(code);
    }
}
