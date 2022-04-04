package com.amith.springboot.thymeleafdemo.controller;

import com.amith.springboot.thymeleafdemo.entity.Employee;
import com.amith.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService service;
    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public String listEmployee(Model model){
        List<Employee> employeeList=service.findAll();
        model.addAttribute("employees",employeeList);
        return "list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        Employee employee=new Employee();
        model.addAttribute("employee",employee);
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        System.out.println(employee);
        service.save(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id,Model model){
        Employee employee=service.findById(id);
        model.addAttribute("employee",employee);
        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id){
        service.deleteById(id);
        return "redirect:/employees/list";
    }

}
