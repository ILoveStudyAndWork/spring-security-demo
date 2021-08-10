package com.example.springsecurity.springsecuritydemo.controller;

import com.example.springsecurity.springsecuritydemo.domain.User;
import com.example.springsecurity.springsecuritydemo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DashBoardController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/dashboard")
    public String getDashBoard(@AuthenticationPrincipal User user, ModelMap model) {
        model.put("user", user);
        List<User> allUsers = adminService.getAllUsers();
        System.out.println(user);
        return "dashboard";
    }
}
