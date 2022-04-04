package com.amith.springboot.cruddemo.dao;

import com.amith.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
