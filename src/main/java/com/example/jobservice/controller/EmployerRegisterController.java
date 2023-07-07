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

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EmployerRegisterController {

    @Autowired
    private EmployerRepo employerRepo;
   /* @Autowired
    private RoleRepo roleRepo;*/

    @PostMapping("/registerEmployer")
    public ResponseEntity<Employers> registerEmployer(@RequestBody Employers employer) throws SecurityException, ServletException, NoSuchFieldException, URISyntaxException {

        /*List<Roles> roles = new ArrayList<>();

        roles.add(roleRepo.findById(3).get());

        roles.add(roleRepo.findById(3).get());
        employer.setRoles(roles);*/
        Employers employers = employerRepo.save(employer);
        return ResponseEntity.created(new URI("/registerEmployer/" + employers.getId())).body(employers);
    }
    @GetMapping("/employers")
    public List<Employers> registeredEmployers() {return employerRepo.findAll();}
}
