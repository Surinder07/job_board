package com.example.job_service.repo;

import com.example.job_service.model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface EmployerRepo extends JpaRepository<Employer, Integer> {

    Optional<Employer> findEmployersByEmail(String email);

}
