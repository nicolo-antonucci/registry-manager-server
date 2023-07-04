package com.nicoloantonucci.registrymanagerserver.exceptions;

import com.nicoloantonucci.registrymanagerserver.model.BaseError;
import com.nicoloantonucci.registrymanagerserver.model.Registry;
import com.nicoloantonucci.registrymanagerserver.model.ResponseSchema;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value
            = {IllegalArgumentException.class, IllegalStateException.class})
    protected ResponseSchema<Registry, BaseError> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                               HttpStatus status, WebRequest request) {


        return new ResponseSchema<>(false, null, new BaseError(HttpStatus.BAD_REQUEST, "Invalid request"));
    }
}
