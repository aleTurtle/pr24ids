package it.unicam.progettoids2324.entities;

import it.unicam.progettoids2324.dtos.ReportsDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "Reports")
@NoArgsConstructor
public class Report {
    @Id
    @GeneratedValue
    private long id;
    private String description;

    public Report(String description) {
        this.description = description;
    }

    public ReportsDTO toDTO(){
        return new ReportsDTO(this.id,this.description);
    }
}
