package it.unicam.progettoids2324.Services.Abstractions;

import it.unicam.progettoids2324.entities.Coordinates;
import it.unicam.progettoids2324.entities.Municipality;
import it.unicam.progettoids2324.OSM.MunicipalityChecker;

public interface OsmServiceInterface {

    /**
     *
     * @param coor
     * @param municipality
     * @return TRUE if the point is in the municipality else return false
     */
    boolean isInTheMunicipality(Coordinates coor, Municipality municipality);
}
