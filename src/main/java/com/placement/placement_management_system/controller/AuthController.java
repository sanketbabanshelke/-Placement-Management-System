
package com.placement.placement_management_system.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.placement.placement_management_system.dto.LoginResponse;
import com.placement.placement_management_system.entity.User;
import com.placement.placement_management_system.service.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserService userService,
                          PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody User loginData) {

        User user = userService.findByEmail(loginData.getEmail());

        if (user == null ||
            loginData.getPassword() == null ||
            !passwordEncoder.matches(
                loginData.getPassword(), user.getPassword())) {

            throw new ResponseStatusException(
                HttpStatus.UNAUTHORIZED,
                "Invalid Email or Password"
            );
        }

        return new LoginResponse(
            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getRole(),
            "Login Successful"
        );
    }
}
