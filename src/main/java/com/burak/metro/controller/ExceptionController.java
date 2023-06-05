package com.burak.metro.controller;

import com.burak.metro.exception.ApiException;
import com.burak.metro.exception.ApiRequestException;
import com.burak.metro.exception.LineNotFoundException;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.ResponseEntity.status;

@ControllerAdvice
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class ExceptionController {

    static String ZONE_ID = "Z";

    @ExceptionHandler(value = {ApiRequestException.class})
    @ResponseStatus(BAD_REQUEST)
    public ResponseEntity<?> handleApiRequestException(ApiRequestException e) {
        HttpStatus badRequest = BAD_REQUEST;
        ApiException apiException = getApiException(e, badRequest);

        return status(badRequest)
                .body(apiException);
    }

    @ExceptionHandler(value = {LineNotFoundException.class})
    @ResponseStatus(NOT_FOUND)
    public ResponseEntity<?> handleLineNotFoundException(LineNotFoundException e) {
        HttpStatus notFound = NOT_FOUND;
        ApiException apiException = getApiException(e, notFound);

        return status(notFound)
                .body(apiException);
    }

    @ExceptionHandler
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ResponseEntity<?> handleAllException(Exception e) {
        HttpStatus internalServerError = INTERNAL_SERVER_ERROR;
        ApiException apiException = getApiException(e, internalServerError);

        return status(internalServerError)
                .body(apiException);
    }

    private ApiException getApiException(Exception e, HttpStatus status) {
        return new ApiException(
                e.getMessage(),
                status,
                status.value(),
                status.getReasonPhrase(),
                ZonedDateTime.now(
                        ZoneId.of(ZONE_ID)
                )
        );
    }

}
