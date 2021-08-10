package com.example.springsecurity.springsecuritydemo.repository;

import com.example.springsecurity.springsecuritydemo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
