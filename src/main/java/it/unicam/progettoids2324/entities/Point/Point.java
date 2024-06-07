package it.unicam.progettoids2324.entities.Point;

import it.unicam.progettoids2324.dtos.PointDTO;
import it.unicam.progettoids2324.dtos.PointEventoDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import it.unicam.progettoids2324.entities.Coordinates;

@Entity
@Getter
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
    private PointType type;
    private PointState pointState;
    public Point(String name, Coordinates position, PointType type) {
        this.name= name;
        this.position = position;
        this.type= type;
    }

    public PointDTO toDTO() {return new PointDTO(id,name,position);}

}

