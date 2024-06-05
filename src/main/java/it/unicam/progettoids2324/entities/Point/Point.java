package it.unicam.progettoids2324.entities.Point;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;
import it.unicam.progettoids2324.entities.Coordinates;
import it.unicam.progettoids2324.dtos.PointDTO;

@Entity
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Point {
    @Id
    @GeneratedValue
    private long id;
    @Embedded
    private Coordinates position;

    private String name;

    public Point(String name, Coordinates position) {
        this.name= name;
        this.position = position;
    }

    public PointDTO toDTO() {
        return new PointDTO(this.id, this.name, this.position);
    }



}

