package com.bosonit.backend.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(UnprocessableEntityException.class)
    public ResponseEntity<CustomError> handleValidationExceptions(UnprocessableEntityException e) {
        Logger logger = LoggerFactory.getLogger(CustomizedResponseEntityExceptionHandler.class);
        logger.error(e.getMessage());
        CustomError customError = new CustomError(new Date(), HttpStatus.UNPROCESSABLE_ENTITY.value(), e.getMessage());
        return new ResponseEntity<CustomError>(customError, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<CustomError> handleNotFoundException(EntityNotFoundException e) {
        Logger logger = LoggerFactory.getLogger(CustomizedResponseEntityExceptionHandler.class);
        logger.error(e.getMessage());
        CustomError customError = new CustomError(new Date(), HttpStatus.NOT_FOUND.value(), e.getMessage());
        return new ResponseEntity<CustomError>(customError, HttpStatus.NOT_FOUND);
    }
}
