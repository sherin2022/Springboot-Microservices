package com.demo.accountservice.service;

import com.demo.accountservice.model.Account;

import java.util.List;

public interface AccountService {
    public Account createAccount(Account account);
    public List<Account> getAllAccountDetails(Integer id);
    public Account getAccountById(Integer id);
    public Account deleteAccount(Integer accId);
    //public List<Account> deleteAllAccounts(Integer custId);

}
