package it.unicam.progettoids2324.dtos;

import it.unicam.progettoids2324.entities.Coordinates;

import java.time.LocalDateTime;

public record PointLuogoDTO(long id, String name, Coordinates position, String luogoDescrizione) {
}
