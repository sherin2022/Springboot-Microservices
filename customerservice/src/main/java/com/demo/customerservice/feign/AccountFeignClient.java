package com.demo.customerservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.demo.customerservice.model.Account;
import org.springframework.cloud.openfeign.FallbackFactory;

import java.math.BigInteger;
import java.util.List;

@FeignClient(name = "accountservice", fallbackFactory = HystrixFallbackFactory.class)
public interface AccountFeignClient {


    @GetMapping("/accounts/customer-all-accounts/{id}")
    public List<Account> getAccountsByCustomerId(@PathVariable("id") BigInteger id);

    @PostMapping("/accounts/account-new")
    public Account addAccount(@RequestBody Account account);

    @DeleteMapping("/accounts/account-delete/{custId}")
    public Boolean deleteAccount(@PathVariable("custId") BigInteger custId);

}
