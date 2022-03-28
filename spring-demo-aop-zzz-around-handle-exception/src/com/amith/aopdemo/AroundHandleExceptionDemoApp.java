package com.amith.aopdemo;

import com.amith.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundHandleExceptionDemoApp {
    private static Logger logger=
            Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService fortuneService=context.getBean("trafficFortuneService",TrafficFortuneService.class);

        logger.info("Calling get Fortune");
        boolean tripWire=true;
        String data=fortuneService.getFortune(tripWire);

        logger.info(data);

        logger.info("Done !!!");
        context.close();
    }
}
