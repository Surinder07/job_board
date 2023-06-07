package com.example.job_service.service;

import com.example.job_service.model.CustomerUserDetails;
import com.example.job_service.model.User;
import com.example.job_service.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<User> user = userRepo.findUserByEmail(email);
        user.orElseThrow(() -> new UsernameNotFoundException("User not Exists"));
        return user.map(CustomerUserDetails::new).get();
    }
}
