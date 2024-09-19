package com.hillel.lesson_19.logger;

public class FileMaxSizeReachedException extends RuntimeException{

    public FileMaxSizeReachedException(String message) {
        super(message);
    }
}
