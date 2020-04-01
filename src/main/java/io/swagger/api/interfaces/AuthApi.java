package io.swagger.api.interfaces;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;
import io.swagger.api.request.ChangePasswordData;
import io.swagger.model.LoginData;
import io.swagger.model.RegisterData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-29T11:14:52.100Z[GMT]")
public interface AuthApi {

    @ApiOperation(value = "Create an account", nickname = "createAccount", notes = "", authorizations = {
            @Authorization(value = "petstore_auth", scopes = {
                    @AuthorizationScope(scope = "write", description = "modify data"),
                    @AuthorizationScope(scope = "read", description = "read data")
            })})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "User successfully created"),
            @ApiResponse(code = 400, message = "he user's passwords do not match. The user's email is used in the application. The password is not strong enough")})
    @RequestMapping(value = "/register",
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Void> createAccount(@ApiParam(value = "User data containing email and passwords", required = true) @Valid @RequestBody RegisterData body);

    @ApiOperation(value = "Loggin in to the system", nickname = "signIn", notes = "", authorizations = {
            @Authorization(value = "petstore_auth", scopes = {
                    @AuthorizationScope(scope = "write", description = "modify data"),
                    @AuthorizationScope(scope = "read", description = "read data")
            })})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User logged in correctly"),
            @ApiResponse(code = 400, message = "Wrong password or email"),
            @ApiResponse(code = 403, message = "User does not have access to this applicaion")})
    @RequestMapping(value = "/loggin",
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Void> signIn(@ApiParam(value = "User data containing email and password", required = true) @Valid @RequestBody LoginData body);

    @ApiOperation(value = "Reset password to the system", nickname = "resetPassword", notes = "", authorizations = {
            @Authorization(value = "petstore_auth", scopes = {
                    @AuthorizationScope(scope = "write", description = "modify data"),
                    @AuthorizationScope(scope = "read", description = "read data")
            })})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Password has been sent"),
            @ApiResponse(code = 400, message = "User email not found"),
            @ApiResponse(code = 403, message = "User does not have access to this applicaion")})
    @RequestMapping(value = "/resetPassword",
            consumes = {"application/x-www-form-urlencoded"},
            method = RequestMethod.PUT)
    ResponseEntity<Void> resetPassword(@ApiParam(value = "") @RequestParam(value = "email", required = false) String email);

    @ApiOperation(value = "Logging out from the system", nickname = "signOut", notes = "", authorizations = {
            @Authorization(value = "petstore_auth", scopes = {
                    @AuthorizationScope(scope = "write", description = "modify data"),
                    @AuthorizationScope(scope = "read", description = "read data")
            })})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User correctly logged out"),
            @ApiResponse(code = 403, message = "User does not have access to this applicaion")})
    @RequestMapping(value = "/loggout",
            method = RequestMethod.POST)
    ResponseEntity<Void> signOut();

    @ApiOperation(value = "Change user password", nickname = "changePassword", notes = "", authorizations = {
            @Authorization(value = "petstore_auth", scopes = {
                    @AuthorizationScope(scope = "write", description = "modify data"),
                    @AuthorizationScope(scope = "read", description = "read data")
            })})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Password has been hanged"),
            @ApiResponse(code = 400, message = "Password is not strong. Passwords are not the same"),
            @ApiResponse(code = 403, message = "User does not have access to this applicaion")})
    @RequestMapping(value = "/changePassword",
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    ResponseEntity<Void> changePassword(@ApiParam(value = "New password in duplicate", required = true) @Valid @RequestBody ChangePasswordData body);

    @ApiOperation(value = "Remove user account", nickname = "removeUserAccount", notes = "", authorizations = {
            @Authorization(value = "petstore_auth", scopes = {
                    @AuthorizationScope(scope = "write", description = "modify data"),
                    @AuthorizationScope(scope = "read", description = "read data")
            })})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User account has been removed"),
            @ApiResponse(code = 403, message = "User does not have access to this applicaion")})
    @RequestMapping(value = "/removeAccount",
            method = RequestMethod.DELETE)
    ResponseEntity<Void> removeUserAccount();

}
