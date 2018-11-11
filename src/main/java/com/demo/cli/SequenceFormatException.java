package com.demo.cli;

public class SequenceFormatException extends Exception {
    public SequenceFormatException() {
        super();
    }

    public SequenceFormatException(String message) {
        super(message);
    }

    public SequenceFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public SequenceFormatException(Throwable cause) {
        super(cause);
    }

    protected SequenceFormatException(String message, Throwable cause, boolean enableSuppression,
                                      boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public String getLocalizedMessage() {
        return super.getLocalizedMessage();
    }

    @Override
    public synchronized Throwable getCause() {
        return super.getCause();
    }
}
