package com.demo.customerservice.controller;

import com.demo.customerservice.feign.AccountFeignClient;
import com.demo.customerservice.model.Account;
import com.demo.customerservice.model.Customer;
import com.demo.customerservice.model.CustomerAccount;
import com.demo.customerservice.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.Path;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    AccountFeignClient accountFeignClient;

    @Autowired
    private CustomerService customerService;

    //To access all the customer records
    @GetMapping("getcustomerinfo")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    //To access the account information of a particular accountId
    @GetMapping("accountdetails/{id}")
    public Account getAccountFeignClient(@PathVariable Integer id) {
        return accountFeignClient.getAccountsByCustomerId(id);
    }

    //To access customer information of a particular customerId
    @GetMapping("/getcustomerinfo/{id}")
    public ResponseEntity<Optional<Customer>> getCustomers(@PathVariable("id") Integer id){
        Optional<Customer> customer1 = customerService.getCustomerById(id);
        return new ResponseEntity<Optional<Customer>>(customer1, HttpStatus.CREATED);

    }


    //To access information of a customer and the customers different accounts.
    @GetMapping("/getcustomerallaccountinfo/{id}")
    public ResponseEntity<CustomerAccount> getAllCustomerAccountData(@PathVariable("id") Integer id){
      CustomerAccount customerAccount =new CustomerAccount();
      Optional<Customer> customer = customerService.getCustomerById(id);
      customerAccount.setCustomer_model(customer.get());
      Account account = accountFeignClient.getAccountsByCustomerId(id);
      customerAccount.setAccount_model(account);
      return new ResponseEntity<CustomerAccount>(customerAccount,HttpStatus.OK);

    }

    //To make a customer entry and account creation.
    @PostMapping("/addnewcustomer")
    public ResponseEntity<CustomerAccount> addCustomerAccountData(@Valid @RequestBody CustomerAccount customerAccount){

        Customer newCustomer = customerService.addCustomer(customerAccount.getCustomer_model());
        int newCustomerId = customerAccount.getCustomer_model().getCustomerId();
        customerAccount.getAccount_model().setCustomerId(newCustomerId);
        accountFeignClient.addAccount(customerAccount.getAccount_model());

        return new ResponseEntity<CustomerAccount>(customerAccount,HttpStatus.CREATED);

    }

    //To make create an account for an existing customer
    @PostMapping("/opennewaccount")
    public ResponseEntity<Account> createNewAccount(@Valid @RequestBody Account newAccount ){
        accountFeignClient.addNewAccount(newAccount);
        return new ResponseEntity<Account>(newAccount,HttpStatus.CREATED);
    }

    //To delete a customer/ make the customer inactive
    @DeleteMapping("/deletecustomer/{id}")
    public ResponseEntity<Integer> DeleteCustomer(@PathVariable("id") Integer id ){
        int deletedId = customerService.deleteCustomer(id);
//        accountFeignClient.deleteAllAccounts(id);
        return new ResponseEntity<Integer>(deletedId,HttpStatus.OK);

    }

    //To delete the account of a customer/ make the account inactive.
    @DeleteMapping("/deleteaccount/{accId}")
    public ResponseEntity<Account> DeleteAccount(@PathVariable Integer accId){
        Account deletedAccount = accountFeignClient.deleteAccount(accId);
        return new ResponseEntity<Account>(deletedAccount,HttpStatus.OK);
    }

}
