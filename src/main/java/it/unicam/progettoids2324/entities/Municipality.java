package it.unicam.progettoids2324.entities;

import it.unicam.progettoids2324.dtos.MunicipalityDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
public class Municipality {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String province;

    public Municipality(String name, String province) {
        this.name = name;
        this.province = province;
    }

    public MunicipalityDTO toDTO(){
        return new MunicipalityDTO(this.id, this.name, this.province);
    }
}
