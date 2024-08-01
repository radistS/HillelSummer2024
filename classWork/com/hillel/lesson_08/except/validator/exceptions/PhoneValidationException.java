package com.hillel.lesson_08.except.validator.exceptions;

public class PhoneValidationException extends RuntimeException{
    public PhoneValidationException(String message) {
        super(message);
    }
}
