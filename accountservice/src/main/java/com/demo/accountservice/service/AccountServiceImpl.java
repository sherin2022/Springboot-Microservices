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
       return accountRepo.save(account);
    }

    @Override
    public List<Account> getAllAccountDetails(Integer customerId) {

        List<Account> accountDetails = accountRepo.findAccountByCustomerId(customerId);
            return accountDetails;
    }

    @Override
    public Account getAccountById(Integer id) {
        Optional<Account> accountDetails = accountRepo.findById(id);
        if(accountDetails.isPresent())
            return accountDetails.get();
        else
            return null;
    }

    @Override
    public Account deleteAccount(Integer accId) {
        Optional<Account> accountToBeDeleted = accountRepo.findById(accId);
        accountToBeDeleted.get().setIsAccountActive(false);
        return accountToBeDeleted.get();

    }

  //  @Override
//    public List<Account> deleteAllAccounts(Integer custId) {
//        List<Account> accountsToBeDeleted = accountRepo.findAllById(custId);
//        for (Account account : accountsToBeDeleted) {
//            account.setIsAccountActive(false);
//        }
//        return accountsToBeDeleted;

  //  }


}