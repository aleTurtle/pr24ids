package it.unicam.progettoids2324.entities.Point;

import it.unicam.progettoids2324.entities.Coordinates;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
public class PointEvento extends Point {
    private String POIEventoType;

    private LocalDateTime start;
    @Column(name = "end_date")
    private LocalDateTime end;

    public PointEvento(String name, Coordinates position, LocalDateTime start, LocalDateTime end) {
        super(name, position);
        this.start= start;
        this.end= end;

    }
   // public String getPOIEventoType() {return POIEventoType;}

   // @Override
    //public PoiDTO toDTO() {
     //   return new PoiDTO(id,name,position,LocalDateTime start, LocalDateTime end);}

}
