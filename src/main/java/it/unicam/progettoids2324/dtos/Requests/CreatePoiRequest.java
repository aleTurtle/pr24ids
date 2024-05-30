package it.unicam.progettoids2324.dtos.Requests;

import it.unicam.progettoids2324.entities.Coordinates;
import it.unicam.progettoids2324.entities.Municipality;
import it.unicam.progettoids2324.entities.MunicipalityChecker;

public record CreatePoiRequest(
        Coordinates coord,
        Municipality municipality
) {

}
