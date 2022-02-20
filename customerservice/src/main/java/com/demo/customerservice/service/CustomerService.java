package com.demo.customerservice.service;

import com.demo.customerservice.model.Account;
import com.demo.customerservice.model.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;


public interface CustomerService {

    Customer addCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Optional<Customer> getCustomerById(Integer id);
    int deleteCustomer(Integer id);
}
