package com.amith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach{
    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;
    public TennisCoach(){}
    /*
    @Autowired
    public TennisCoach(FortuneService fortuneService){
        this.fortuneService=fortuneService;
    }
    */
    /*
    @Autowired
    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }
    */
    /*
    @Autowired
    public void doSomeCrazyStuff(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }
    */

    @PostConstruct
    public void doMyStartUppStuff(){
        System.out.println("In startUp Stuff");
    }

    @PreDestroy
    public void doMyCleanUpStuff(){
        System.out.println("in cleanUp Stuff");
    }



    @Override
    public String getDailyWorkout() {
        return "Practice Your backhand volley ";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
