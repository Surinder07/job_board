package com.example.jobservice.controller;

import com.example.jobservice.model.Employers;
//import com.example.jobservice.model.Roles;
import com.example.jobservice.repo.EmployerRepo;
//import com.example.jobservice.repo.RoleRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class EmployerRegisterController {

    @Autowired
    private EmployerRepo employerRepo;
   /* @Autowired
    private RoleRepo roleRepo;*/

    @PostMapping("/registerEmployer")
    public ResponseEntity<Employers> registerEmployer(@RequestBody Employers employer) throws SecurityException, ServletException, NoSuchFieldException {

        /*List<Roles> roles = new ArrayList<>();

        roles.add(roleRepo.findById(3).get());

        roles.add(roleRepo.findById(3).get());
        employer.setRoles(roles);*/
        employerRepo.save(employer);
        return ResponseEntity.created(null).build();
    }
    @GetMapping("/employers")
    public List<Employers> registeredEmployers() {return employerRepo.findAll();}
}
