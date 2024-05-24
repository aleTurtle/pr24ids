package it.unicam.progettoids2324.entities;


import it.unicam.progettoids2324.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Utenti")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private long id;
    @Setter
    private String email;
    @Setter
    private String password;

    public User(long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;

    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }



    public UserDTO toDTO(){
        return new UserDTO(this.id, this.email, this.password);
    }
}
