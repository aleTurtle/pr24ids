package it.unicam.progettoids2324.entities;
import java.util.Date;
import java.util.Set;
import java.io.File;

import it.unicam.progettoids2324.dtos.ContentDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@NoArgsConstructor
public class Content {
    @Id
    @GeneratedValue
    private long id;
    @Setter
    private String title;
    @Setter
    private String description;
    @ElementCollection
    private Set<File> multimedia;
    private Date creationDate;
    @Getter
    @Setter
    private ContentState state;
    @ManyToOne
    @Setter
    private User author;
    @Getter
    @Setter
    private long PointIdRef;

    public Content(String title, String description, Set<File> multimedia, User author) {
        this.title = title;
        this.description = description;
        this.multimedia = multimedia;
        this.creationDate = new Date();
        this.author = author;
    }


    public void addFiles(Set<File> files) {
        this.multimedia.addAll(files);
    }
    public void removeFiles(Set<File> files) {
        this.multimedia.removeAll(files);
    }

    public ContentDTO toDTO() {
        return new ContentDTO(this.id, this.title, this.description, this.multimedia,this.creationDate,this.state,this.author,this.PointIdRef);
    }

}