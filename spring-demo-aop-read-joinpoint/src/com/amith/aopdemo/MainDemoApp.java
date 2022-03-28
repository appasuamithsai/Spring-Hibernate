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
        accountDAO.addAccount(new Account("Amith","plt"),true);
        accountDAO.doWork();
        accountDAO.setName("Amith");
        accountDAO.setServiceCode("plt");
        accountDAO.getName();
        accountDAO.getServiceCode();

        System.out.println();
        membershipDAO.addSillyMember();
        membershipDAO.goToSleep();
        context.close();
    }
}
