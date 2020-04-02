package io.swagger.logic.service;

import io.swagger.api.response.CommentResponse;
import io.swagger.api.response.EventResponse;
import io.swagger.api.response.EventResponseBuilder;
import io.swagger.data.entity.Comment;
import io.swagger.data.entity.Event;
import io.swagger.data.entity.User;
import io.swagger.data.repository.EventRepository;
import io.swagger.logic.exception.AuthorizationException;
import io.swagger.logic.exception.CannotVoteEvception;
import io.swagger.logic.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final UserService userService;

    public EventService(EventRepository eventRepository, UserService userService) {
        this.eventRepository = eventRepository;
        this.userService = userService;
    }

    @Transactional
    // Set may be replaced by Page interface
    public Set<EventResponse> getAllEvent() {
        Iterable<Event> events = eventRepository.findAll();
        return StreamSupport.stream(events.spliterator(), false)
                .map(event -> mapEvent(event))
                .collect(Collectors.toSet());
    }

    @Transactional
    public EventResponse getEvent(Long id) throws NotFoundException, AuthorizationException {
        Event event = getEventById(id);
        User loggedUser = userService.getLoggedInUserEntity();
        EventResponse response = mapEvent(event);
        response.setAdditionalInformation(event.getAdditionalInfo());
        List<CommentResponse> comments = event.getComments().stream().map(comment -> mapComments(comment)).collect(Collectors.toList());
        Collections.sort(comments);
        response.setComments(comments);
        response.setCanVote(canVoteForEvent(event, loggedUser));
        return response;
    }

    private EventResponse mapEvent(Event event) {
        return new EventResponseBuilder()
                .setId(event.getId())
                .setImageUrl(event.getImageUrl())
                .setName(event.getName())
                .setMembersAmount(event.getMembers().size())
                .setNrOfPlayers(event.getNrOfPlayers())
                .setOwnerId(event.getOwner().getId())
                .setOwnerName(event.getOwner().getUsername())
                .setPlace(event.getPlace())
                .createEventResponse();
    }

    private CommentResponse mapComments(Comment comment) {
        return new CommentResponse(comment.getId(), comment.getContent(), comment.getUser().getId(), comment.getCreationDate());
    }

    @Transactional
    public void markAsMember(Long eventId) throws NotFoundException, AuthorizationException, CannotVoteEvception {
        Event event = getEventById(eventId);
        User loggedUser = userService.getLoggedInUserEntity();
        if (hasVotedForEvent(event.getMembers(), loggedUser)) {
            throw new CannotVoteEvception("Cannot vote for this event");
        }
        event.getMembers().add(loggedUser);
    }

    @Transactional
    public void markAsNotMember(Long eventId) throws NotFoundException, AuthorizationException {
        Event event = getEventById(eventId);
        User loggedUser = userService.getLoggedInUserEntity();
        if (hasVotedForEvent(event.getMembers(), loggedUser)) {
            event.getMembers().remove(loggedUser);
        }
    }

    private Event getEventById(Long id) throws NotFoundException {
        return Optional.ofNullable(eventRepository.findOne(id)).orElseThrow(
                () ->new NotFoundException("Sorry, We cannot find this event"));
    }

    private boolean canVoteForEvent(Event event, User loggedUser) {
        return !(hasVotedForEvent(event.getMembers(), loggedUser) || event.getOwner().getId().equals(loggedUser.getId()));
    }

    private Boolean hasVotedForEvent(Set<User> members, User loggedUser) {
        return members.contains(loggedUser);
    }
}
