
package com.placement.placement_management_system.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.placement.placement_management_system.entity.User;
import com.placement.placement_management_system.repository.UserRepository;

@Configuration
public class AdminRegistrationRunner {

    @Bean
    CommandLineRunner createAdmin(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {

        return args -> {

            if (!userRepository.existsByEmail("admin@gmail.com")) {

                User admin = new User();

                admin.setName("Admin");
                admin.setEmail("admin@gmail.com");
                admin.setPassword(
                    passwordEncoder.encode("Admin@123")
                );
                admin.setRole("ADMIN");

                userRepository.save(admin);

                System.out.println("Admin Account Created Successfully");
            }
        };
    }
}
