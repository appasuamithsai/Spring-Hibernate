package com.amith.springdemo.service;

import com.amith.springdemo.entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomers(int id);

    void deleteCustomer(int id);
}
