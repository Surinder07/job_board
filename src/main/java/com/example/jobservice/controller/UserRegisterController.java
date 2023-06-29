package com.example.jobservice.controller;

//import com.example.jobservice.model.Roles;
import com.example.jobservice.model.Users;
//import com.example.jobservice.repo.RoleRepo;
import com.example.jobservice.repo.UserRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class UserRegisterController {

    @Autowired
    private UserRepo userRepo;
/*    @Autowired
    private RoleRepo roleRepo;*/

    @PostMapping("/registerUser")
    public ResponseEntity<Users> registerUser(@RequestBody Users user) throws SecurityException, ServletException, NoSuchFieldException {

       /* List<Roles> roles = new ArrayList<>();
        roles.add(roleRepo.findById(2).get());
        user.setRoles(roles);*/
        userRepo.save(user);
        return ResponseEntity.created(null).build();
    }
    @GetMapping("/users")
    public List<Users> registeredUsers() {return  userRepo.findAll();}

}
