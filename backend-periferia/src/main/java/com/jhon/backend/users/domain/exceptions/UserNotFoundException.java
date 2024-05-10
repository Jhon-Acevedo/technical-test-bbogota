package com.jhon.backend.users.domain.exceptions;

public class UserNotFoundException extends RuntimeException {

    public static String MESSAGE = "User not found";

    public UserNotFoundException() {
        super(MESSAGE);
    }
}
