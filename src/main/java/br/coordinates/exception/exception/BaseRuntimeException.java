package br.coordinates.exception.exception;

import org.springframework.http.HttpStatus;

public class BaseRuntimeException extends RuntimeException {
    protected HttpStatus httpStatus;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public BaseRuntimeException(String message) {
        super(message);
    }

    public BaseRuntimeException(String message, Throwable thr) {
        super(message, thr);
    }
}
