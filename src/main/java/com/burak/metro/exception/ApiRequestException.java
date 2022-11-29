package com.burak.metro.exception;

/**
 * metro
 * Created by Alexey Burak
 * Nov 2022
 */

public class ApiRequestException extends RuntimeException {

    public ApiRequestException(String message) {
        super(message);
    }

    public ApiRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
