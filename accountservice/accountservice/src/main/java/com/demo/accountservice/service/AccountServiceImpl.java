package com.demo.accountservice.service;

import com.demo.accountservice.model.Account;
import com.demo.accountservice.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AccountServiceImpl implements AccountService {

    List<Account> accountList = new ArrayList<>();

    @Autowired
    AccountRepo accountRepo;


    @Override
    public Account createAccount(Account account) {
       return accountRepo.save(new Account(account.getAccountNumber(),account.getAccountType(),account.getAccountBalance()));

    }

    @Override
    public List<Account> getAllAccountDetails() {
        accountList = accountRepo.findAll();
        return accountList;
    }


}