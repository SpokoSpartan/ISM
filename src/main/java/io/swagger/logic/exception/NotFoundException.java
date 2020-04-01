package io.swagger.logic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Element not found")
public class NotFoundException extends Exception {
    public NotFoundException(String msg) {
        super(msg);
    }
}
