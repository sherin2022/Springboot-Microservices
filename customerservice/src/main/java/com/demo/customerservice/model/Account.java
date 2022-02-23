package com.demo.customerservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer accountId;  //will be autogenerated in DB

    // @NotBlank(message="accountNumber cannot be blank")
    private Long accountNumber;


    @Value("${account.balance:1000}")
    private Long accountBalance; //default value
    private BigInteger customerId; //passed by customerservice application

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    private Boolean isAccountActive;

//    public Account(Long accountNumber, AccountType accountType, Long accountBalance, int customerId,Boolean isAccountActive) {
//        this.accountNumber = accountNumber;
//        this.accountType = accountType;
//        this.accountBalance = accountBalance;
//        this.customerId = customerId;
//        this.isAccountActive= isAccountActive;
//
//    }
}
