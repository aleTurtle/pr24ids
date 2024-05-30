package it.unicam.progettoids2324.Services;

import it.unicam.progettoids2324.Services.Abstractions.OsmServiceInterface;
import it.unicam.progettoids2324.entities.Coordinates;
import it.unicam.progettoids2324.entities.Municipality;
import it.unicam.progettoids2324.entities.MunicipalityChecker;
import org.springframework.stereotype.Service;

@Service
public class OsmService implements OsmServiceInterface {

    @Override
    public boolean isInTheMunicipality(Coordinates coor, Municipality municipality) {
        String name = municipality.getName();
        MunicipalityChecker check = new MunicipalityChecker(coor, name);
        if(check == null){
            throw new IllegalArgumentException("The point isn't in the municipality");
        }
        return true;
    }
}
