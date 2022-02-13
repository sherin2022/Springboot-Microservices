package com.demo.accountservice.controller;

import com.demo.accountservice.model.Account;
import com.demo.accountservice.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/accounts")
public class AccountController {

        @Autowired
        AccountService accountService;

        @GetMapping("/getaccountdetails")
        public List<Account> getAccounts(){
                return accountService.getAllAccountDetails();
        }

        @PostMapping("/addAccount")
        public ResponseEntity<Account> addAccount(@RequestBody Account account){
             return new ResponseEntity<>(accountService.createAccount(account), HttpStatus.CREATED);

        }

}
