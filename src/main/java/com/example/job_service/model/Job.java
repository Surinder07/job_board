package com.example.job_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;
import java.util.Date;

@Entity
//@Document(collection = "jobs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    String companyName;
    @Id
    int jobid;
    String jobTitle;
    String jobType;
    String jobDescription;
    Date startDate;
    int vacancies;
    String address;
    int salary;
    String benefits;


}
