package it.unicam.progettoids2324.controllers;

import it.unicam.progettoids2324.Repositories.PointRepository;
import it.unicam.progettoids2324.Services.OsmService;
import it.unicam.progettoids2324.Services.PointService;
import it.unicam.progettoids2324.dtos.Requests.CreatePoiRequest;
import it.unicam.progettoids2324.entities.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/PointController")
public class PointController {
    private final PointService pointService;
    private final PointRepository pointRepository;
    private final OsmService osmService;

    @Autowired
    public PointController(PointService pointService, PointRepository pointRepository, OsmService osmService) {
        this.pointService = pointService;
        this.pointRepository = pointRepository;
        this.osmService = osmService;
    }

    @PostMapping("/CreatePOI")
    public ResponseEntity<Object> addPoi(@RequestBody CreatePoiRequest request){
        this.pointService.addPoi(request.coord(), request.municipality());
        return ResponseEntity.ok().body("Point Created");
    }

}
