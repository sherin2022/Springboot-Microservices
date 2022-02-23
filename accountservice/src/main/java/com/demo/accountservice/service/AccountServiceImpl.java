package com.demo.accountservice.service;

import com.demo.accountservice.model.Account;
import com.demo.accountservice.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;


@Service
public class AccountServiceImpl implements AccountService {



    @Autowired
    AccountRepo accountRepo;


    @Override
    public Account createAccount(Account account) {
        account.setIsAccountActive(true);
        return accountRepo.save(new Account(account.getAccountNumber(),account.getAccountBalance(),account.getCustomerId(),account.getAccountType(),account.getIsAccountActive()));
    }

    @Override
    public List<Account> getAllAccountDetails(BigInteger customerId) {

        return accountRepo.findAccountByCustomerId(customerId);

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
    public Boolean isAccountActive(BigInteger custId) {
        List<Account> accountActive = accountRepo.findAccountByCustomerId(custId);
        int countofActiveAccounts =0;
        for(Account account: accountActive){
            if(Boolean.TRUE.equals(account.getIsAccountActive()))
                countofActiveAccounts++;
        }
        if(countofActiveAccounts>0) return true;
        else return false;

    }

    @Override
    public void deleteAccount(BigInteger custId) {
        List<Account> accountToBeDeleted = accountRepo.findAccountByCustomerId(custId);
        for(Account account: accountToBeDeleted){
            account.setIsAccountActive(false);
            accountRepo.save(account);
        }
    }


}