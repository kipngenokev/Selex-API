package com.selex.bigOne.service;

import com.selex.bigOne.entity.User;
import com.selex.bigOne.exceptions.ResourceNotFoundException;
import com.selex.bigOne.models.UserRequest;
import com.selex.bigOne.models.UserResponse;
import com.selex.bigOne.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(UserRequest userRequest) {

        User user = new User(userRequest.name(), userRequest.email());
        User savedUser = userRepository.save(user);

        return savedUser;
    }

    public UserResponse getById(long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id :"+ id));

        UserResponse userResponse = new UserResponse(user.getId(),user.getName(),user.getEmail());
        return userResponse;
    }

    public List<UserResponse> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        List<UserResponse> userResponseList = new ArrayList<>();

        for(User user : allUsers) {
            userResponseList.add(new UserResponse(user.getId(),user.getName(),user.getEmail()));
        }

        return userResponseList;
    }

    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }

    public UserResponse updateUser(long id, UserRequest userRequest) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with id "+id+" not found "));

        user.setName(userRequest.name());
        user.setEmail(userRequest.email());

        User updatedUser = userRepository.save(user);
        return new UserResponse(updatedUser.getId(), updatedUser.getName(), updatedUser.getEmail());

    }


}
