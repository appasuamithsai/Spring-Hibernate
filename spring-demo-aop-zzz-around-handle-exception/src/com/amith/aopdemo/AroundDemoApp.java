package com.amith.aopdemo;

import com.amith.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundDemoApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService fortuneService=context.getBean("trafficFortuneService",TrafficFortuneService.class);

        System.out.println("Calling get Fortune");

        boolean tripWire=false;
        String data=fortuneService.getFortune(tripWire);

        System.out.println(data);

        System.out.println("Done !!!");
        context.close();
    }
}
