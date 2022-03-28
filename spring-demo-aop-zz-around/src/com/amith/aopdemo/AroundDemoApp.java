package com.amith.aopdemo;

import com.amith.aopdemo.dao.AccountDAO;
import com.amith.aopdemo.dao.MembershipDAO;
import com.amith.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AroundDemoApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService fortuneService=context.getBean("trafficFortuneService",TrafficFortuneService.class);

        System.out.println("Calling get Fortune");

        String data=fortuneService.getFortune();

        System.out.println(data);

        System.out.println("Done !!!");
        context.close();
    }
}
