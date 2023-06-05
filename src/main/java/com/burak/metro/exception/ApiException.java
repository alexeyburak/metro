package com.burak.metro.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static lombok.AccessLevel.PRIVATE;

@Data
@RequiredArgsConstructor
@JsonInclude(NON_NULL)
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class ApiException {
    String message;
    HttpStatus httpStatus;
    int code;
    String phrase;
    ZonedDateTime timestamp;
}
