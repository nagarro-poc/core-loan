package org.bfsi.orchestration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandle extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = LeadNotFoundException.class)
    public ResponseEntity<Object> LeadNotFoundException(){
        return new ResponseEntity<>("Lead not found", HttpStatus.NOT_FOUND);
    }

}
