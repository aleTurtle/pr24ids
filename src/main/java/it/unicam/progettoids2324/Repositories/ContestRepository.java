package it.unicam.progettoids2324.Repositories;

import it.unicam.progettoids2324.entities.Contest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContestRepository extends CrudRepository<Contest, Long> {
}