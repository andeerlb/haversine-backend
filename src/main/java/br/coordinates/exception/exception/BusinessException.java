package br.coordinates.exception.exception;

import org.springframework.http.HttpStatus;

public class BusinessException extends BaseRuntimeException {

    public BusinessException(String message, Throwable thr, HttpStatus httpStatus) {
        super(message, thr);
        this.httpStatus = httpStatus;
    }

    public BusinessException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
