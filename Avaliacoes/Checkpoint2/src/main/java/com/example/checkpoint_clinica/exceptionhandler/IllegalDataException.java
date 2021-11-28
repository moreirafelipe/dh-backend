package com.example.checkpoint_clinica.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class IllegalDataException extends IllegalArgumentException {
    public IllegalDataException(String message) {
        super(message);
    }
}
