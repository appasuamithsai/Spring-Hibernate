package com.amith.aopdemo.aspect;

import com.amith.aopdemo.Account;
import com.amith.aopdemo.AroundWithLoggerDemoApp;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    private static Logger logger=
            Logger.getLogger(MyDemoLoggingAspect.class.getName());


    @Around(
            "execution(* com.amith.aopdemo.service.*.getFortune(..))"
    )
    public Object aroundGetFortune(
            ProceedingJoinPoint joinPoint
    ) throws  Throwable{
        String method=joinPoint.getSignature().toString();
        logger.info("=====> Executing @Around on method "+method);

        long begin=System.currentTimeMillis();

        Object result=joinPoint.proceed();

        long end=System.currentTimeMillis();

        long duration=end-begin;
        logger.info("=====> Duration : "+(duration/1000.0)+" sec.");
        return result;
    }



    @After(
         "execution(* com.amith.aopdemo.dao.AccountDAO.findAccounts(..))"
    )
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint){

        String method=joinPoint.getSignature().toString();
        logger.info("=====> Executing @After (finally) on method "+method);


    }


    @AfterThrowing(
            pointcut = "execution(* com.amith.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "exc"
    )
    public void afterThrowingFindAccountsAdvice(
            JoinPoint joinPoint,Throwable exc
    ){
        String method=joinPoint.getSignature().toString();
        logger.info("=====> Executing @AfterThrowing on method "+method);

        logger.info("\"=====>  Exception is : "+exc);


    }




    @AfterReturning(pointcut = "execution(* com.amith.aopdemo.dao.AccountDAO.findAccounts(..))",
                    returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        String method=joinPoint.getSignature().toString();
        logger.info("=====> Executing @AfterReturning on method "+method);

        logger.info("\"=====>  Result is : "+result);


        convertAccountNamesToUpperCase(result);

        logger.info("\"=====>  Result is : "+result);


    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for(Account account:result){
            String upperName=account.getName().toUpperCase();
            account.setName(upperName);
        }
    }


    @Before("com.amith.aopdemo.aspect.AmithAopExpressions.forDaoPackageNoGetterSetter())")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        logger.info("=====> Executing @Before advice on addAccount()");

        MethodSignature methodSignature=(MethodSignature) joinPoint.getSignature();

        logger.info(methodSignature.toString());

        Object[] objects=joinPoint.getArgs();

        for(Object obj:objects){
            logger.info(obj.toString());
            if(obj instanceof Account){
                Account account=(Account) obj;
                logger.info(account.getName());
            }
        }
    }
}
