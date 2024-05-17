package it.unicam.progettoids2324.repositories;

import it.unicam.progettoids2324.entities.Utente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends CrudRepository<Utente, Integer> {
@Query("SELECT u FROM Utente u WHERE u.email = ?1")
    Utente findByEmail(String email);
}
