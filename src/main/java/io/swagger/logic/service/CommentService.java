package io.swagger.logic.service;

import io.swagger.data.entity.Comment;
import io.swagger.data.entity.Event;
import io.swagger.data.repository.CommentRepository;
import io.swagger.data.repository.EventRepository;
import io.swagger.logic.exception.AuthorizationException;
import io.swagger.logic.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final EventRepository eventRepository;
    private final UserService userService;

    public CommentService(CommentRepository commentRepository, EventRepository eventRepository, UserService userService) {
        this.commentRepository = commentRepository;
        this.eventRepository = eventRepository;
        this.userService = userService;
    }

    @Transactional
    public long addComment(Long eventId, String content) throws NotFoundException, AuthorizationException {
        Event event = Optional.ofNullable(eventRepository.findOne(eventId))
                .orElseThrow(() -> new NotFoundException("Sorry, but this event not exists."));
        Comment comment = new Comment(content, userService.getLoggedInUserEntity());
        Comment savedComment = commentRepository.save(comment);
        event.addComment(savedComment);
        return comment.getId();
    }

    @Transactional
    public void editComment(Long commentId, String newContent) throws NotFoundException, AuthorizationException {
        Comment comment = getAndValidateAccessToComment(commentId);
        comment.setContent(newContent);
    }

    @Transactional
    public void removeComment(Long commentId) throws NotFoundException, AuthorizationException {
        Comment comment = getAndValidateAccessToComment(commentId);
        commentRepository.delete(comment);
    }

    private Comment getAndValidateAccessToComment(Long commentId) throws NotFoundException, AuthorizationException {
        Comment comment = Optional.ofNullable(commentRepository.findOne(commentId))
                .orElseThrow(() -> new NotFoundException("Sorry, but this comment not exists."));
        if (comment.getUser().getId() != userService.getLoggedInUserId()) {
            throw new NotFoundException("Sorry, but this comment not exists.");
        }
        return comment;
    }
}
