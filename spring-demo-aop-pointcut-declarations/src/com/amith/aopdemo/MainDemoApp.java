package com.amith.aopdemo;

import com.amith.aopdemo.dao.AccountDAO;
import com.amith.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO=context.getBean("accountDAO",AccountDAO.class);
        MembershipDAO membershipDAO=context.getBean("membershipDAO",MembershipDAO.class);
        accountDAO.addAccount(new Account(),true);
        accountDAO.doWork();
        System.out.println();
        membershipDAO.addSillyMember();
        membershipDAO.goToSleep();
        context.close();
    }
}
