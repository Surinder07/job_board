package com.example.job_service.repo;

import com.example.job_service.model.Role;
import com.example.job_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public interface UserRepo extends JpaRepository<User, Integer>{
    Optional<User> findUserByEmail(String email);

}
