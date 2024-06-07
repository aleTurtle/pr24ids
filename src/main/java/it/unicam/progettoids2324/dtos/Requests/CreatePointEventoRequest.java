package it.unicam.progettoids2324.dtos.Requests;

import it.unicam.progettoids2324.entities.Coordinates;

import java.time.LocalDateTime;

public record CreatePointEventoRequest(
        Long Userid,
        String name,
        Coordinates coordinates,
        LocalDateTime start,
        LocalDateTime end
) {
}
