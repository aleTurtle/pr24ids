package it.unicam.progettoids2324.Services;

import it.unicam.progettoids2324.Services.Abstractions.UserServiceInterface;
import it.unicam.progettoids2324.entities.Utente;
import it.unicam.progettoids2324.repositories.UtenteRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceInterface {
    private final UtenteRepository utenteRepository;

    public UserService(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    @Override
    public void addUser(Utente user) {
        Utente u = this.utenteRepository.save(new Utente(user.getEmail(), user.getPassword()));
    }
}
