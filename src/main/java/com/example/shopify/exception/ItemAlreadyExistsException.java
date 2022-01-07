package com.example.shopify.exception;

public class ItemAlreadyExistsException extends RuntimeException {
    public ItemAlreadyExistsException() {
    }

    public ItemAlreadyExistsException(String message) {
        super(message);
    }

    public ItemAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ItemAlreadyExistsException(Throwable cause) {
        super(cause);
    }
}
