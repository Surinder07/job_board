package com.example.job_service.service;

import com.example.job_service.model.CustomEmployerDetails;
import com.example.job_service.model.Employer;
import com.example.job_service.repo.EmployerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class CustomEmployerDetailService implements UserDetailsService {

    @Autowired
    EmployerRepo employerRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Employer> employer = employerRepo.findEmployersByEmail(email);
        employer.orElseThrow(() -> new UsernameNotFoundException("Employer does not exists!"));

        return employer.map(CustomEmployerDetails::new).get();
    }

}
