package com.workshop.springbootapp.postter.exception;

public class PostValidationException extends RuntimeException {

    public PostValidationException(String message) {
        super(message);
    }
}
