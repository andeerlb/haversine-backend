package br.coordinates.exception.exception;

import org.springframework.http.HttpStatus;

public class ClientException extends BaseRuntimeException {

    public ClientException(String message, Throwable thr) {
        super(message, thr);
        this.httpStatus = httpStatus;
    }

    public ClientException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
