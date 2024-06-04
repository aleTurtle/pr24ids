package it.unicam.progettoids2324.Services.Abstractions;

import it.unicam.progettoids2324.entities.Coordinates;
import it.unicam.progettoids2324.entities.Municipality;
import it.unicam.progettoids2324.entities.Point.Point;
import it.unicam.progettoids2324.entities.Point.PointType;

import java.time.LocalDateTime;
import java.util.Set;

public interface PointServiceInterface {

    /**
     * Get all the pois of the municipality
     * @param munId
     * @return the pois of the municipality
     */
    Set<Point> getPois(long munId);

    /**
     * Create and add a poi in the municipality
     * @param coordinate
     * @throws IllegalArgumentException
     */
    void addPoi(PointType type, String name, Coordinates coordinate, String emergenza, LocalDateTime start,
                LocalDateTime end);

}
