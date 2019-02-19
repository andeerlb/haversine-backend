package br.coordinates.exception.handler;

import br.coordinates.exception.exception.BaseRuntimeException;
import br.coordinates.infra.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {BaseRuntimeException.class})
    protected ResponseEntity<Response<Object>> handleLogicalBusiness(BaseRuntimeException ex, WebRequest request) {
        return getResponseResponseEntity(ex);
    }

    private ResponseEntity<Response<Object>> getResponseResponseEntity(BaseRuntimeException ex) {
        Response<Object> objectResponse = new Response<>(ex.getHttpStatus());
        objectResponse.setMessage(ex.getMessage());
        return objectResponse.getResponseEntity();
    }
}
