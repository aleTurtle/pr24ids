package it.unicam.progettoids2324.dtos.Requests;

import it.unicam.progettoids2324.entities.Point.Point;

public record ApprovePointRequest(
        long userId,
        long pointId) {

}
