package it.unicam.progettoids2324.controllers;

import it.unicam.progettoids2324.Repositories.MunicipalityRepository;
import it.unicam.progettoids2324.Responses.Response;
import it.unicam.progettoids2324.Services.MunicipalityService;
import it.unicam.progettoids2324.dtos.MunicipalityDTO;
import it.unicam.progettoids2324.dtos.Requests.CreateMunicipalityRequest;
import it.unicam.progettoids2324.entities.Municipality;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/MunicipalityController")
public class MunicipalityController {
    private final MunicipalityService municipalityService;
    private final MunicipalityRepository municipalityRepository;

    @Autowired
    public MunicipalityController(MunicipalityService municipalityService, MunicipalityRepository municipalityRepository) {
        this.municipalityService = municipalityService;
        this.municipalityRepository = municipalityRepository;
    }

    @PostMapping("/CreateMunicipality")
    public ResponseEntity<Object> createMunicipality(@RequestBody CreateMunicipalityRequest request){
        this.municipalityService.createMunicipality(new Municipality(request.name(), request.province()));
        return ResponseEntity.ok().body("Municipality created");
    }

    @GetMapping("/GetMunicipalities")
    public ResponseEntity<Set<Municipality>> getMunicipalities(){
        return ResponseEntity.ok().body(this.municipalityService.getMunicipalities());
    }

    @GetMapping("/GetMunicipalityById/{munId}")
    public ResponseEntity<Municipality> getMunicipalityById(@PathVariable long munId){
        return ResponseEntity.ok().body(municipalityService.getMunicipalityById(munId));
    }

    @DeleteMapping("/DeleteMunicipality/{munId}")
    public ResponseEntity<Object> deleteMunicipality(@PathVariable long munId){
        this.municipalityService.deleteMunicipality(munId);
        return ResponseEntity.ok().body("Municipality deleted");
    }
}
