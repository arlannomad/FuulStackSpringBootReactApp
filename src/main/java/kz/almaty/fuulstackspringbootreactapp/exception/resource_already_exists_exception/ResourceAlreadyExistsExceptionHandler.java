package kz.almaty.fuulstackspringbootreactapp.exception.resource_already_exists_exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceAlreadyExistsExceptionHandler {
    @ExceptionHandler({ResourceAlreadyExistsException.class})
    ResponseEntity<Object> handler(ResourceAlreadyExistsException exception) {
        HttpStatus alreadyExists = HttpStatus.BAD_REQUEST;
        ResourceAlreadyExistsExceptionData data = new ResourceAlreadyExistsExceptionData(
                exception.getMessage(),
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now());
        return new ResponseEntity<>(data, alreadyExists);
    }
}
