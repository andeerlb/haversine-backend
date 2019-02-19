package br.coordinates.infra;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Response<T> implements Serializable {
    private static final long serialVersionUID = -588850642535077637L;

    private T body;
    private String message;
    private HttpStatus httpStatus;
    private Integer httpStatusCode;
    @JsonIgnore
    private ResponseEntity<Response<T>> responseEntity = null;

    public Response(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        this.httpStatusCode = httpStatus.value();
        responseEntity = new ResponseEntity<>(this, httpStatus);
    }

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(Integer httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public ResponseEntity<Response<T>> getResponseEntity() {
        return responseEntity;
    }

    public void setResponseEntity(ResponseEntity<Response<T>> responseEntity) {
        this.responseEntity = responseEntity;
    }
}
