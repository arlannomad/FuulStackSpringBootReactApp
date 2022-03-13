package kz.almaty.fuulstackspringbootreactapp.exception.resource_not_found_exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
