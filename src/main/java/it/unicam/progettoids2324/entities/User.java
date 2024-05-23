package it.unicam.progettoids2324.entities;

import it.unicam.progettoids2324.dtos.UserDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Utenti")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    public long id;
    @Setter
    public String email;
    @Setter
    public String password;

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
