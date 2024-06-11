package it.unicam.progettoids2324.Repositories;

import it.unicam.progettoids2324.entities.Content;
import it.unicam.progettoids2324.entities.Contest;
import org.springframework.data.repository.CrudRepository;

public interface ContentRepository extends CrudRepository<Content, Long> {
}