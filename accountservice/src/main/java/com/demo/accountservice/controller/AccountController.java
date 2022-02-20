package com.demo.accountservice.controller;

import com.demo.accountservice.model.Account;
import com.demo.accountservice.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@Slf4j
@RequestMapping("/accounts")
public class AccountController {

        @Autowired
        AccountService accountService;

        @GetMapping("/getaccountbycustomer/{id}")
        public List<Account> getAccountsByCustomerId(@PathVariable("id")Integer id){
                return accountService.getAllAccountDetails(id);
        }

        @GetMapping("/getaccountdetails/{id}")
        public Account getAccountsById(@PathVariable("id")Integer id){
                return accountService.getAccountById(id);
        }

        @PostMapping("/addAccount")
        public Integer addAccount(@Valid @RequestBody Account account){
                return accountService.createAccount(account).getAccountId();
        }

        @DeleteMapping("/deleteaccount/{accId}")
        public Account deleteAccount(@PathVariable("accId") Integer accId){
                return accountService.deleteAccount(accId);

        }

//        @DeleteMapping("/deleteAccount/{custid}")
//        public List<Account> deleteAllAccounts(@PathVariable("custid") Integer custid) {
//                return accountService.deleteAllAccounts(custid);

 //       }


}



