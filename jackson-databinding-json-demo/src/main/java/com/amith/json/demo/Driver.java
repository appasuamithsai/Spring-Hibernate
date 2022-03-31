package com.amith.json.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
        try{

            ObjectMapper objectMapper=new ObjectMapper();

            Student student=objectMapper.readValue(new File("data/sample-full.json"),Student.class);

            System.out.println(student.getFirstName());

            System.out.println(student.getLastName()    );

            System.out.println(student.getAddress());

            System.out.println(Arrays.toString(student.getLanguages()));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
