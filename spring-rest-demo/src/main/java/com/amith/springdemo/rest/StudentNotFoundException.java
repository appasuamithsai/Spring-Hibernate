package com.amith.springdemo.rest;



public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(String msg,Throwable cause){
            super(msg,cause);
    }

    public StudentNotFoundException(String msg){
        super(msg);
    }

    public StudentNotFoundException(Throwable cause){
        super(cause);
    }
}
