package com.amith;

public class CricketCoach  implements Coach{
    private String emailAddress;
    private String team;

    private FortuneService fortuneService;
    public CricketCoach(){
        System.out.println("Cricket Constructor : with no args");
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice Fast Bowling for 15mins a day";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
