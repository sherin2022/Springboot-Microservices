package com.demo.accountservice.service;

import com.demo.accountservice.model.Account;

import java.math.BigInteger;
import java.util.List;

public interface AccountService {
    public Account createAccount(Account account);
    public List<Account> getAllAccountDetails(BigInteger id);
    public Account getAccountById(Integer id);
    public Boolean isAccountActive(BigInteger id);
    public void deleteAccount(BigInteger custId);

}
