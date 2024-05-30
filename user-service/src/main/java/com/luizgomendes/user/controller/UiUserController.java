package com.luizgomendes.user.controller;

import com.luizgomendes.user.model.User;
import com.luizgomendes.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/user-ui")
public class UiUserController {

    private final UserService userService;

    @Autowired
    public UiUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String userList(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "users";
    }

    @GetMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable("id") String userId, Model model) {
        userService.deleteUserById(userId);
        model.addAttribute("users", userService.findAllUsers());

        return "users";
    }

    @GetMapping(value = {"/add-edit-user/{id}", "/add-edit-user"})
    public String addEditUser(@PathVariable("id") Optional<String> userId, Model model) {
        User user = userId.map(s -> userService.findUserById(s).get()).orElseGet(User::new);
        model.addAttribute("user", user);

        return "add-edit-user";
    }

    @PostMapping("/save-user")
    public String saveUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "add-edit-user";
        }
        userService.saveUser(user);
        return "redirect:users";
    }



}
