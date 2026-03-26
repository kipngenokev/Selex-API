package com.selex.bigOne.service;

import com.selex.bigOne.entity.User;
import com.selex.bigOne.models.UserRequest;
import com.selex.bigOne.repository.UserRepository;
import org.springframework.stereotype.Service;

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
}
