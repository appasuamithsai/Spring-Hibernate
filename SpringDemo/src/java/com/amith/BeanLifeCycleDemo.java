package com.amith;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=
                new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
        Coach coach=context.getBean("myCoach",Coach.class);

        System.out.println(coach.getDailyWorkout());
        context.close();

    }
}
