package com.example.job_service.controller;

import com.example.job_service.model.Role;
import com.example.job_service.model.User;
import com.example.job_service.repo.RoleRepo;
import com.example.job_service.repo.UserRepo;
import com.example.job_service.service.CustomUserDetailService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    UserRepo userRepo;
    @Autowired
    RoleRepo roleRepo;

    @GetMapping("/")
    public String home() {
        return "index";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String GetRegister() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user, HttpServletRequest request) throws SecurityException, ServletException {
        String password = user.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(password));
        List<Role> roles = new ArrayList<>();
        roles.add(roleRepo.findById(2).get());
        user.setRoles(roles);
        userRepo.save(user);

        request.login(user.getEmail(), password);

        return ("redirect:/");
    }
    @GetMapping("/admin")
    public String registeredUsers(Model model){
        List<User> users = userRepo.findAll();
        model.addAttribute("users", users);
        return "admin";
    }


}
