package com.springProject.course.controllers.handlers;

import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.springProject.course.dto.CustomError;
import com.springProject.course.services.exceptions.DataBaseException;
import com.springProject.course.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    private static final String RESOURCE_NOT_FOUND = "Recurso não encontrado";

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> ResourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(InvalidDefinitionException.class)
    public ResponseEntity<CustomError> InvalidDefinition(InvalidDefinitionException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError err = new CustomError(Instant.now(), status.value(), RESOURCE_NOT_FOUND, request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<CustomError> DataIntegrityViolation(DataBaseException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}