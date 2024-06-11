package it.unicam.progettoids2324.dtos.Requests;

import java.io.File;
import java.util.Set;

public record CreateContentRequest(
        long id,
        String title,
        String description,
        Set<File> multimedia
) {
}
