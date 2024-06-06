package it.unicam.progettoids2324.Services;

import it.unicam.progettoids2324.Repositories.PointRepository;
import it.unicam.progettoids2324.Services.Abstractions.PointServiceInterface;
import it.unicam.progettoids2324.dtos.PointEventoDTO;
import it.unicam.progettoids2324.dtos.PointLuogoDTO;
import it.unicam.progettoids2324.entities.Coordinates;
import it.unicam.progettoids2324.entities.Point.Point;
import it.unicam.progettoids2324.entities.Point.PointEvento;
import it.unicam.progettoids2324.entities.Point.PointLuogo;
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

    //public Set<Point> getPoints(){}
    public Set<PointEventoDTO> getEventoPoints() {
        Set<PointEventoDTO> points = new HashSet<>();
        for(Point p : this.pointRepository.findAll()) {
            if (p.getType() == PointType.Evento) {
                PointEvento pe = (PointEvento) p;
                points.add(pe.toDTO());
            }
        }
        return points;
    }

    public Set<PointLuogoDTO> getLuogoPoints() {
        Set<PointLuogoDTO> points = new HashSet<>();
        for(Point p : this.pointRepository.findAll()) {
            if (p.getType() == PointType.Luogo) {
                PointLuogo pl = (PointLuogo) p;
                points.add(pl.toDTO());
            }
        }
        return points;
    }


    @Override
    public void addPoi(PointType type, String name, Coordinates coordinate, String descrizioneLuogo, LocalDateTime start,
                       LocalDateTime end) {
        /*
        if(!osmService.isInTheMunicipality(coordinate, municipality)){
            throw new IllegalArgumentException("The point isn't in the municipality");
        }
         */

        PointFactory poiFactory = new PointFactory();
        Point p = switch(type) {
            case Luogo -> poiFactory.createPointLuogo(name, coordinate,descrizioneLuogo);
            case Evento -> poiFactory.createPointEvento(name, coordinate, start, end);
        };

        this.pointRepository.save(p);
    }
}