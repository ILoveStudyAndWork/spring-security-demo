package com.example.springsecurity.springsecuritydemo.controller;

import com.example.springsecurity.springsecuritydemo.domain.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashBoardController {
    @GetMapping("/dashboard")
    public String getDashBoard(@AuthenticationPrincipal User user, ModelMap model) {
        model.put("user", user);
        System.out.println(user);
        return "dashboard";
    }
}
