package com.resqhub.backend.service;

import com.resqhub.backend.dto.LoginRequestDto;
import com.resqhub.backend.dto.UserRequestDto;
import com.resqhub.backend.entity.User;
import com.resqhub.backend.repository.UserRepository;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    // SIGNUP
    public User signup(UserRequestDto request) {

        User user = new User();

        user.setName(request.getName());

        user.setEmail(request.getEmail());

        user.setPhone(request.getPhone());

        user.setPassword(request.getPassword());

        return userRepository.save(user);
    }


    // LOGIN
    public User login(LoginRequestDto request) {

        User user = userRepository
                .findByEmail(request.getEmail())
                .orElse(null);

        if (user == null) {

            return null;
        }

        if (!user.getPassword().equals(request.getPassword())) {

            return null;
        }

        return user;
    }


    // GET USER BY ID
    public User getUserById(Long id) {

        return userRepository
                .findById(id)
                .orElse(null);
    }
}