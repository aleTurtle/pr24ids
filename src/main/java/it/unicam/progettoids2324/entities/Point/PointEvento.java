package it.unicam.progettoids2324.entities.Point;

import it.unicam.progettoids2324.dtos.PointDTO;
import it.unicam.progettoids2324.dtos.PointEventoDTO;
import it.unicam.progettoids2324.entities.Coordinates;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PointEvento extends Point {

    private LocalDateTime start;
    @Column(name = "end_date")
    private LocalDateTime end;

    public PointEvento(String name, Coordinates position, LocalDateTime start, LocalDateTime end) {
        super(name, position, PointType.Evento);
        this.start= start;
        this.end= end;
    }

    public PointDTO toDTO() {return new PointEventoDTO(super.getId(),super.getName(),super.getPosition(), start,  end);}

}
