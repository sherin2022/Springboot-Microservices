package com.demo.customerservice.controller;

import com.demo.customerservice.exception.CustomerExistsException;
import com.demo.customerservice.exception.CustomerNotFoundException;
import com.demo.customerservice.model.Customer;
import com.demo.customerservice.model.CustomerAccount;
import com.demo.customerservice.model.CustomerAllAccount;
import com.demo.customerservice.model.CustomerUpdatableData;
import com.demo.customerservice.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
@RestController
@Slf4j
@RequestMapping("/personal-banking")
public class CustomerController {


    @Autowired
    private CustomerService customerService;

    //To make a customer entry and account creation. Test case verified
    @PostMapping("/customer-new")
    public ResponseEntity<CustomerAccount> addCustomerAccountData(@Valid @RequestBody CustomerAccount customerAccount){
        BigInteger customerId = customerAccount.getCustomer_model().getCustomerId(); //Get the new customer id.
        if(Boolean.TRUE.equals(customerService.isCustomerPresent(customerId))){
            throw new CustomerExistsException("Duplicate Entry for customer: " +customerId);
        }
        return new ResponseEntity<>(customerService.addCustomer(customerAccount),HttpStatus.CREATED);

    }

    //To access all the customer records. Test case verified.
    @GetMapping("customers")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    //To access customer information of a particular with all the account informations of a customer.
    //Test case verified.
    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerAllAccount> getCustomers(@PathVariable("id") BigInteger id){
       if(Boolean.FALSE.equals(customerService.isCustomerPresent(id)))
           throw new CustomerNotFoundException("Customer not Found"+ id);
       return new ResponseEntity<>(customerService.getAllCustomerDataById(id),HttpStatus.FOUND);


    }

    //To delete a customer/ make the customer inactive // Test case verified.
    @DeleteMapping("/customer-delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") BigInteger id ){
        if(Boolean.FALSE.equals(customerService.isCustomerPresent(id)))

            throw new CustomerNotFoundException("Customer Entry Not Found" + id);

        return new ResponseEntity<>(customerService.deleteCustomer(id), HttpStatus.OK);
    }

    @PutMapping("/customer-update/{customerId}")
    public ResponseEntity<Customer> updateCustomerDetails(@PathVariable("customerId") BigInteger customerId, @Valid @RequestBody CustomerUpdatableData customerToBeUpdated){//only specific objects in the DTO object can be updated for a customer
        if(Boolean.FALSE.equals(customerService.isCustomerPresent(customerId)))
        {
            throw new CustomerNotFoundException("Customer "+customerId +" do not exist.");
        }
        return new ResponseEntity<>(customerService.updateCustomer(customerId,customerToBeUpdated), HttpStatus.OK);
    }

    }



