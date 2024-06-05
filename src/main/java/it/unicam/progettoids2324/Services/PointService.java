package it.unicam.progettoids2324.Services;

import it.unicam.progettoids2324.Repositories.PointRepository;
import it.unicam.progettoids2324.Services.Abstractions.PointServiceInterface;
import it.unicam.progettoids2324.entities.Coordinates;
import it.unicam.progettoids2324.entities.Point.Point;
import it.unicam.progettoids2324.entities.Point.PointFactory;
import it.unicam.progettoids2324.entities.Point.PointType;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public void addPoi(PointType type, String name, Coordinates coordinate, String emergenza, LocalDateTime start,
                       LocalDateTime end) {
        /*
        if(!osmService.isInTheMunicipality(coordinate, municipality)){
            throw new IllegalArgumentException("The point isn't in the municipality");
        }
         */

        PointFactory poiFactory = new PointFactory();
        Point p = switch(type) {
            case Luogo -> poiFactory.createPointLuogo(name, coordinate, emergenza);
            case Evento -> poiFactory.createPointEvento(name, coordinate, start, end);
        };

        this.pointRepository.save(p);
    }
}