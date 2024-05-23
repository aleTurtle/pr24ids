package it.unicam.progettoids2324.controllers;

import it.unicam.progettoids2324.Services.UserService;
import it.unicam.progettoids2324.dtos.Requests.AddUserRequest;
import it.unicam.progettoids2324.dtos.UserDTO;
import it.unicam.progettoids2324.entities.User;
import it.unicam.progettoids2324.repositories.UserRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;


@RestController
@RequestMapping("/Users")
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }


    @GetMapping("/GetUsers")
    public Set<UserDTO> getUsers() {
        Set<UserDTO> users = new HashSet<>();
        for(User u : userRepository.findAll()) {
            System.out.println("Email: "+ u.getEmail());
            System.out.println("Password: "+ u.getPassword());
            users.add(u.toDTO());
        }
        return users;
    }

    @PostMapping("/CreateUsers")
    public ResponseEntity<Object> addUser(@RequestBody AddUserRequest request) {
        try{
            this.userService.CreateUser(new User(request.Email(), request.Password()));
            return ResponseEntity.ok().body("User created");
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
