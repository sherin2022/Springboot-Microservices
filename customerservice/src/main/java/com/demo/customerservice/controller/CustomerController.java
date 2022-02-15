package com.demo.customerservice.controller;

import com.demo.customerservice.model.Customer;
import com.demo.customerservice.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("getcustomerinfo")
    public List<Customer> getAllCustomers(){
        return customerService.getCustomer();
    }


    @GetMapping("/getcustomerinfo/{id}")
    public Customer getCustomers(@PathVariable("id") Integer id){
        return customerService.getAllCustomers(id);

    }
    @PostMapping("/addcustomer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.CREATED);
    }


}
