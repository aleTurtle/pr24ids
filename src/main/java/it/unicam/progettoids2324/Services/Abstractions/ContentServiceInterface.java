package it.unicam.progettoids2324.Services.Abstractions;

import it.unicam.progettoids2324.dtos.ContentDTO;
import it.unicam.progettoids2324.entities.Content;
import it.unicam.progettoids2324.entities.Contest;
import it.unicam.progettoids2324.entities.User;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Set;

public interface ContentServiceInterface {

    Content getContent(long contentId);

    void createContent(Long userId, String title, String description, Set<File> multimedia) throws Exception;

    public void deleteContent(long contentId);

    void approveContent(long userId, long contentId);

    Set<ContentDTO> getPendingContents(long userId);

    Set<ContentDTO> getAllContents();

    void associateContentToPoint(long contentId, long PointIdRef);

}