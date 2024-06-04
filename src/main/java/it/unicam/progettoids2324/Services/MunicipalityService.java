package it.unicam.progettoids2324.Services;

import it.unicam.progettoids2324.Repositories.MunicipalityRepository;
import it.unicam.progettoids2324.Services.Abstractions.MunicipalityServiceInterface;
import it.unicam.progettoids2324.entities.Municipality;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class MunicipalityService implements MunicipalityServiceInterface{
    private final MunicipalityRepository municipalityRepository;

    public MunicipalityService(MunicipalityRepository municipalityRepository){
        this.municipalityRepository = municipalityRepository;
    }

    @Override
    public void createMunicipality(Municipality municipality) {
        if(this.municipalityRepository.findByNameOrProvince(municipality.getName(), municipality.getProvince()) != null){
            throw new IllegalArgumentException("Municipality already exist");
        }
        this.municipalityRepository.save(new Municipality(municipality.getName(), municipality.getProvince()));
    }

    @Override
    public void deleteMunicipality(long id) {
        if(this.municipalityRepository.findById(id) == null){
            throw new IllegalArgumentException("Municipality not found");
        }
        this.municipalityRepository.delete(this.getMunicipalityById(id));
    }

   // @Override
    public Set<Municipality> getMunicipalities() {
        Set<Municipality> muni = new HashSet<>();
        for(Municipality m : this.municipalityRepository.findAll()){
            muni.add(m);
        }
        return muni;
    }

    @Override
    public Municipality getMunicipalityById(long id) {
        return this.municipalityRepository.findById(id).orElseThrow();
    }
}
