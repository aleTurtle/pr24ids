package it.unicam.progettoids2324.controllers;


import it.unicam.progettoids2324.Services.ContentService;
import it.unicam.progettoids2324.Services.UserService;
import it.unicam.progettoids2324.dtos.Requests.AssociateContentRequest;
import it.unicam.progettoids2324.dtos.Requests.CreateContentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/contents")
public class ContentController {
    private final ContentService contentService;
    private final UserService userService;

    @Autowired
    public ContentController( ContentService contentService, UserService userService) {
        this. contentService = contentService;
        this.userService = userService;
    }

    @GetMapping("/GetContents")
    public ResponseEntity<Object> getContents() {
        return ResponseEntity.ok().body(this.contentService.getAllContents());
    }

    @GetMapping("/getContents/{contentId}")
    public ResponseEntity<Object> getContentDetails(@PathVariable long contentId) {
        try {
            return ResponseEntity.ok(this.contentService.getContentDetails(contentId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getPendingContents/{userId}")
    public ResponseEntity<Object> getPendingContents(@PathVariable long userId) {
        try {
            return ResponseEntity.ok(this.contentService.getPendingContents(userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PostMapping("/createContent/{userId}")
    public ResponseEntity<Object> createContent(@PathVariable long userId,
                                                @RequestBody CreateContentRequest request) {
        try {
            this.contentService.createContent(userId, request.title(),
                    request.description(), request.multimedia());
            return ResponseEntity.ok("Content created successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PutMapping("/approveContent/{userId}/{contentId}")
    public ResponseEntity<Object> approveContent(@PathVariable long userId, @PathVariable long contentId) {
        try {
            this.contentService.approveContent(userId, contentId);
            return ResponseEntity.ok("Content approved successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/associateContent/{userId}/{contentId}")
    public ResponseEntity<Object> associateContent(@PathVariable long userId, @RequestBody AssociateContentRequest request) {
        try {
            this.contentService.associateContentToPoint(request.contentId(), request.PointIdRef());
            return ResponseEntity.ok("Content associated to the point successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



    @DeleteMapping("/deleteContent/{contentId}")
    public ResponseEntity<Object> deleteContent(@PathVariable long contentId) {
        try {
            this.contentService.deleteContent(contentId);
            return ResponseEntity.ok("Content deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}