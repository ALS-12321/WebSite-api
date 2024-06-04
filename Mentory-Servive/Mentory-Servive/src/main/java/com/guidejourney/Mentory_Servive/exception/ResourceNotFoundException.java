package com.guidejourney.Mentory_Servive.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ResourceFoundException extends RuntimeException {

    public ResourceFoundException(String message) {
        super("El recurso ya existe: " + message);
    }
}
