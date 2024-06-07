package it.unicam.progettoids2324.dtos;

import it.unicam.progettoids2324.entities.Coordinates;
import lombok.Getter;

@Getter
public class PointDTO {
        private final long id;
        private final String name;
        private final Coordinates position;

        public PointDTO(long id, String name, Coordinates position){
            this.id = id;
            this.name = name;
            this.position = position;
        }
}
