package com.demo.customerservice.service;

import com.demo.customerservice.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {

    Customer addCustomer(Customer customer);
    List<Customer> getAllCustomers();
}
