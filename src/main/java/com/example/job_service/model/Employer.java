package com.example.job_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "employers")
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty
    @Column(nullable = false)
    private String companyName;

    @NotEmpty
    @Email(message = "{errors.invalid_email}")
    @Column(nullable = false, unique = true)
    private String email;

    @NotEmpty
    @Column(nullable = false)
    private String password;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "employer_role",
            joinColumns = {@JoinColumn(name = "EMPLYER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")}

    )

    private List<Role> roles;

    public Employer(Employer employer) {
        this.companyName = employer.getCompanyName();
        this.email = employer.getEmail();
        this.password = employer.getPassword();
        this.roles = employer.getRoles();
    }

    public Employer() {
    }


}
