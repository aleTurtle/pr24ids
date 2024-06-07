package it.unicam.progettoids2324.Services;

import it.unicam.progettoids2324.Services.Abstractions.OsmServiceInterface;
import it.unicam.progettoids2324.entities.Coordinates;
import it.unicam.progettoids2324.entities.Municipality;
import it.unicam.progettoids2324.OSM.MunicipalityChecker;
import org.springframework.stereotype.Service;

@Service
public class OsmService implements OsmServiceInterface {

    @Override
    public boolean isInTheMunicipality(Coordinates coor, String municipalityName) {
        MunicipalityChecker check = new MunicipalityChecker(coor, municipalityName);
        if(check == null){
            throw new IllegalArgumentException("The point isn't in the municipality");
        }
        return true;
    }
}
