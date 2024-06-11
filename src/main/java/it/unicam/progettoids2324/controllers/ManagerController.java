package it.unicam.progettoids2324.controllers;

import it.unicam.progettoids2324.Responses.Response;
import it.unicam.progettoids2324.Services.ManagerService;
import it.unicam.progettoids2324.dtos.Requests.AddManagerRequest;
import it.unicam.progettoids2324.dtos.Requests.UpdateUserRole;
import it.unicam.progettoids2324.entities.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ManagersController")
public class ManagerController {
    private final ManagerService managerService;

    @Autowired
    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @PostMapping("/CreateManager")
    public ResponseEntity<Object> createManager(@RequestBody AddManagerRequest request){
        try{
            this.managerService.createManager(request.Email(),request.password());
            return ResponseEntity.ok().body("Manager Created");
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/GetManagers")
    public ResponseEntity<Object> getManagers(){
        return ResponseEntity.ok().body(this.managerService.getManagers());
    }

    @PutMapping("/UpdateRole/{managerId}")
    public ResponseEntity<Object> updateRole(@PathVariable long managerId, @RequestBody UpdateUserRole request) {
        try {
            this.managerService.updateRole(managerId, request.userId(), UserRole.valueOf(request.role()));
            return ResponseEntity.ok().body("User updated");
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
