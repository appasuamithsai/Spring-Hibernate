package com.amith;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach coach=context.getBean("tennisCoach",Coach.class);
        Coach coach1=context.getBean("tennisCoach",Coach.class);
        System.out.println("Same Obj: "+(coach==coach1));
        System.out.println(coach);
        System.out.println(coach1);
        context.close();
    }
}
