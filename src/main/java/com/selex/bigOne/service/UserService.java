package com.selex.bigOne.service;

import com.selex.bigOne.entity.User;
import com.selex.bigOne.models.UserRequest;
import com.selex.bigOne.models.UserResponse;
import com.selex.bigOne.repository.UserRepository;
import org.springframework.stereotype.Service;

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
        Optional<User> data = userRepository.findById(id);

        User user = null;
        if(data.isPresent()) {
            user = data.get();
        } else {
            throw new RuntimeException("User with id "+ id + " is not found");
        }

        UserResponse userResponse = new UserResponse(user.getId(),user.getName(),user.getEmail());
        return userResponse;
    }
}
