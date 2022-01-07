package com.example.shopify.exception;

import com.example.shopify.model.Item;

public class ItemNotExistException extends DataNotExistException {
    public ItemNotExistException(String message) {
        super(message, Item.class);
    }

    public ItemNotExistException(String message, Throwable cause) {
        super(message, cause, Item.class);
    }

    public ItemNotExistException(Throwable cause) {
        super(cause, Item.class);
    }
}
