/*
package com.example.jobservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")

public class Roles {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty
    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<Users> users;

    @ManyToMany(mappedBy = "roles")
    private List<Employers> employers;

    public Roles(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
*/
