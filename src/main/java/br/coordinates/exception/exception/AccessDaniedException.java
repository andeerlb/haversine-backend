package br.coordinates.exception.exception;

import org.springframework.http.HttpStatus;

public class AccessDaniedException extends BaseRuntimeException {

    public AccessDaniedException(String message, Throwable thr) {
        super(message, thr);
        this.httpStatus = httpStatus;
    }

    public AccessDaniedException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
