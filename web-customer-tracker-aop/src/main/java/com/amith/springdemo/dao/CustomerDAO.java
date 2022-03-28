package com.amith.springdemo.dao;

import com.amith.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers();

    public void saveCustomer( Customer customer);

    Customer getCustomers(int id);

    void deleteCustomer(int id);
}
