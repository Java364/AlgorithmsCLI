package com.softserve.cli;

public class SequenceFormatException extends Exception {

    public SequenceFormatException(String message) {
        super(message);
    }

    public SequenceFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public synchronized Throwable getCause() {
        return super.getCause();
    }
}
