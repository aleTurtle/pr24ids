package it.unicam.progettoids2324.Services;

import it.unicam.progettoids2324.Repositories.PointRepository;
import it.unicam.progettoids2324.Services.Abstractions.OsmServiceInterface;
import it.unicam.progettoids2324.Services.Abstractions.PointServiceInterface;
import it.unicam.progettoids2324.entities.Coordinates;
import it.unicam.progettoids2324.entities.Municipality;
import it.unicam.progettoids2324.entities.MunicipalityChecker;
import it.unicam.progettoids2324.entities.Point;
import org.locationtech.jts.algorithm.HCoordinate;
import org.locationtech.jts.util.CoordinateArrayFilter;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PointService implements PointServiceInterface {
    private final PointRepository pointRepository;
    private final MunicipalityService municipalityService;
    private final OsmService osmService;

    public PointService(PointRepository pointRepository, MunicipalityService municipalityService, OsmService osmService){
        this.pointRepository = pointRepository;
        this.municipalityService = municipalityService;
        this.osmService = osmService;
    }

    @Override
    public Set<Point> getPois(long munId) {
        Set<Point> points = new HashSet<>();
        for(Point point : this.municipalityService.getMunicipalityById(munId).getPoints()){
            points.add(point);
        }
        return points;
    }

    @Override
    public void addPoi(Coordinates coor, Municipality municipality) {
        Coordinates coordinate = new Coordinates(coor.lat(), coor.longi());
        if(!osmService.isInTheMunicipality(coordinate, municipality)){
            throw new IllegalArgumentException("The point isn't in the municipality");
        }
        Point p = new Point(coordinate, municipality);
        municipality.addPoint(p);
        this.pointRepository.save(p);
    }
}
