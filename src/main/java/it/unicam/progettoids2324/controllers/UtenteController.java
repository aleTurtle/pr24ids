package it.unicam.progettoids2324.controllers;

import it.unicam.progettoids2324.dtos.Requests.AddUserRequest;
import it.unicam.progettoids2324.handlers.UtenteHandler;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UtenteController {
    private final UtenteHandler utenteHandler;

    public UtenteController(UtenteHandler utenteHandler) {
        this.utenteHandler = utenteHandler;
    }

    @GetMapping("GetUsers")
    public ResponseEntity<?> getUtenti() {
        return ResponseEntity.ok(this.utenteHandler.getUtenti());
    }

    @PostMapping("AddUsers")
    public ResponseEntity<?> addUtenti(@RequestBody AddUserRequest request) {
        return
    }
}
