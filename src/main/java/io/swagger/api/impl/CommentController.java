package io.swagger.api.impl;

import io.swagger.logic.exception.AuthorizationException;
import io.swagger.logic.exception.NotFoundException;
import io.swagger.api.interfaces.CommentApi;
import io.swagger.logic.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@PreAuthorize("isAuthenticated()")
@RestController
@RequestMapping("/comment")
public class CommentController implements CommentApi {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @Override
    public ResponseEntity<Long> createComment(BigDecimal eventId, String content) throws NotFoundException, AuthorizationException {
        return ResponseEntity.ok(commentService.addComment(eventId.longValue(), content));
    }

    @Override
    public ResponseEntity<Void> updateComment(BigDecimal commentId, String content) throws NotFoundException, AuthorizationException {
        commentService.editComment(commentId.longValue(), content);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> removeComment(BigDecimal commentId) throws NotFoundException, AuthorizationException {
        commentService.removeComment(commentId.longValue());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
