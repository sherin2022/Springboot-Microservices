package com.demo.accountservice.service;

import com.demo.accountservice.model.Account;
import com.demo.accountservice.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class AccountServiceImpl implements AccountService {



    @Autowired
    AccountRepo accountRepo;


    @Override
    public Account createAccount(Account account) {
       return accountRepo.save(new Account(account.getAccountNumber(),account.getAccountType(),account.getAccountBalance(),account.getCustomerId()));

    }

    @Override
    public Account getAllAccountDetails(Integer customerId) {
       Optional<Account> accountDetails = accountRepo.findById(customerId);
        if(accountDetails.isPresent())
            return accountDetails.get();
        else
            return null;
    }


}