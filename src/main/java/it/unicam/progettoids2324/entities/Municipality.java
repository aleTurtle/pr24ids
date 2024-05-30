package it.unicam.progettoids2324.entities;

import it.unicam.progettoids2324.Repositories.ContestRepository;
import it.unicam.progettoids2324.dtos.MunicipalityDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@NoArgsConstructor
@Entity
public class Municipality {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String province;
    @OneToMany(cascade = CascadeType.REMOVE)
    private Set<Contest> contests;
    @OneToMany(cascade = CascadeType.REMOVE)
    private Set<Point> points;

    /**
     *
     * @param name
     * @param province
     */
    public Municipality(String name, String province) {
        this.name = name;
        this.province = province;
    }

    public MunicipalityDTO toDTO(){
        return new MunicipalityDTO(this.id, this.name, this.province);
    }

    public void addContest(Contest contest) {
        this.contests.add(contest);
    }

    public void addPoint(Point point) {
        this.points.add(point);
    }
}
