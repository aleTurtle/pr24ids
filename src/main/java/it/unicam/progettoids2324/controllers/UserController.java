package it.unicam.progettoids2324.controllers;

import it.unicam.progettoids2324.Services.UserService;
import it.unicam.progettoids2324.dtos.Requests.AddUserRequest;
import it.unicam.progettoids2324.dtos.Requests.UpdateUserRole;
import it.unicam.progettoids2324.entities.User;
import it.unicam.progettoids2324.entities.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/UsersController")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/CreateUsers")
    public ResponseEntity<Object> createUser(@RequestBody AddUserRequest request) {
        try{
            this.userService.createUser(request.Email(), request.Password());
            return ResponseEntity.ok().body("User created");
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/GetUsers")
    public ResponseEntity<Object> getUsers() {
        return ResponseEntity.ok().body(this.userService.getUsers());
    }

    @GetMapping("/GetUserById/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable long userId){
        return ResponseEntity.ok().body(userService.getUserById(userId));
    }

    @DeleteMapping("/DeleteUser/{userId}")
    public ResponseEntity<Object> deleteUser(@PathVariable long userId){
        this.userService.deleteUser(userId);
        return ResponseEntity.ok().body("User deleted");
    }


}
