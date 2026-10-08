package com.resqhub.backend.controller;

import com.resqhub.backend.dto.LoginRequestDto;
import com.resqhub.backend.dto.UserRequestDto;
import com.resqhub.backend.entity.User;
import com.resqhub.backend.service.UserService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }


    // SIGNUP
    @PostMapping("/signup")
    public User signup(@RequestBody UserRequestDto request) {

        return userService.signup(request);
    }


    // LOGIN
    @PostMapping("/login")
    public User login(@RequestBody LoginRequestDto request) {

        return userService.login(request);
    }


    // GET USER
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {

        return userService.getUserById(id);
    }
}