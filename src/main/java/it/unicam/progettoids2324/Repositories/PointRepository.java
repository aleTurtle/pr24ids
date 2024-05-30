package it.unicam.progettoids2324.Repositories;

import it.unicam.progettoids2324.entities.Point;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointRepository extends CrudRepository<Point, Long> {
}
