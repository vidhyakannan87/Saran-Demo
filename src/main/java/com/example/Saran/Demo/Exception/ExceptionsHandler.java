package com.example.Saran.Demo.Exception;

import com.example.Saran.Demo.API.Response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolation;
import javax.ws.rs.BadRequestException;
import java.util.HashSet;
import java.util.Set;

@RestControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(javax.validation.ConstraintViolationException.class)
  public ErrorResponse handleJavaxConstraintException(javax.validation.ConstraintViolationException e) {

    Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
    Set<String> constraintViolationMessages = new HashSet<>();

    for (ConstraintViolation<?> violation : constraintViolations) {
      constraintViolationMessages.add(String.format("%s %s", violation.getPropertyPath(), violation.getMessage()));
    }

    return buildErrorResponseWithMessage(constraintViolationMessages.toString());
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(BadRequestException.class)
  public ErrorResponse handleBadRequest(BadRequestException e) {

    return buildErrorResponseWithMessage(e.getMessage());
  }

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(value = EntityNotFoundException.class)
  public ErrorResponse handleUserNotFound(EntityNotFoundException e) {

    return buildErrorResponseWithMessage(e.getMessage());
  }


  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(HttpClientErrorException.class)
  public ErrorResponse handleHttpClientErrorExceptionException(HttpClientErrorException e) {

    return ErrorResponse.builder().message(e.getMessage()).build();
  }


  public ErrorResponse buildErrorResponseWithMessage(String message) {
    return ErrorResponse.builder().message(message).build();
  }
}
