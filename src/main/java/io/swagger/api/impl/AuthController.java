package io.swagger.api.impl;

import io.swagger.api.interfaces.AuthApi;
import io.swagger.api.request.ChangePasswordData;
import io.swagger.model.LoginData;
import io.swagger.model.RegisterData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController implements AuthApi {
    @Override
    public ResponseEntity<Void> createAccount(RegisterData body) {
        return null;
    }

    @Override
    public ResponseEntity<Void> signIn(LoginData body) {
        return null;
    }

    @Override
    public ResponseEntity<Void> resetPassword(String email) {
        return null;
    }

    @Override
    public ResponseEntity<Void> signOut() {
        return null;
    }

    @Override
    public ResponseEntity<Void> changePassword(ChangePasswordData body) {
        return null;
    }

    @Override
    public ResponseEntity<Void> removeUserAccount() {
        return null;
    }

}
