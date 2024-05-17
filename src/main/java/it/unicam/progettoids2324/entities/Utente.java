package it.unicam.progettoids2324.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Utente {
    @Id
    @GeneratedValue
    private int id;

    public int getId() {
        return id;
    }
}
