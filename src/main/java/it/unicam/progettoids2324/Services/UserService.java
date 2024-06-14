package it.unicam.progettoids2324.Services;

import it.unicam.progettoids2324.Services.Abstractions.UserServiceInterface;
import it.unicam.progettoids2324.entities.Point.Point;
import it.unicam.progettoids2324.entities.User;
import it.unicam.progettoids2324.Repositories.UserRepository;
import it.unicam.progettoids2324.entities.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserServiceInterface {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(String email, String password) {
        if(this.userRepository.findByEmail(email) != null){
            throw new IllegalArgumentException("Email already exists");
        }
        this.userRepository.save(new User(email, password));
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
    public User getUserById(long id) {
        return this.userRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteUser(long id){
        this.userRepository.delete(getUserById(id));
    }


    public void updateRole(long userId, long toUpdateUserId, String role) {
        if (this.getUserById(userId).getRole() != UserRole.MANAGER) {
            throw new IllegalArgumentException("User not authorized to change roles");
        }
        User u = this.getUserById(toUpdateUserId);

        u.setRole(this.getUserById(userId).getRole().fromString(role));

        this.userRepository.save(u);
    }







}
