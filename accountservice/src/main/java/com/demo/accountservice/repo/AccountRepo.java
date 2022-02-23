package com.demo.accountservice.repo;

import com.demo.accountservice.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;


public interface AccountRepo extends JpaRepository<Account,Integer>{
    public List<Account> findAccountByCustomerId(BigInteger id);


}
