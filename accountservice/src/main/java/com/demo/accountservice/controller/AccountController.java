package com.demo.accountservice.controller;

import com.demo.accountservice.exceptions.AccountNotFoundException;
import com.demo.accountservice.model.Account;
import com.demo.accountservice.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.math.BigInteger;
import java.util.List;


@RestController
@Slf4j
@RequestMapping("/accounts")
public class AccountController {

        @Autowired
        AccountService accountService;

        @GetMapping("/customer-all-accounts/{id}")
        public List<Account> getAccountsByCustomerId(@PathVariable("id")BigInteger id){
                return accountService.getAllAccountDetails(id);
        }

        @GetMapping("/account/{id}")
        public Account getAccountsById(@PathVariable("id")Integer id){
                return accountService.getAccountById(id);
        }

        @PostMapping("/account-new")
        public ResponseEntity<Account> addAccount(@Valid @RequestBody Account account){
                return new ResponseEntity<>(accountService.createAccount(account), HttpStatus.CREATED);
        }

        @DeleteMapping("/account-delete/{custId}")// this method is called from customer application
        public Boolean deleteAccount(@PathVariable("custId") BigInteger custId)
                {
                if(Boolean.FALSE.equals(accountService.isAccountActive(custId)))
                        throw new AccountNotFoundException("Account not found for customer Id" + custId);
                else {
                        accountService.deleteAccount(custId);
                        return accountService.isAccountActive(custId);
                }

        }


//
        }






