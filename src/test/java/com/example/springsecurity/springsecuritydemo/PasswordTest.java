package com.example.springsecurity.springsecuritydemo;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordTest {
    @Test
    void should_return_password_after_encode() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = "password";
        System.out.println(passwordEncoder.encode(password));
    }
}
