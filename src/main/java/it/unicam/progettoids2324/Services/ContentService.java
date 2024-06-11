package it.unicam.progettoids2324.Services;

import it.unicam.progettoids2324.Repositories.ContentRepository;
import it.unicam.progettoids2324.Services.Abstractions.ContentServiceInterface;
import it.unicam.progettoids2324.dtos.ContentDTO;
import it.unicam.progettoids2324.entities.*;
import it.unicam.progettoids2324.entities.Point.Point;
import it.unicam.progettoids2324.entities.Point.PointFactory;
import it.unicam.progettoids2324.entities.Point.PointState;
import it.unicam.progettoids2324.entities.Point.PointType;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Service
public class ContentService implements ContentServiceInterface {
    private final ContentRepository contentRepository;
    private final PointService pointService;
    private final ContestService contestService;
    private final UserService userService;

    public ContentService(ContentRepository contentRepository, PointService pointService,
                          ContestService contestService,UserService userService) {

        this.contentRepository = contentRepository;
        this.pointService = pointService;
        this.contestService = contestService;
        this.userService = userService;
    }

    @Override
    public Content getContent(long contentId) {
        return this.contentRepository.findById(contentId).orElseThrow();
    }
    public ContentDTO getContentDetails(long contentId){
        return this.getContent(contentId).toDTO();
    }

    @Override
    public Set<ContentDTO> getAllContents() {
        Set<ContentDTO> contents = new HashSet<>();
        for(Content c : this.contentRepository.findAll()) {
            contents.add(c.toDTO());
        }
        return contents;
    }

    private void checkRole(UserRole role) {
        if (role != UserRole.CURATOR) {
            throw new IllegalArgumentException("The user is not authorized ");
        }
    }
    public void deleteContent(long contentId) {
        this.contentRepository.delete(this.getContent(contentId));
    }

    public void approveContent(long userId, long contentId) {
        this.checkRole(this.userService.getUserById(userId).getRole());
        Content c = this.getContent(contentId);
        c.setState(ContentState.APPROVED);
        this.contentRepository.save(c);
    }

    public void createContent(Long userId, String title, String description, Set<File> multimedia) throws Exception{

        Content c = new Content(title,description,multimedia,this.userService.getUserById(userId));
        UserRole r = this.userService.getUserById(userId).getRole();

        if ( r == UserRole.CURATOR || r == UserRole.AUTHORIZED_CONTRIBUTOR) {
            c.setState(ContentState.APPROVED);
        } else if (r  == UserRole.CONTRIBUTOR) {
            c.setState(ContentState.PENDING);
        } else {
            throw new Exception("The user is not authorized to create a content");
        }
        this.contentRepository.save(c);
    }

    public Set<ContentDTO> getPendingContents(long userId) {
        this.checkRole(this.userService.getUserById(userId).getRole());

        Set<ContentDTO> contributions = new HashSet<>();
        for (Content c : this.contentRepository.findAll()) {
            if (c.getState() == ContentState.PENDING) {
                contributions.add(c.toDTO());
            }
        }
        return contributions;
    }

    public void associateContentToPoint(long contentId, long PointIdRef){
        this.getContent(contentId).setPointIdRef(PointIdRef);
    }
}