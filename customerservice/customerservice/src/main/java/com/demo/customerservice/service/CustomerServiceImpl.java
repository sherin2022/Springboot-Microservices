package com.demo.customerservice.service;

import com.demo.customerservice.model.Customer;
import com.demo.customerservice.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepo.save(new Customer(customer.getName(),customer.getAadharNumber(),customer.getCreateDate()));
    }

;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

}





