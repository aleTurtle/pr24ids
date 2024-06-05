package it.unicam.progettoids2324.entities.Point;

import it.unicam.progettoids2324.entities.Coordinates;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class PointLuogo extends Point {

    private String POILuogoType;
    private String emergenza;

    public PointLuogo(String name, Coordinates position, String emergenza) {
        super(name, position);
        this.emergenza= emergenza;
    }

    //@Override
    //public PoiDTO toDTO() {return new PoiDTO(Long Id,String name, Coordinates position)}
}
