package io.swagger.logic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Cannot vote for this event")
public class CannotVoteEvception extends Exception {
    public CannotVoteEvception(String msg) {
        super(msg);
    }
}
