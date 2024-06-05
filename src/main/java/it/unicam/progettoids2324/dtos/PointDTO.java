package it.unicam.progettoids2324.dtos;

import it.unicam.progettoids2324.entities.Coordinates;

public record PointDTO(long id, String name, Coordinates position){

    @Override
    public long id() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public Coordinates position() {
        return position;
    }
}
