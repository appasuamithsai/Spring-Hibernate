package com.amith.springdemo.rest;

import com.amith.springdemo.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> list=new ArrayList<>();



    @PostConstruct
    public void loadData(){
        list.add(new Student("Amith","Sai"));
        list.add(new Student("Ajith","Sai"));
        list.add(new Student("Charan","Sai"));
    }


    @GetMapping("/students")
    public List<Student> getStudents(){
        return list;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        if(studentId<0 || studentId>=list.size() ){
            throw new StudentNotFoundException("Student is not found with id = "+studentId);
        }
        return list.get(studentId);
    }



}
