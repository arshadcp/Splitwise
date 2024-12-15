package dev.arshad.Splitwise.Exception;

public class invalidPasswordException extends RuntimeException{
    public invalidPasswordException() {
    }

    public invalidPasswordException(String message) {
        super(message);
    }

    public invalidPasswordException(String message, Throwable cause) {
        super(message, cause);
    }

    public invalidPasswordException(Throwable cause) {
        super(cause);
    }

    public invalidPasswordException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
