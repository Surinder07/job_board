package com.example.job_service.controller;

import com.example.job_service.repository.JobJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jobBoard")
public class JobViewController {

    @Autowired
    JobJpaRepository jobJpaRepository;

    @GetMapping("/home")
    public String getHome(){
        return "home";
    }

    @GetMapping("/jobs")
    public String getJob(Model model){
        model.addAttribute(jobJpaRepository.findAll());
        return "jobs";
    }

}
