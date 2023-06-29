package com.example.jobservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employers")
public class Employers {



    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
     int id;

    @NotNull
    private String companyName;

    @NotNull
    @Email(message = "invalid.email.error")
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull
    @Column(nullable = false,unique = true)
    private String password;

/*
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "employer_role",
            joinColumns = {@JoinColumn(name = "EMPLOYER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")}

    )
    private List<Roles> roles;
*/

    public Employers(String companyName, String email, String password) {
        this.companyName = companyName;
        this.email = email;
        this.password = password;
       // this.roles = roles;
    }
}
