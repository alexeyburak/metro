package com.burak.metro.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@ResponseStatus(value = NOT_FOUND)
public class LineNotFoundException extends RuntimeException {
}
