package it.unicam.progettoids2324.dtos;

import it.unicam.progettoids2324.entities.Coordinates;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public final class PointLuogoDTO extends PointDTO{
    private final String luogoDescrizione;

    public PointLuogoDTO(long id, String name, Coordinates position, String luogoDescrizione){
        super(id,name,position);
        this.luogoDescrizione = luogoDescrizione;
    }



}
