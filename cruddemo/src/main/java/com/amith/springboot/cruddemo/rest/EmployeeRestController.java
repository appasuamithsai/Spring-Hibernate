package com.amith.springboot.cruddemo.rest;

import com.amith.springboot.cruddemo.dao.EmployeeDAO;
import com.amith.springboot.cruddemo.entity.Employee;
import com.amith.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        if(employeeId<0 && employeeId >=employeeService.findAll().size()){
            throw  new RuntimeException("Employee with id : "+employeeId+" not found.");
        }
        return employeeService.findById(employeeId);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.save(employee);
        return employee;
    }

    @PostMapping("/employees    ")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        employeeService.save(employee);
        return employee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        if(employeeId<0 && employeeId >=employeeService.findAll().size()){
            throw  new RuntimeException("Employee with id : "+employeeId+" not found.");
        }
        employeeService.deleteById(employeeId);
        return "Employee with id : "+employeeId+" deleted";
    }


}
