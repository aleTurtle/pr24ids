package it.unicam.progettoids2324.controllers;

import it.unicam.progettoids2324.dtos.Requests.ApprovePoint;
import it.unicam.progettoids2324.dtos.Requests.CreatePointEventoRequest;
import it.unicam.progettoids2324.dtos.Requests.CreatePointLuogoRequest;

import it.unicam.progettoids2324.Services.PointService;
import it.unicam.progettoids2324.Services.UserService;


import it.unicam.progettoids2324.dtos.Requests.UpdateUserRole;
import it.unicam.progettoids2324.entities.Point.PointType;
import it.unicam.progettoids2324.entities.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/PointController")
public class PointController {
    private final PointService pointService;
    private final UserService UserService;

    @Autowired
    public PointController(PointService pointService, UserService userService) {
        this.UserService= userService;
        this.pointService = pointService;
    }

    @PostMapping("/CreatePointLuogo")
    public ResponseEntity<Object> addPointLuogo(@RequestBody CreatePointLuogoRequest request){
        try {
            this.pointService.addPoi(request.Userid(), PointType.Luogo, request.name(), request.coord(), request.luogoDescrizione(), null,
                    null);
            return ResponseEntity.ok().body("Point Created");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PostMapping("/CreatePointEvento")
    public ResponseEntity<Object> addPointEvento(@RequestBody CreatePointEventoRequest request){
        try {
            this.pointService.addPoi(request.Userid(), PointType.Evento, request.name(), request.coordinates(), null,
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

    @GetMapping("/GetPoints")
    public ResponseEntity<Object> getPoints() {
        return ResponseEntity.ok().body(this.pointService.getPoints());
    }

    @GetMapping("/GetPendingPoints")
    public ResponseEntity<Object> getPendingPoints() {
        return ResponseEntity.ok().body(this.pointService.getPendingPoints());
    }

    @PutMapping("/ApprovePoint/{userId}")
    public ResponseEntity<Object> approvePoint(@PathVariable long userId, @RequestBody ApprovePoint request) {
        try {
            this.pointService.approvePoint(userId, request.p());
        } catch (Exception e) {
            ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Point approved");
    }

    }
