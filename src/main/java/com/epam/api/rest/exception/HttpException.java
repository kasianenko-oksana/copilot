package com.epam.api.rest.exception;

public class HttpException extends RuntimeException {

    public HttpException(String message) {
        super(message);
    }
}
