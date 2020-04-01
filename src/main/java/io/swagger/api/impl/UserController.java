package io.swagger.api.impl;

import io.swagger.api.interfaces.UserApi;
import io.swagger.api.response.UserResponse;
import io.swagger.logic.exception.AuthorizationException;
import io.swagger.logic.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@PreAuthorize("isAuthenticated()")
@RestController
@RequestMapping("/user")
public class UserController implements UserApi {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<Void> sendPersonalMessage(BigDecimal userId, String content) {
        return null;
    }

    @Override
    public ResponseEntity<UserResponse> getLoggedInUser() throws AuthorizationException {
        return ResponseEntity.ok(userService.getLoggedInUser());
    }

}
