package com.amith.aopdemo;

import com.amith.aopdemo.dao.AccountDAO;
import com.amith.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainDemoApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO=context.getBean("accountDAO",AccountDAO.class);
        MembershipDAO membershipDAO=context.getBean("membershipDAO",MembershipDAO.class);
        List<Account> accounts=accountDAO.findAccounts();

        System.out.println(accounts);


        context.close();
    }
}
