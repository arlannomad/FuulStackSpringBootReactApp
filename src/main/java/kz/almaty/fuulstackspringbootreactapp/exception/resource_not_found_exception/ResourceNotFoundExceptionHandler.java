package kz.almaty.fuulstackspringbootreactapp.exception.resource_not_found_exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceNotFoundExceptionHandler {
    @ExceptionHandler({ResourceNotFoundException.class})
    ResponseEntity<Object> handler(ResourceNotFoundException exception) {
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        ResourceNotFoundExceptionData data = new ResourceNotFoundExceptionData(
                exception.getMessage(),
                HttpStatus.NOT_FOUND,
                LocalDateTime.now());
        return new ResponseEntity<>(data, notFound);
    }
}
