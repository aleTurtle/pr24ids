package it.unicam.progettoids2324.entities;

import it.unicam.progettoids2324.dtos.ReportsDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@Table(name = "Reports")
@NoArgsConstructor
public class Reports {
    @Id
    @GeneratedValue
    private long id;
    private String description;

    public Reports(String description) {
        this.description = description;
    }

    public ReportsDTO toDTO(){
        return new ReportsDTO(this.id,this.description);
    }
}
