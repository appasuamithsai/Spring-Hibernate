package com.amith.springdemo.rest;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(String msg,Throwable cause){
        super(msg,cause);
    }

    public CustomerNotFoundException(String msg){
        super(msg);
    }

    public CustomerNotFoundException(Throwable cause){
        super(cause);
    }
}
