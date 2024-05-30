package it.unicam.progettoids2324.entities;

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
    @Column(name = "start")// descrizione
    private LocalDateTime start; // data di inizio
    @Column(name = "end")
    private LocalDateTime end; // data di fine
    @Setter
    @OneToOne
    private User win; // premio

    private ContestState state; // stato associato al Contest


    public Contest(String name, String description, LocalDateTime start, LocalDateTime end) {
        this.name = name;
        this.description = description;
       // this.contributions = new HashSet<>();
        this.start = start;
        this.end = end;
        this.win = win;
        this.state = ContestState.CREATED;
    }
}

