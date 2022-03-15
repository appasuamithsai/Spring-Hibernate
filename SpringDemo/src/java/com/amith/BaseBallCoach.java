package com.amith;

public class BaseBallCoach implements Coach{

    private FortuneService fortuneService;

    public BaseBallCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout(){
        return "Spend 30 mins on batting Practice";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
