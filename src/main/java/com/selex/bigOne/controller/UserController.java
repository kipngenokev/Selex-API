package com.selex.bigOne.controller;

import com.selex.bigOne.entity.User;
import com.selex.bigOne.models.UserRequest;
import com.selex.bigOne.models.UserResponse;
import com.selex.bigOne.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {

        User user = userService.saveUser(userRequest);
        UserResponse userResponse = new UserResponse(user.getId(),user.getName(),user.getEmail());

//        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
        return ResponseEntity.created(URI.create("/api/v1/users"+ user.getId())).body(userResponse);
    }

    @GetMapping("users/{id}")
    public ResponseEntity<UserResponse> getUser (@PathVariable Long id) {
        UserResponse userResponse = userService.getById(id);
        return ResponseEntity.ok(userResponse);

    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<UserResponse> usersList = userService.getAllUsers();
        return ResponseEntity.ok(usersList);
    }

}
