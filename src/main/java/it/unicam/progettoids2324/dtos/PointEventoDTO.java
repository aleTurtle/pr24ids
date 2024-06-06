package it.unicam.progettoids2324.dtos;

import it.unicam.progettoids2324.entities.Coordinates;

import java.time.LocalDateTime;

public record PointEventoDTO(long id, String name, Coordinates position, LocalDateTime start,LocalDateTime end){

}
