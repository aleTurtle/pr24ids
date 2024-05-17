package it.unicam.progettoids2324.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@Table(name = "Users")
@NoArgsConstructor
public class Utente {
    @Id
    @GeneratedValue
    private int id;
    @Setter
    private String email;
    @Setter
    private String Password;

    public Utente(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.Password = password;
    }

    public Utente(String email, String password) {
    }
}
