package it.unicam.progettoids2324.entities.Point;

import it.unicam.progettoids2324.dtos.PointDTO;
import it.unicam.progettoids2324.dtos.PointLuogoDTO;
import it.unicam.progettoids2324.entities.Coordinates;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PointLuogo extends Point {
    private String descrizioneLuogo;

    public PointLuogo(String name, Coordinates position, String descrizioneLuogo){
        super(name, position, PointType.Luogo);
        this.descrizioneLuogo= descrizioneLuogo;
    }

    public PointDTO toDTO() {return new PointLuogoDTO(super.getId(),super.getName(),super.getPosition(), descrizioneLuogo);}

}
