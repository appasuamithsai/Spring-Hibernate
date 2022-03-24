package com.amith;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService{
    private String data[]={"Be Aware OF DOgs ","Today is Monday ","Today is Sunday"};
    private Random random=new Random();

    @Override
    public String getFortune() {
        int index=random.nextInt(data.length);

        return data[index];
    }
}
