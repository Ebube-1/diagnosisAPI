package com.example.medicalDiagnosisApp.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler  {

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(NotFoundException e, WebRequest request){
        return handleException(e, request, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {ClientRequestException.class})
    public ResponseEntity<Object> handleClientRequestException(ClientRequestException e, WebRequest request){
        return handleException(e, request, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(value = {ServerException.class})
    public ResponseEntity<Object> handleServerException(ServerException e, WebRequest request){
        return handleException(e, request, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {HttpRequestMethodNotSupportedException.class})
    public ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e, WebRequest request) {
        String message = "Method not supported";
        return handleException(new Exception(message, e), request, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, WebRequest request) {
        FieldError error = e.getBindingResult().getFieldError();
        String message = "invalid arguments";
        if(error != null)
            message = String.format("Field: %s. Message: %s", error.getField(), error.getDefaultMessage());

        return handleException(new Exception(message, e), request, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleConstraintViolationErrors(BindException ex, WebRequest request) {
        log.error(ex.getMessage(), ex);

        FieldError fieldError = ex.getBindingResult().getFieldError();
        String message = "invalid arguments";
        if(fieldError != null )
             message = String.format("Field: %s. Message: %s", fieldError.getField(), fieldError.getDefaultMessage());

        return handleException(new Exception(message, ex), request, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleGeneralException(Exception e, WebRequest request){
        return handleException(e, request, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<Object> handleException(Exception e, WebRequest request, HttpStatus httpStatus){
        log.error("API error: ", e);

        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),
                e.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(exceptionResponse, httpStatus);
    }
}
