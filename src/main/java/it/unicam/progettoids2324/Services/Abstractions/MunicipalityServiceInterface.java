package it.unicam.progettoids2324.Services.Abstractions;

import it.unicam.progettoids2324.entities.Municipality;

import java.util.Set;

public interface MunicipalityServiceInterface {

    /**
     * Create a new municpality
     * @throws IllegalArgumentException if the municipality already exist
     */
    void createMunicipality(Municipality municipality);


    /**
     * Delete the municipality with the id
     * @param id
     * @throws IllegalArgumentException if the municpality doesn't exist
     */
    void deleteMunicipality(long id);

    /**
     * Return all the municipalities
     * @return all the municipalities with their details
     */
    //Set<Municipality> getMunicipalities();

    /**
     * Find a municipality by the id
     * @param id to search the municipality
     * @return Municipality with the id
     * @throws IllegalArgumentException if the municipality doesn't exist
     */
    Municipality getMunicipalityById(long id);

}
