package com.example.job_service;

import com.example.job_service.model.Role;
import com.example.job_service.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JobServiceApplication implements CommandLineRunner {
    @Autowired
    RoleRepo roleRepo;

    public static void main(String[] args) {
        SpringApplication.run(JobServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        roleRepo.save(new Role(1, "ROLE_ADMIN"));
        roleRepo.save(new Role(2, "ROLE_USER"));
        roleRepo.save(new Role(3,"ROLE_EMPLOYER"));
    }
}
