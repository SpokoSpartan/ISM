package io.swagger.api.impl;

import io.swagger.logic.exception.NotFoundException;
import io.swagger.api.interfaces.EventApi;
import io.swagger.api.response.EventResponse;
import io.swagger.logic.service.EventService;
import io.swagger.model.CreateEventData;
import io.swagger.model.Events;
import io.swagger.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@PreAuthorize("isAuthenticated()")
@RestController
@RequestMapping("/event")
public class EventController implements EventApi {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @Override
    public ResponseEntity<Void> createEvent(CreateEventData body) {
        return null;
    }

    @Override
    public ResponseEntity<Void> updateEvent(CreateEventData body, Long eventId) {
        return null;
    }

    @Override
    public ResponseEntity<Void> removeEvent(Long eventId) {
        return null;
    }

    @Override
    public ResponseEntity<Set<EventResponse>> presentEvents() {
        return ResponseEntity.ok(eventService.getAllEvent());
    }

    @Override
    public ResponseEntity<EventResponse> presentEvent(Long eventId) throws NotFoundException {
        return ResponseEntity.ok(eventService.getEvent(eventId));
    }

    @Override
    public ResponseEntity<List<Events>> searchEvent(String searchSentence) {
        return null;
    }

    @Override
    public ResponseEntity<Void> markingAsPlayer(BigDecimal eventId) {
        return null;
    }

    @Override
    public ResponseEntity<List<Events>> gettingUserEvent() {
        return null;
    }

    @Override
    public ResponseEntity<List<User>> displayAttenders(BigDecimal eventId) {
        return null;
    }

    @Override
    public ResponseEntity<List<Events>> displaySuggestions() {
        return null;
    }
}
