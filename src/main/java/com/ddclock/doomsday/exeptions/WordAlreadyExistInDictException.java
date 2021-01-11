package com.ddclock.doomsday.exeptions;

public class WordAlreadyExistInDictException extends Exception {

    public WordAlreadyExistInDictException() {}

    public WordAlreadyExistInDictException(String message) {
        super(message);
    }
}
