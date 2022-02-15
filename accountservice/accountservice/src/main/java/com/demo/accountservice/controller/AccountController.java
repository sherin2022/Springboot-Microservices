package com.demo.accountservice.controller;

import com.demo.accountservice.model.Account;
import com.demo.accountservice.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.*;



import java.util.Random;


@RestController
@Slf4j
@RequestMapping("/accounts")
public class AccountController {

        @Autowired
        AccountService accountService;
        @Value("1000")
        Long accBalance;
        @Value("Savings")
        private String accType;

        @GetMapping("/getaccountdetails/{id}")
        public Account getAccounts(@PathVariable("id")Integer id){
                return accountService.getAllAccountDetails(id);
        }

        @PostMapping("/addAccount")
        public Integer addAccount(@RequestBody Integer customerId){
                Account account = new Account();
                account.setCustomerId(customerId);
                account.setAccountType(accType);
                account.setAccountBalance(accBalance);
             return accountService.createAccount(account).getAccountId();

        }

}
