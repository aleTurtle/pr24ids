package it.unicam.progettoids2324.Repositories;

import it.unicam.progettoids2324.entities.Report;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReportRepository extends CrudRepository <Report,Long> {
    @Query("SELECT u FROM Report u WHERE u.id = ?1")
    Report findById(long id);
}
