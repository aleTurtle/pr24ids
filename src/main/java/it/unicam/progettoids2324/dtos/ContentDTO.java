package it.unicam.progettoids2324.dtos;

import it.unicam.progettoids2324.entities.ContentState;
import it.unicam.progettoids2324.entities.User;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.ManyToOne;
import lombok.Setter;

import java.io.File;
import java.util.Date;
import java.util.Set;

public record ContentDTO(long id, String title, String description, Set<File>multimedia, Date creationDate, ContentState state, User author,long PointIdRef) {
}