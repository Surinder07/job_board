package com.example.job_service.repo;

import com.example.job_service.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Component;

@Component
public interface RoleRepo extends JpaRepository<Role, Integer> {
}
