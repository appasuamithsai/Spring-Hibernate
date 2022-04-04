package com.amith.springboot.cruddemo.dao;

import com.amith.springboot.cruddemo.entity.Employee;
import org.hibernate.Session;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        Query query=entityManager.createQuery("from Employee",Employee.class);
        List<Employee> employees=query.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int id) {
        Employee employee=entityManager.find(Employee.class,id);
        return employee;
    }

    @Override
    public void save(Employee employee) {
        Employee employe1=entityManager.merge(employee);
        employee.setId(employe1.getId());
    }

    @Override
    public void deleteById(int id) {
        Query query=entityManager.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId",id);
        query.executeUpdate();
    }
}
