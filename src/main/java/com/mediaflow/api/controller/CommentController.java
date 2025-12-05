package com.mediaflow.api.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediaflow.api.model.Comment;
import com.mediaflow.api.service.AuthenticationService;
import com.mediaflow.api.service.CommentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/comments")
@Tag(name = "Comments", description = "Comment management endpoints")
public class CommentController {

    private final CommentService commentService;
    private final AuthenticationService authenticationService;

    public CommentController(CommentService commentService, AuthenticationService authenticationService) {
        this.commentService = commentService;
        this.authenticationService = authenticationService;
    }

    @Operation(summary = "Get comments by content ID")
    @GetMapping("/content/{contentId}")
    public ResponseEntity<Page<Comment>> getCommentsByContentId(
            @PathVariable Integer contentId,
            @PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.ok(commentService.findByContentId(contentId, pageable));
    }

    @Operation(summary = "Create a comment")
    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        Integer userId = authenticationService.getCurrentUserId();
        String userEmail = authenticationService.getCurrentUserEmail();

        comment.setUserId(userId);
        // Asumimos que el cliente envía nameUser y avatarUrl, o podríamos obtenerlos
        // del user-service si tuviéramos comunicación
        // Por ahora, confiamos en lo que envía o ponemos defaults
        if (comment.getNameUser() == null) {
            comment.setNameUser(userEmail); // Fallback
        }
        if (comment.getAvatarUrl() == null) {
            comment.setAvatarUrl("default-avatar.png");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(commentService.create(comment));
    }

    @Operation(summary = "Delete a comment")
    @DeleteMapping("/{commentId}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Void> deleteComment(@PathVariable Integer commentId) {
        Comment comment = commentService.findById(commentId);

        if (!authenticationService.canAccess(comment.getUserId())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        commentService.delete(commentId);
        return ResponseEntity.noContent().build();
    }
}