package com.workshop.springbootapp.postter.api;

import com.workshop.springbootapp.postter.api.response.ErrorResponse;
import com.workshop.springbootapp.postter.exception.PostNotFoundException;
import com.workshop.springbootapp.postter.exception.PostValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PostExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(PostNotFoundException.class)
    public ErrorResponse postNotFoundException(PostNotFoundException ex) {
        return new ErrorResponse(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PostValidationException.class)
    public ErrorResponse postValidationException(PostValidationException ex) {
        return new ErrorResponse(ex.getMessage());
    }

}
