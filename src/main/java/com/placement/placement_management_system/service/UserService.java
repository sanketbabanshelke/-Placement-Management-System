
package com.placement.placement_management_system.service;

import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.placement.placement_management_system.entity.User;
import com.placement.placement_management_system.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder =
            new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Register User
    public User registerUser(User user) {

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        String role = user.getRole();

        if (role == null ||
            !(role.equals("COMPANY") || role.equals("STUDENT"))) {
            throw new RuntimeException(
                "Only Company and Student registration is allowed");
        }

        user.setPassword(
            passwordEncoder.encode(user.getPassword())
        );

        return userRepository.save(user);
    }

    // Find User By Email
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
}

