package io.swagger.logic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "Authorization error")
public class AuthorizationException extends Exception {
	public AuthorizationException() {
		super("Authorization error");
	}
}
