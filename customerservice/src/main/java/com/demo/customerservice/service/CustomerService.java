package com.demo.customerservice.service;

import com.demo.customerservice.model.Customer;
import com.demo.customerservice.model.CustomerAccount;
import com.demo.customerservice.model.CustomerAllAccount;
import com.demo.customerservice.model.CustomerUpdatableData;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;


public interface CustomerService {

    CustomerAccount addCustomer(CustomerAccount CustomerRecord);
    List<Customer> getAllCustomers();
    Optional<Customer> getCustomerById(BigInteger id);
    String deleteCustomer(BigInteger id);
    Boolean isCustomerPresent(BigInteger customerId);
    CustomerAllAccount getAllCustomerDataById(BigInteger id);
    Customer updateCustomer(BigInteger customerId, CustomerUpdatableData customerToBeUpdated);
}
