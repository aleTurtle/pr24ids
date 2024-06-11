package it.unicam.progettoids2324.entities;

import it.unicam.progettoids2324.dtos.ManagerDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "Manager")
@NoArgsConstructor
public class Manager {
    @Id
    @GeneratedValue
    private long id;
    private String email;
    private String password;
    private UserRole role;

    public Manager(String email, String password) {
        this.email = email;
        this.password = password;
        this.role = UserRole.MANAGER;
    }

    public ManagerDTO toDTO(){
        return new ManagerDTO(this.id, this.email, this.password, this.role.toString());
    }
}
