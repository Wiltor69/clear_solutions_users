package com.wiltor.clearsolutions.exceptions;

public class UserUpdateException extends Exception{

    public UserUpdateException(String message) {
        super(message);
    }

    public UserUpdateException(String message, Throwable cause) {
        super(message, cause);
    }
}
