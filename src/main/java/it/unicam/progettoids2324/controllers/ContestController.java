package it.unicam.progettoids2324.controllers;


import it.unicam.progettoids2324.Services.ContestService;
import it.unicam.progettoids2324.Services.UserService;
import it.unicam.progettoids2324.dtos.Requests.CreateContestRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contests")
public class ContestController {
    private final ContestService contestService;
    private final UserService userService;

    @Autowired
    public ContestController(ContestService contestService, UserService userService) {
        this.contestService = contestService;
        this.userService = userService;
    }

    @GetMapping("/getContests/{userid}")
    public ResponseEntity<Object> getContests(@PathVariable long userid) {
        try {
            return ResponseEntity.ok(this.contestService.getContests(userid));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/createContest/{userId}")
    public ResponseEntity<Object> createContest(@PathVariable long userId, @RequestBody CreateContestRequest request) {
        try {
            this.contestService.createContest(request.userId(), request.name(), request.description(),
                    request.start(), request.end(),request.winnerId());
            return ResponseEntity.ok("Contest created successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/openContest/{userId}/{contestId}")
    public ResponseEntity<Object> openContest(@PathVariable long userId, @PathVariable long contestId) {
        try {
            this.contestService.openContest(userId, contestId);
            return ResponseEntity.ok("Contest opened successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/closeContest/{userId}/{contestId}")
    public ResponseEntity<Object> closeContest(@PathVariable long userId, @PathVariable long contestId) {
        try {
            this.contestService.closeContest(userId, contestId);
            return ResponseEntity.ok("Contest closed successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


 
}