package com.amith.springdemo.rest;

import com.amith.springdemo.entity.Customer;
import com.amith.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api",produces =  MediaType.APPLICATION_JSON_VALUE)
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return  customerService.getCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId){
        if(customerId <0 || customerId>=customerService.getCustomers().size()){
            throw new CustomerNotFoundException("Customer with id : "+customerId+" not found.");
        }
        Customer customer=customerService.getCustomers().get(customerId);

        return  customer;
    }



    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {
        customer.setId(0);
        customerService.saveCustomer(customer);
        return customer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return customer;
    }


    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId){
        if(customerId <0 || customerId>=customerService.getCustomers().size()){
            throw new CustomerNotFoundException("Customer with id : "+customerId+" not found.");
        }
        customerService.deleteCustomer(customerId);

        return  "Deleted Customer with id - "+customerId;
    }
}
