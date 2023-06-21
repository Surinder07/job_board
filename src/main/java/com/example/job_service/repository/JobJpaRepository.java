package com.example.job_service.repository;


import com.example.job_service.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface JobJpaRepository extends JpaRepository <Job, Integer>{
}
