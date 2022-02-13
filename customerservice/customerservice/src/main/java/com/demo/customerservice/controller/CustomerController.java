package com.demo.customerservice.controller;

import com.demo.customerservice.model.Customer;
import com.demo.customerservice.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;


    @GetMapping("/getcustomerinfo")
    public List<Customer> getCustomers(){
        return customerService.getAllCustomers();

    }
    @PostMapping("/addcustomer")
    public void addCustomer(@RequestBody Customer customer){

        customerService.addCustomer(new Customer(customer.getName(),customer.getAadharNumber(),customer.getCreateDate()));
    }
}
