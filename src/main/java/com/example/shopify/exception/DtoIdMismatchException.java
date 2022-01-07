package com.example.shopify.exception;

public class DtoIdMismatchException extends RuntimeException {
    public DtoIdMismatchException() {
    }

    public DtoIdMismatchException(String message) {
        super(message);
    }

    public DtoIdMismatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public DtoIdMismatchException(Throwable cause) {
        super(cause);
    }
}
