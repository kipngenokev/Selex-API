package com.selex.bigOne.controller;

import com.selex.bigOne.models.UserRequest;
import com.selex.bigOne.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public void createUser(@RequestBody UserRequest userRequest) {
        System.out.println(userRequest);

        userService.saveUser(userRequest);
    }
}
