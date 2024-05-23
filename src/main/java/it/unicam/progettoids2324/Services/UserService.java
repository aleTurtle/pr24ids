package it.unicam.progettoids2324.Services;

import it.unicam.progettoids2324.Services.Abstractions.UserServiceInterface;
import it.unicam.progettoids2324.entities.User;
import it.unicam.progettoids2324.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserServiceInterface {
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(User user) {
        if(this.userRepository.findByEmail(user.getEmail()) != null){
            throw new IllegalArgumentException("Email already exists");
        }
        User u = this.userRepository.save(new User(user.getEmail(), user.getPassword()));
    }

    @Override
    public Set<User> getUsers() {
        Set<User> users = new HashSet<>();
        for(User u : this.userRepository.findAll()) {
            users.add(u);
        }
        return users;
    }

    @Override
    public void CreateUser(User user){
        if(this.userRepository.findByEmail(user.getEmail()) != null){
            throw new IllegalArgumentException("Email already exists");
        }
        User u = this.userRepository.save(new User(user.getEmail(), user.getPassword()));
    }
}
