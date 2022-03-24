package com.amith;

public class TrackCoach implements Coach {
    private FortuneService fortuneService;
    public TrackCoach(){}

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }
    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return "Just Do IT "+ fortuneService.getFortune();
    }

    public void doMyStartupStuff(){
        System.out.println("TrackCoach is Initialized" );
    }
    public void doMyCleanupStuffYoYo(){
        System.out.println("TrackCoach is Destroyed" );
    }


}
