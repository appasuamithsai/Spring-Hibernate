package com.amith.aopdemo.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {

    public String getFortune(boolean tripWire){

        if(tripWire){
            throw  new RuntimeException("Please Leave It");
        }
        try{
            TimeUnit.SECONDS.sleep(5);

        }catch (Exception e){
            e.printStackTrace();
        }
        return "Expect heavy traffic in the morning";
    }

}
