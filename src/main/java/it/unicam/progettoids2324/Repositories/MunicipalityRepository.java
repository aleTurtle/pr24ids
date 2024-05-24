package it.unicam.progettoids2324.Repositories;

import it.unicam.progettoids2324.entities.Municipality;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MunicipalityRepository extends CrudRepository<Municipality, Long> {
    @Query("SELECT m FROM Municipality m WHERE m.name = ?1 AND m.province = ?2")
    Municipality findByNameOrProvince(String name, String province);
}
