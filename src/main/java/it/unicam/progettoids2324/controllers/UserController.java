package it.unicam.progettoids2324.controllers;

import it.unicam.progettoids2324.Responses.Response;
import it.unicam.progettoids2324.Services.UserService;
import it.unicam.progettoids2324.dtos.Requests.AddUserRequest;
import it.unicam.progettoids2324.dtos.UserDTO;
import it.unicam.progettoids2324.entities.User;
import it.unicam.progettoids2324.repositories.UserRepository;
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
    public ResponseEntity<Response<Set<UserDTO>>> getUsers() {
        Set<UserDTO> users = new HashSet<>();
        for(User u : userRepository.findAll()) {
            users.add(u.toDTO());
        }
        Response<Set<UserDTO>> response = new Response<>("User list retrived successfully", users);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/CreateUsers")
    public ResponseEntity<Object> addUser(@RequestBody AddUserRequest request) {
        try{
            User user = new User(request.Email(), request.Password());
            this.userService.CreateUser(user);
            Response<User> response = new Response<>("User created successfully", user);
            return ResponseEntity.ok(response);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
