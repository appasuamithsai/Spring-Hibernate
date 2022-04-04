package com.amith.spring.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;

    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach : "+coachName+" ,Team : "+teamName+".";
    }

    @GetMapping("/")
    public String sayHello(){
        return  "Hello - world Time on Server is : "+ LocalDateTime.now();
    }


    @GetMapping("/workout")
    public String getDailyWorkout(){
        return  "run hard 5K!!!";
    }


}
