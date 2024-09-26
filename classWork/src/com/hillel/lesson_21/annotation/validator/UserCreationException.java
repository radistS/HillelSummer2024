package com.hillel.lesson_21.annotation.validator;

public class UserCreationException extends RuntimeException{

    public UserCreationException(String message) {
        super(message);
    }
}
