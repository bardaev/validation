package com.valid.exception;

public class ConfigurationException extends RuntimeException {
    public ConfigurationException(Throwable cause) {
        super(cause);
    }

    public ConfigurationException() {
        super();
    }

    public ConfigurationException(String message) {
        super(message);
    }

    public ConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }
}

