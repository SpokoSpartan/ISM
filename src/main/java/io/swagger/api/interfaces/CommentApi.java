package io.swagger.api.interfaces;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;
import io.swagger.logic.exception.AuthorizationException;
import io.swagger.logic.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-29T11:14:52.100Z[GMT]")
public interface CommentApi {

    @ApiOperation(value = "Create comment to event with given id", nickname = "createComment", notes = "", authorizations = {
            @Authorization(value = "petstore_auth", scopes = {
                    @AuthorizationScope(scope = "write", description = "modify data"),
                    @AuthorizationScope(scope = "read", description = "read data")
            })})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Comment created successfully"),
            @ApiResponse(code = 403, message = "User does not have access to this applicaion"),
            @ApiResponse(code = 404, message = "Event not found")})
    @RequestMapping(value = "/create/{eventId}",
            method = RequestMethod.POST)
    ResponseEntity<Long> createComment(@ApiParam(value = "event to add comment", required = true) @PathVariable("eventId") BigDecimal eventId,
                                       @ApiParam(value = "Cntent of created comment", required = true) @RequestParam String content
    ) throws NotFoundException, AuthorizationException;

    @ApiOperation(value = "Edit comment with given id", nickname = "updateComment", notes = "", authorizations = {
            @Authorization(value = "petstore_auth", scopes = {
                    @AuthorizationScope(scope = "write", description = "modify data"),
                    @AuthorizationScope(scope = "read", description = "read data")
            })})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Comment updated successfully"),
            @ApiResponse(code = 403, message = "User does not have access to this applicaion"),
            @ApiResponse(code = 404, message = "Comment not found")})
    @RequestMapping(value = "/edit/{commentId}",
            method = RequestMethod.PUT)
    ResponseEntity<Void> updateComment(@ApiParam(value = "comment to modify", required = true) @PathVariable("commentId") BigDecimal commentId,
                                       @ApiParam(value = "Cntent of modifyed comment", required = true) @RequestParam String content
    ) throws NotFoundException, AuthorizationException;

    @ApiOperation(value = "Remove comment with given id", nickname = "removeComment", notes = "", authorizations = {
            @Authorization(value = "petstore_auth", scopes = {
                    @AuthorizationScope(scope = "write", description = "modify data"),
                    @AuthorizationScope(scope = "read", description = "read data")
            })})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Comment removed successfully"),
            @ApiResponse(code = 403, message = "User does not have access to this applicaion"),
            @ApiResponse(code = 404, message = "Comment with given id not found")})
    @RequestMapping(value = "/removeComment/{commentId}",
            method = RequestMethod.DELETE)
    ResponseEntity<Void> removeComment(@ApiParam(value = "comment to remove", required = true) @PathVariable("commentId") BigDecimal commentId
    ) throws NotFoundException, AuthorizationException;

}
