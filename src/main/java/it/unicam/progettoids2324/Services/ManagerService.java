package it.unicam.progettoids2324.Services;

import it.unicam.progettoids2324.Repositories.ManagerRepository;
import it.unicam.progettoids2324.Repositories.UserRepository;
import it.unicam.progettoids2324.Services.Abstractions.ManagerServiceInterface;
import it.unicam.progettoids2324.entities.Manager;
import it.unicam.progettoids2324.entities.User;
import it.unicam.progettoids2324.entities.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ManagerService implements ManagerServiceInterface {

    private final ManagerRepository managerRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public ManagerService(ManagerRepository managerRepository, UserRepository userRepository, UserService userService) {
        this.managerRepository = managerRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }
    @Override
    public void createManager(String email, String password) {
        if(this.managerRepository.findByEmail(email) != null){
            throw new IllegalArgumentException("Email already exists");
        }
        this.managerRepository.save(new Manager(email, password));

    }

    @Override
    public Set<Manager> getManagers() {
        Set<Manager> managers = new HashSet<>();
        for(Manager m : this.managerRepository.findAll()){
            managers.add(m);
        }
        return managers;
    }

    public void updateRole(long managerId, long toUpdateUserId, UserRole role) {
        User u = this.userService.getUserById(toUpdateUserId);
        u.setRole(role);
        this.userRepository.save(u);
    }
}
