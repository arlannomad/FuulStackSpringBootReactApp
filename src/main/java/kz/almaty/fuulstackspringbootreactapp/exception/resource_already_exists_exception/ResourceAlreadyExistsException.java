package kz.almaty.fuulstackspringbootreactapp.exception.resource_already_exists_exception;

public class ResourceAlreadyExistsException extends RuntimeException {

    public ResourceAlreadyExistsException(String message) {
        super(message);
    }
}
