package com.example.shopify.exception;

public abstract class DataNotExistException extends RuntimeException {
    private final Class aClass;

    protected DataNotExistException(String message, Class aClass) {
        super(message);
        this.aClass = aClass;
    }

    protected DataNotExistException(String message, Throwable cause, Class aClass) {
        super(message, cause);
        this.aClass = aClass;
    }

    protected DataNotExistException(Throwable cause, Class aClass) {
        super(cause);
        this.aClass = aClass;
    }
}
