package com.amith.springboot.thymeleafdemo.controller;

import com.amith.springboot.thymeleafdemo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private List<Employee> employeeList;

    @PostConstruct
    public void loadData(){
        Employee employee1=new Employee(1,"Ajith","Sai","ajithsai@gmail.com");
        Employee employee2=new Employee(1,"Amith","Sai","amithsai@gmail.com");
        Employee employee3=new Employee(1,"Charan","Sai","charansai@gmail.com");

        employeeList=new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
    }


    @GetMapping("/list")
    public String listEmployee(Model model){
        model.addAttribute("employees",employeeList);
        return "list-employees";
    }
}
