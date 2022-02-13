package com.demo.accountservice.repo;

import com.demo.accountservice.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepo extends JpaRepository<Account,Integer>{
}
