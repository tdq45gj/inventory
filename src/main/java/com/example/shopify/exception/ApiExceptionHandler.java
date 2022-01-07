package com.example.shopify.exception;

import com.example.shopify.common.ApiReponse;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @SuppressWarnings("rawtypes")
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiReponse> handle(RuntimeException e) {
        return new ResponseEntity<>(new ApiReponse(false, "An error has occured!"), HttpStatus.BAD_REQUEST);
    }

    @SuppressWarnings("rawtypes")
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiReponse> handle(ConstraintViolationException e) {
        StringBuilder sb = new StringBuilder();
        for (ConstraintViolation violation : e.getConstraintViolations()) {
            sb.append(violation.getMessage());
            sb.append(" ");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return new ResponseEntity<>(new ApiReponse(false, sb.toString()), HttpStatus.BAD_REQUEST);
    }

    @SuppressWarnings("rawtypes")
    @ExceptionHandler(ItemNotExistException.class)
    public ResponseEntity<ApiReponse> handle(ItemNotExistException e) {
        return new ResponseEntity<>(new ApiReponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @SuppressWarnings("rawtypes")
    @ExceptionHandler(DtoIdMismatchException.class)
    public ResponseEntity<ApiReponse> handle(DtoIdMismatchException e) {
        return new ResponseEntity<>(new ApiReponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @SuppressWarnings("rawtypes")
    @ExceptionHandler(ItemAlreadyExistsException.class)
    public ResponseEntity<ApiReponse> handle(ItemAlreadyExistsException e) {
        return new ResponseEntity<>(new ApiReponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
