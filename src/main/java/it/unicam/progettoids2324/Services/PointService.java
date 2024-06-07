package it.unicam.progettoids2324.Services;

import it.unicam.progettoids2324.Repositories.PointRepository;
import it.unicam.progettoids2324.Services.Abstractions.PointServiceInterface;
import it.unicam.progettoids2324.dtos.PointDTO;
import it.unicam.progettoids2324.dtos.PointEventoDTO;
import it.unicam.progettoids2324.dtos.PointLuogoDTO;
import it.unicam.progettoids2324.entities.Coordinates;
import it.unicam.progettoids2324.entities.Municipality;
import it.unicam.progettoids2324.entities.Point.*;
import it.unicam.progettoids2324.entities.User;
import it.unicam.progettoids2324.entities.UserRole;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
public class PointService implements PointServiceInterface {
    private final UserService userService;
    private final PointRepository pointRepository;

    private final OsmService osmService;

    public PointService(PointRepository pointRepository,  OsmService osmService, UserService userService) {
        this.pointRepository = pointRepository;
        this.osmService = osmService;
        this.userService = userService;
    }

    @Override
    public Set<PointDTO> getEventoPoints() {
        Set<PointDTO> points = new HashSet<>();
        for (Point p : this.pointRepository.findAll()) {
            if (p.getType() == PointType.Evento) {
                points.add(p.toDTO());
            }
        }
        return points;
    }

    @Override
    public Set<PointDTO> getLuogoPoints() {
        Set<PointDTO> points = new HashSet<>();
        for (Point p : this.pointRepository.findAll()) {
            if (p.getType() == PointType.Luogo) {
                points.add(p.toDTO());
            }
        }
        return points;
    }

    public Set<PointDTO> getPoints() {
        Set<PointDTO> points = new HashSet<>();
        for (Point p : this.pointRepository.findAll()) {
            points.add(p.toDTO());
        }
        return points;
    }

    public Set<PointDTO> getPendingPoints() {
        Set<PointDTO> points = new HashSet<>();
        for (Point p : this.pointRepository.findAll()) {
            if (p.getPointState() == PointState.PENDING) {
                points.add(p.toDTO());
            }
        }
        return points;
    }

    public void addPoi(Long userId, PointType type, String name, Coordinates coordinate, String descrizioneLuogo, LocalDateTime start,
                       LocalDateTime end) {
        /*
       String  municipalityName = Municipality.class.getName();
        if(!osmService.isInTheMunicipality(coordinate, municipalityName)){
            throw new IllegalArgumentException("The point isn't in the municipality");
        }
        */
        PointFactory poiFactory = new PointFactory();
        Point p = switch (type) {
            case Luogo -> poiFactory.createPointLuogo(name, coordinate, descrizioneLuogo);
            case Evento -> poiFactory.createPointEvento(name, coordinate, start, end);
        };

        User user = this.userService.getUserById(userId);
        if(user != null){

            UserRole role = this.userService.getUserById(userId).getRole();
            if (role == UserRole.CONTRIBUTOR) {
                p.setPointState(PointState.PENDING);
            } else {
                p.setPointState(PointState.APPROVED);
            }
            this.pointRepository.save(p);
        }
    }

    public void approvePoint(long userId, Point p) {
        if (this.userService.getUserById(userId).getRole() != UserRole.CURATOR) {
            throw new IllegalArgumentException("Utente non autorizzato");
        }
        p.setPointState(PointState.APPROVED);
        this.pointRepository.save(p);
    }


    }