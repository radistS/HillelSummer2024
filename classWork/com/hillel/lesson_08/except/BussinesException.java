package com.hillel.lesson_08.except;

import java.io.IOException;

public class BussinesException extends IOException {
    public BussinesException(String message) {
        super(message);
    }
}
