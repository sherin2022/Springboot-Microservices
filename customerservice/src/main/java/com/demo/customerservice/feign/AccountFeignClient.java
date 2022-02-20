package com.demo.customerservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.demo.customerservice.model.Account;
import org.springframework.cloud.openfeign.FallbackFactory;

@FeignClient(name ="accountservice", fallbackFactory = HystrixFallbackFactory.class)
public interface AccountFeignClient {


    @GetMapping("/accounts/getaccountbycustomer/{id}")
    public Account getAccountsByCustomerId(@PathVariable("id")Integer id);

    @PostMapping("/accounts/addAccount")
    public Integer addAccount(@RequestBody Account account);

    @PostMapping("/accounts/addNewAccount")
    public Integer addNewAccount(Account newAccount);

    @DeleteMapping("/accounts/deleteaccount/{accId}")
    public Account deleteAccount(@PathVariable("accId") Integer accId);

//    @DeleteMapping("/deleteAccount/{custid}")
//    void deleteAllAccounts(@PathVariable("custid") Integer custid);
}
