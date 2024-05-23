package it.unicam.progettoids2324.Services.Abstractions;

import it.unicam.progettoids2324.entities.User;

import java.util.Set;

public interface UserServiceInterface {

    void addUser(User user);
    Set<User> getUsers();

    void CreateUser(User user);
}
