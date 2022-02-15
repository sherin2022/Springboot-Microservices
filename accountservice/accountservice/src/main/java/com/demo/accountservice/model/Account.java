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
    private Integer accountId;
    private Long accountNumber;
    private String accountType;
    private Long accountBalance;
    private Integer customerId;

    public Account(Long accountNumber, String accountType, Long accountBalance, Integer customerId) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
        this.customerId = customerId;
    }
}
