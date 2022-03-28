package com.amith.springdemo.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
    private Logger logger=
            Logger.getLogger(CRMLoggingAspect.class.getName());


    @Pointcut("execution(* com.amith.springdemo.controller.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("execution(* com.amith.springdemo.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution(* com.amith.springdemo.dao.*.*(..))")
    private void forDaoPackage(){}


    @Pointcut(" forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow(){}


    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint){
        String method=joinPoint.getSignature().toString();
        logger.info("METHOD "+method);

        Object objects[]=joinPoint.getArgs();

        for(Object obj:objects){
            logger.info(obj.toString());
        }
    }


    @AfterReturning(
            pointcut ="forAppFlow()" ,
            returning ="result"
    )
    public void afterReturning(JoinPoint joinPoint,Object result){
        String method=joinPoint.getSignature().toString();
        logger.info("METHOD "+method);

        logger.info("RESULT : "+result.toString());
    }




}
