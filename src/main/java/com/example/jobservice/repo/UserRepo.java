package com.example.jobservice.repo;

import com.example.jobservice.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Component
public interface UserRepo extends JpaRepository<Users,Integer> {

    Optional<Users> findUsersByEmail(String email);
}
