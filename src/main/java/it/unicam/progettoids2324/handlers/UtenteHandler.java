package it.unicam.progettoids2324.handlers;

import it.unicam.progettoids2324.entities.Utente;
import it.unicam.progettoids2324.repositories.UtenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteHandler {
    private final UtenteRepository utenteRepository;

    public UtenteHandler(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    public List<Utente> getUtenti() {
        return (List<Utente>) this.utenteRepository.findAll();
    }

    public List<Utente> addUser(Utente utente){
        utente = new Utente();
        this.utenteRepository.save(utente);
        return (List<Utente>) this.utenteRepository.findAll();
    }
}
