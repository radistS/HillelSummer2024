package org.hillel.user.exceptions;

public class PhoneValidationException extends RuntimeException{
    public PhoneValidationException(String message) {
        super(message);
    }
}
