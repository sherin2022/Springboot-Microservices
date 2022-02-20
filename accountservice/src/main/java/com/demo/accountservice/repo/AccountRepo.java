package com.demo.accountservice.repo;

import com.demo.accountservice.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface AccountRepo extends JpaRepository<Account,Integer>{
    public List<Account> findAccountByCustomerId(Integer id);


}
