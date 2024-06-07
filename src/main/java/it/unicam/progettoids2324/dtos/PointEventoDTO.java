package it.unicam.progettoids2324.dtos;

import it.unicam.progettoids2324.entities.Coordinates;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public final class PointEventoDTO extends PointDTO{
    private final LocalDateTime start;
    private final LocalDateTime end;

    public PointEventoDTO(long id, String name, Coordinates position, LocalDateTime start, LocalDateTime end){
        super(id,name,position);
       this.start = start;
       this.end = end;
    }
}
