package com.your.choice.brigadeservice.controller;

import com.your.choice.brigadeservice.exception.BrigadeNotFoundException;
import com.your.choice.brigadeservice.exception.ShiftNotFoundException;
import com.your.choice.brigadeservice.exception.UserNotFoundExcetion;
import com.your.choice.brigadeservice.model.response.exception.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundExcetion.class)
    private ExceptionResponse userNotFound(UserNotFoundExcetion ex) {
        return new ExceptionResponse(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(BrigadeNotFoundException.class)
    private ExceptionResponse brigadeNotFound(BrigadeNotFoundException ex) {
        return new ExceptionResponse(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ShiftNotFoundException.class)
    private ExceptionResponse shiftNotFound(ShiftNotFoundException ex) {
        return new ExceptionResponse(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    private ExceptionResponse error(RuntimeException ex) {
        return new ExceptionResponse(ex.getMessage());
    }
}
