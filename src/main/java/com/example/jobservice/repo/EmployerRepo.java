package com.example.jobservice.repo;

import com.example.jobservice.model.Employers;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Component
public interface EmployerRepo extends JpaRepository<Employers, Integer> {
    Optional<Employers> findEmployersByEmail(String email);
}
