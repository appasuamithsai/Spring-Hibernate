package com.amith.aopdemo.aspect;

import com.amith.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @AfterReturning(pointcut = "execution(* com.amith.aopdemo.dao.AccountDAO.findAccounts(..))",
                    returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        String method=joinPoint.getSignature().toString();
        System.out.println("=====> Executing @AfterReturning on method "+method);

        System.out.println("\"=====>  Result is : "+result);


        converrtAccountNamesToUpperCase(result);
        System.out.println();
        System.out.println("\"=====>  Result is : "+result);


    }

    private void converrtAccountNamesToUpperCase(List<Account> result) {
        for(Account account:result){
            String upperName=account.getName().toUpperCase();
            account.setName(upperName);
        }
    }


    @Before("com.amith.aopdemo.aspect.AmithAopExpressions.forDaoPackageNoGetterSetter())")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("=====> Executing @Before advice on addAccount()");

        MethodSignature methodSignature=(MethodSignature) joinPoint.getSignature();

        System.out.println(methodSignature);
        System.out.println();

        Object[] objects=joinPoint.getArgs();

        for(Object obj:objects){
            System.out.println(obj);
            if(obj instanceof Account){
                Account account=(Account) obj;
                System.out.println(account.getName());
            }
        }
    }
}
