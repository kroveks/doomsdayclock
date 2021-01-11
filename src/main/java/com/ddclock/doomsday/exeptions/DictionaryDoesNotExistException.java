package com.ddclock.doomsday.exeptions;

public class DictionaryDoesNotExistException extends Exception {

    public DictionaryDoesNotExistException() {}

    public DictionaryDoesNotExistException(String message) {
        super(message);
    }
}
