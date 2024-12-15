package com.polytech.polytech.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No reservation found in the database")
public class NoReservationFound extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
}
