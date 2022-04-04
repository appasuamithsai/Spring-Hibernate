package com.amith.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class CustomerRestExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException CustomerNotFoundException){

        CustomerErrorResponse CustomerErrorResponse=new CustomerErrorResponse();
        CustomerErrorResponse.setStatus(404);
        CustomerErrorResponse.setMessage(CustomerNotFoundException.getMessage());
        CustomerErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(CustomerErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse>  handleException(Exception e){

        CustomerErrorResponse CustomerErrorResponse=new CustomerErrorResponse();
        CustomerErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        CustomerErrorResponse.setMessage(e.getMessage());
        CustomerErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(CustomerErrorResponse, HttpStatus.BAD_REQUEST);
    }

}
