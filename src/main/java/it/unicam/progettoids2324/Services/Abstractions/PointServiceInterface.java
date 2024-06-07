package it.unicam.progettoids2324.Services.Abstractions;

import it.unicam.progettoids2324.dtos.PointDTO;
import it.unicam.progettoids2324.dtos.PointLuogoDTO;
import it.unicam.progettoids2324.entities.Coordinates;
import it.unicam.progettoids2324.entities.Point.PointType;
import it.unicam.progettoids2324.dtos.PointEventoDTO;

import java.time.LocalDateTime;
import java.util.Set;

public interface PointServiceInterface {

    void addPoi(Long UserId, PointType type, String name, Coordinates coordinate, String luogoDescrizione, LocalDateTime start,
                LocalDateTime end);

    Set<PointDTO> getLuogoPoints();
    Set<PointDTO> getEventoPoints();

    Set<PointDTO> getPoints();

    Set<PointDTO> getPendingPoints();
}
