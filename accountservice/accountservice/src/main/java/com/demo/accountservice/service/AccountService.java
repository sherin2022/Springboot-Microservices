package com.demo.accountservice.service;

import com.demo.accountservice.model.Account;

import java.util.List;

public interface AccountService {
    public Account createAccount(Account account);
    public Account getAllAccountDetails(Integer id);

}
