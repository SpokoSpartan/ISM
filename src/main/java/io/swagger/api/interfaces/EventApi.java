package io.swagger.api.interfaces;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;
import io.swagger.logic.exception.AuthorizationException;
import io.swagger.logic.exception.CannotVoteEvception;
import io.swagger.logic.exception.NotFoundException;
import io.swagger.api.response.EventResponse;
import io.swagger.model.CreateEventData;
import io.swagger.model.Event;
import io.swagger.model.Events;
import io.swagger.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-29T11:14:52.100Z[GMT]")
public interface EventApi {

    @ApiOperation(value = "Create event", nickname = "createEvent", authorizations = {
            @Authorization(value = "petstore_auth", scopes = {
                    @AuthorizationScope(scope = "write", description = "modify data"),
                    @AuthorizationScope(scope = "read", description = "read data")
            })})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Event has been created"),
            @ApiResponse(code = 400, message = "User not sent name or place"),
            @ApiResponse(code = 403, message = "User does not have access to this applicaion")})
    @RequestMapping(value = "/create",
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Void> createEvent(@ApiParam(value = "Event body", required = true) @Valid @RequestBody CreateEventData body);

    @ApiOperation(value = "Update event", nickname = "updateEvent", notes = "", authorizations = {
            @Authorization(value = "petstore_auth", scopes = {
                    @AuthorizationScope(scope = "write", description = "modify data"),
                    @AuthorizationScope(scope = "read", description = "read data")
            })})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Event has been updated"),
            @ApiResponse(code = 400, message = "User not sent name or place"),
            @ApiResponse(code = 403, message = "User does not have access to this applicaion"),
            @ApiResponse(code = 404, message = "Event not found")})
    @RequestMapping(
            value = "/update/{eventId}",
            consumes = {"application/json", "application/x-www-form-urlencoded"},
            method = RequestMethod.PUT)
    ResponseEntity<Void> updateEvent(@ApiParam(value = "Event body", required = true) @Valid @RequestBody CreateEventData body,
                                     @ApiParam(value = "ID of event to update", required = true) @PathVariable("eventId") Long eventId
    );

    @ApiOperation(value = "Remove event", nickname = "removeEvent", notes = "", authorizations = {
            @Authorization(value = "petstore_auth", scopes = {
                    @AuthorizationScope(scope = "write", description = "modify data"),
                    @AuthorizationScope(scope = "read", description = "read data")
            })})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Event has been reoved"),
            @ApiResponse(code = 403, message = "User does not have access to this applicaion"),
            @ApiResponse(code = 404, message = "Event not found")})
    @RequestMapping(
            value = "/delete/{eventId}",
            method = RequestMethod.DELETE)
    ResponseEntity<Void> removeEvent(@ApiParam(value = "ID of event to reove", required = true) @PathVariable("eventId") Long eventId);

    @ApiOperation(value = "Present all events", nickname = "presentEvents", response = Events.class, responseContainer = "List", authorizations = {
            @Authorization(value = "petstore_auth", scopes = {
                    @AuthorizationScope(scope = "write", description = "modify data"),
                    @AuthorizationScope(scope = "read", description = "read data")
            })})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of events", response = Events.class, responseContainer = "List"),
            @ApiResponse(code = 403, message = "User does not have access to this application")})
    @RequestMapping(
            value = "/get",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<Set<EventResponse>> presentEvents();

    @ApiOperation(value = "Present event", nickname = "presentEvent", response = Event.class, authorizations = {
            @Authorization(value = "petstore_auth", scopes = {
                    @AuthorizationScope(scope = "write", description = "modify data"),
                    @AuthorizationScope(scope = "read", description = "read data")
            })})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Event of given id", response = Event.class),
            @ApiResponse(code = 403, message = "User does not have access to this application"),
            @ApiResponse(code = 404, message = "Event not found")})
    @RequestMapping(
            value = "/get/{eventId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<EventResponse> presentEvent(@ApiParam(value = "ID of event to present", required = true) @PathVariable("eventId") Long eventId
    ) throws NotFoundException, AuthorizationException;

    @ApiOperation(value = "Present list of searched event", nickname = "searchEvent", response = Events.class, responseContainer = "List", authorizations = {
            @Authorization(value = "petstore_auth", scopes = {
                    @AuthorizationScope(scope = "write", description = "modify data"),
                    @AuthorizationScope(scope = "read", description = "read data")
            })})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Events found", response = Events.class, responseContainer = "List"),
            @ApiResponse(code = 403, message = "User does not have access to this application")})
    @RequestMapping(
            value = "/search/{searchSentence}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<Events>> searchEvent(@ApiParam(value = "sentence from event to search", required = true) @PathVariable("searchSentence") String searchSentence);

    @ApiOperation(value = "Add information about beeing player", nickname = "markingAsPlayer", authorizations = {
            @Authorization(value = "petstore_auth", scopes = {
                    @AuthorizationScope(scope = "write", description = "modify data"),
                    @AuthorizationScope(scope = "read", description = "read data")
            })})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User marked as member"),
            @ApiResponse(code = 400, message = "User is already member of this event"),
            @ApiResponse(code = 403, message = "User does not have access to this applicaion"),
            @ApiResponse(code = 404, message = "Event not found")})
    @RequestMapping(
            value = "/markingAsPlayer/{eventId}",
            method = RequestMethod.POST)
    ResponseEntity<Void> markingAsPlayer(@ApiParam(value = "Event to mark as not member", required = true) @PathVariable("eventId") BigDecimal eventId) throws AuthorizationException, CannotVoteEvception, NotFoundException;

    @ApiOperation(value = "Add information about removing information beeing player", nickname = "markingAsNonPlayer", authorizations = {
            @Authorization(value = "petstore_auth", scopes = {
                    @AuthorizationScope(scope = "write", description = "modify data"),
                    @AuthorizationScope(scope = "read", description = "read data")
            })})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User marked as not member"),
            @ApiResponse(code = 403, message = "User does not have access to this applicaion"),
            @ApiResponse(code = 404, message = "Event not found")})
    @RequestMapping(
            value = "/markingAsNonPlayer/{eventId}",
            method = RequestMethod.POST)
    ResponseEntity<Void> markingAsNonPlayer(@ApiParam(value = "Event to mark as member", required = true) @PathVariable("eventId") BigDecimal eventId) throws AuthorizationException, NotFoundException;

    @ApiOperation(value = "Get all user event", nickname = "gettingUserEvent", notes = "", response = Events.class, responseContainer = "List", authorizations = {
            @Authorization(value = "petstore_auth", scopes = {
                    @AuthorizationScope(scope = "write", description = "modify data"),
                    @AuthorizationScope(scope = "read", description = "read data")
            })})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of events when user is member", response = Events.class, responseContainer = "List"),
            @ApiResponse(code = 403, message = "User does not have access to this applicaion")})
    @RequestMapping(value = "/myEvents",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<Events>> gettingUserEvent();

    @ApiOperation(value = "Display users that will attend to event with given id", nickname = "displayAttenders", notes = "", response = User.class, responseContainer = "List", authorizations = {
            @Authorization(value = "petstore_auth", scopes = {
                    @AuthorizationScope(scope = "write", description = "modify data"),
                    @AuthorizationScope(scope = "read", description = "read data")
            })})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of users retrived successfully", response = User.class, responseContainer = "List"),
            @ApiResponse(code = 403, message = "User does not have access to this applicaion"),
            @ApiResponse(code = 404, message = "Event with given id not found")})
    @RequestMapping(value = "/displayAttenders/{eventId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<User>> displayAttenders(@ApiParam(value = "event attenders to search for", required = true) @PathVariable("eventId") BigDecimal eventId);

    @ApiOperation(value = "Display events that may be interested to user", nickname = "displaySuggestions", notes = "", response = Events.class, responseContainer = "List", authorizations = {
            @Authorization(value = "petstore_auth", scopes = {
                    @AuthorizationScope(scope = "write", description = "modify data"),
                    @AuthorizationScope(scope = "read", description = "read data")
            })})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of suggested events", response = Events.class, responseContainer = "List"),
            @ApiResponse(code = 403, message = "User does not have access to this applicaion")})
    @RequestMapping(value = "/displaySuggestions",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<Events>> displaySuggestions();

}
