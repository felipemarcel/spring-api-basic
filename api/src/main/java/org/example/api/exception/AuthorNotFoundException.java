package org.example.api.exception;

public class AuthorNotFoundException extends RuntimeException {

    public AuthorNotFoundException(String message) {
        super(message);
    }

    public AuthorNotFoundException() {

    }
}
