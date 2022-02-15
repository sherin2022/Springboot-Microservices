package com.demo.accountservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;



@Entity
@Table(name="accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer accountId;  //will be autogenerated in DB
    private Long accountNumber; //will be autogenerated in DB
    private String accountType; //hardcoded value
    private Long accountBalance; //hardcoded value
    private Integer customerId; //passed by customerservice application

    public Account(Long accountNumber, String accountType, Long accountBalance, Integer customerId) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
        this.customerId = customerId;
    }
}
