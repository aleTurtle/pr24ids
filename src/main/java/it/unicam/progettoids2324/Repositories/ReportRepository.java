package it.unicam.progettoids2324.Repositories;

import it.unicam.progettoids2324.entities.Reports;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReportRepository extends CrudRepository <Reports,Long> {
    @Query("SELECT u FROM Reports u WHERE u.id = ?1")
    Reports findById(long id);
}
