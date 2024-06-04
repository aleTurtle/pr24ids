package it.unicam.progettoids2324.dtos.Requests;

import it.unicam.progettoids2324.entities.Coordinates;
import it.unicam.progettoids2324.entities.Municipality;

import java.time.LocalDateTime;

public record CreatePointLuogoRequest(
        String name,
        Coordinates coord,
        String emergenza
) {

}