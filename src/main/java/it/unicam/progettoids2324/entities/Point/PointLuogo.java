package it.unicam.progettoids2324.entities.Point;

import it.unicam.progettoids2324.dtos.PointLuogoDTO;
import it.unicam.progettoids2324.entities.Coordinates;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class PointLuogo extends Point {

    private String POILuogoType;
    private String descrizioneLuogo;

    public PointLuogo(String name, Coordinates position, String descrizioneLuogo){
        super(name, position, PointType.Luogo);
        this.descrizioneLuogo= descrizioneLuogo;
    }

    //@Override
    public PointLuogoDTO toDTO() {return new PointLuogoDTO(super.getId(),super.getName(),super.getPosition(), descrizioneLuogo);}

}
