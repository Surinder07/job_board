package com.example.jobservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class Users {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;

        @NotEmpty
        @Column(nullable = false)
        private String firstName;

        private String lastName;

        @NotEmpty
        @Email(message = "{errors.invalid_email}")
        @Column(nullable = false, unique = true)
        private String email;

        @NotEmpty
        @Column(nullable = false)
        private String password;
/*

        @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
        @JoinTable(
                name = "user_role",
                joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
                inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")}

        )
        private List<Roles> roles;
*/

        public Users(Users user) {
            this.firstName = user.getFirstName();
            this.lastName = user.getLastName();
            this.email = user.getEmail();
            this.password = user.getPassword();
            //this.roles = user.getRoles();
        }
}
