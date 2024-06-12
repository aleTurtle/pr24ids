package it.unicam.progettoids2324.Repositories;

import it.unicam.progettoids2324.entities.Manager;
import it.unicam.progettoids2324.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ManagerRepository extends CrudRepository<Manager, Long> {
    @Query("SELECT u FROM Manager u WHERE u.email = ?1")
    Manager findByEmail(String email);

    @Query("SELECT u FROM Manager u WHERE u.id = ?1")
    Manager findById(long id);
}
