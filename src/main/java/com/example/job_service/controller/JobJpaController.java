package com.example.job_service.controller;

import com.example.job_service.model.Job;
import com.example.job_service.repository.JobJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;

@RestController
@RequestMapping("/job")
public class JobJpaController {

    @Autowired
    JobJpaRepository jobJpaRepository;

    @PostMapping("/create")
    public ResponseEntity<Job> createJob(@RequestBody Job job){
        this.jobJpaRepository.save(job);
        return ResponseEntity.created(null).body(job);
    }


    @DeleteMapping ("/delete")
    public ResponseEntity<Job> deleteJob(@PathVariable int id){
        Optional<Job> optionalJob = this.jobJpaRepository.findById(id);
        if(optionalJob.isEmpty()){
            System.out.println("Job id is not valid");
            return ResponseEntity.notFound().build();
        }
        Job job = optionalJob.get();
        jobJpaRepository.delete(job);
        return ResponseEntity.created(null).body(job);
    }

    @PatchMapping("/update")
    public ResponseEntity<Job> updateJob(@RequestBody Job job){
        Optional<Job> optionalJob = this.jobJpaRepository.findById(job.getJobid());
        if(optionalJob.isEmpty()) {
            System.out.println("Job id is not valid");
            return ResponseEntity.notFound().build();
        }
        Job newJob = optionalJob.get();
        if(job.getJobid() != 0)
            newJob.setJobid(job.getJobid());
        if (job.getJobTitle() != null)
            newJob.setJobTitle(job.getJobTitle());
        if (job.getJobDescription()!=null)
            newJob.setJobDescription(job.getJobDescription());

        this.jobJpaRepository.save(newJob);
        return ResponseEntity.created(null).body(newJob);

    }
}
