package it.unicam.progettoids2324.Services.Abstractions;

import it.unicam.progettoids2324.entities.Manager;

import java.util.Set;

public interface ManagerServiceInterface {

    void createManager(String email, String password);

    Set<Manager> getManagers();

    Manager getManagerById(long id);
}
