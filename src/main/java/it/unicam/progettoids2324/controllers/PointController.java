package it.unicam.progettoids2324.controllers;

import it.unicam.progettoids2324.dtos.Requests.CreatePointEventoRequest;
import it.unicam.progettoids2324.dtos.Requests.CreatePointLuogoRequest;

import it.unicam.progettoids2324.Services.PointService;

import it.unicam.progettoids2324.entities.Point.PointType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/PointController")
public class PointController {
    private final PointService pointService;

    @Autowired
    public PointController(PointService pointService) {
        this.pointService = pointService;
    }

    @PostMapping("/CreatePointLuogo")
    public ResponseEntity<Object> addPointLuogo(@RequestBody CreatePointLuogoRequest request){
        try {
            this.pointService.addPoi(PointType.Luogo, request.name(), request.coord(), request.luogoDescrizione(), null,
                    null);
            return ResponseEntity.ok().body("Point Created");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PostMapping("/CreatePointEvento")
    public ResponseEntity<Object> addPointEvento(@RequestBody CreatePointEventoRequest request){
        try {
            this.pointService.addPoi(PointType.Evento, request.name(), request.coordinates(), null,
                    request.start(), request.end());
            return ResponseEntity.ok().body("Point Created");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @GetMapping("/GetEventoPoints")
    public ResponseEntity<Object> getEventoPoints() {
        return ResponseEntity.ok().body(this.pointService.getEventoPoints());
    }

    @GetMapping("/GetluogoPoints")
    public ResponseEntity<Object> getLuogoPoints() {
        return ResponseEntity.ok().body(this.pointService.getLuogoPoints());
    }





    }
