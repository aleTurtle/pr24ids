package it.unicam.progettoids2324.entities;


import it.unicam.progettoids2324.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
@Table(name = "Utenti")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private long id;
    private String email;
    private String password;
    @Setter
    private UserRole role;


    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.role = UserRole.AUTHENTICATED_TOURIST;
    }

    public UserDTO toDTO(){
        return new UserDTO(this.id, this.email, this.password, this.role.toString());
    }
}
