package com.example.job_service.controller;

import com.example.job_service.model.Role;
import com.example.job_service.model.User;
import com.example.job_service.repo.RoleRepo;
import com.example.job_service.repo.UserRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import net.minidev.asm.ex.NoSuchFieldException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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
    public String register(@ModelAttribute("user") User user, HttpServletRequest request) throws SecurityException, ServletException, NoSuchFieldException {
        String password = user.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(password));
        List<Role> roles = new ArrayList<>();
        if (roleRepo.findById(2).isEmpty()) {
            throw new NoSuchElementException();
        } else {
            roles.add(roleRepo.findById(2).get());
        }
        user.setRoles(roles);
        userRepo.save(user);

        request.login(user.getEmail(), password);

        return ("redirect:/");
    }

    @GetMapping("/user")
    public String registeredUsers(Model model) {
        List<User> users = userRepo.findAll();
        model.addAttribute("users", users);
        return "user";
    }


}
