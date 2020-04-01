package io.swagger.api.interfaces;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;
import io.swagger.api.response.UserResponse;
import io.swagger.logic.exception.AuthorizationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-29T11:14:52.100Z[GMT]")
public interface UserApi {

    @ApiOperation(value = "Send personal message to user with given id", nickname = "sendPersonalMessage", notes = "", authorizations = {
            @Authorization(value = "petstore_auth", scopes = {
                    @AuthorizationScope(scope = "write", description = "modify data"),
                    @AuthorizationScope(scope = "read", description = "read data")
            })})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Message sent successfully"),
            @ApiResponse(code = 400, message = "Message content exceed 500 characters"),
            @ApiResponse(code = 403, message = "User does not have access to this applicaion"),
            @ApiResponse(code = 404, message = "User with given id not found")})
    @RequestMapping(value = "/sendMessage/{userId}",
            consumes = {"application/x-www-form-urlencoded"},
            method = RequestMethod.POST)
    ResponseEntity<Void> sendPersonalMessage(@ApiParam(value = "user id to send message", required = true) @PathVariable("userId") BigDecimal userId,
                                             @ApiParam(value = "") @RequestParam(value = "content", required = false) String content);

    @ApiOperation(value = "Get logged in user", authorizations = {
            @Authorization(value = "petstore_auth", scopes = {
                    @AuthorizationScope(scope = "write", description = "modify data"),
                    @AuthorizationScope(scope = "read", description = "read data")
            })})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User prepared successfully"),
            @ApiResponse(code = 401, message = "User is not authenticated"),
            @ApiResponse(code = 403, message = "User does not have access to this applicaion")})
    @RequestMapping(value = "/get",
            method = RequestMethod.GET)
    ResponseEntity<UserResponse> getLoggedInUser() throws AuthorizationException;

}
