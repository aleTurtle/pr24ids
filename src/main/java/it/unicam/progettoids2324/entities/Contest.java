package it.unicam.progettoids2324.entities;

import it.unicam.progettoids2324.dtos.ContestDTO;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Getter
@NoArgsConstructor
public class Contest {
    @Id
    @GeneratedValue
    private int id;

    private String name; // nome del contest
    private String description;
    @Column(name = "start_datetime")// descrizione
    private LocalDateTime start; // data di inizio
    @Column(name = "end_datetime")
    private LocalDateTime end; // data di fine
    @Setter
    private ContestState state;
    @Setter
    //@OneToOne
    private long winnerId;



    public Contest(String name, String description, LocalDateTime start, LocalDateTime end) {
        this.name = name;
        this.description = description;
       // this.contributions = new HashSet<>();
        this.start = start;
        this.end = end;
        this.state = ContestState.CREATED;
    }

    public ContestDTO toDTO() {
        return new ContestDTO(this.name, this.description, this.start, this.end,this.winnerId);
    }
}

