package it.unicam.progettoids2324.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.locationtech.jts.geom.Coordinate;

@Entity
@Setter
@NoArgsConstructor
public class Point {
    @Id
    @GeneratedValue
    private long id;
    @Embedded
    private Coordinates coordinates;
    @ManyToOne
    private Municipality municipality;

    public Point(Coordinates coordinate, Municipality municipality) {
        this.municipality = municipality;
        this.coordinates = coordinate;
    }

}
