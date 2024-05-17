package it.unicam.progettoids2324.controllers;

import it.unicam.progettoids2324.Services.UserService;
import it.unicam.progettoids2324.dtos.Requests.AddUserRequest;
import it.unicam.progettoids2324.entities.Utente;
import it.unicam.progettoids2324.handlers.UtenteHandler;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Users")
public class UtenteController {
    private final UserService userService;
    private final UtenteHandler utenteHandler;

    @Autowired
    public UtenteController(UserService userService, UtenteHandler utenteHandler, UtenteHandler utenteHandler1) {
        this.userService = userService;
        this.utenteHandler = utenteHandler;
    }


    @GetMapping("GetUsers")
    public ResponseEntity<?> getUtenti() {
        return ResponseEntity.ok(this.utenteHandler.getUtenti());
    }

    @PostMapping("/addUsers")
    public ResponseEntity<Object> createUser(@RequestBody AddUserRequest request) {
        try {
            this.userService.addUser(new Utente(request.Email(), request.Password()));
            return ResponseEntity.ok().body("User created successfully.");
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
