package it.unicam.progettoids2324.entities;

import java.time.LocalDateTime;
public class Contest {
    private String name; // nome del contest
    private String description;     // descrizione
    private LocalDateTime start; // data di inizio
    private LocalDateTime end; // data di fine

    private String win; // premio

    private ContestState state; // stato associato al Contest


    public Contest(String name, String description, LocalDateTime start, LocalDateTime end, String win) {
        this.name = name;
        this.description = description;
       // this.contributions = new HashSet<>();
        this.start = start;
        this.end = end;
        this.win = win;
        this.state = ContestState.CREATED;
    }
}

