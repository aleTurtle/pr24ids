package it.unicam.progettoids2324.entities.Point;

import it.unicam.progettoids2324.entities.Coordinates;
import java.time.LocalDateTime;

public class PointFactory {
    public Point createPointEvento(String name, Coordinates position, LocalDateTime start, LocalDateTime end) {
        return new PointEvento(name, position,start, end);
    }

    public Point createPointLuogo(String name, Coordinates position, String emergenza) {
        return new PointLuogo(name,position,emergenza);
    }
}
