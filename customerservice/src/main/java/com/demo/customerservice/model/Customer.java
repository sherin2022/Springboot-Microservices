package com.demo.customerservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Document(collection="customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private String name;
    @Id
    private String id;
    @NotBlank(message="aadharNumber cannot be null")
    private String aadharNumber;
    private Integer customerId;
    private Date createDate;
    // added account info to customer
    private Boolean isAccountCreated;
    private Integer accountId;

    public Customer(String name, String aadharNumber, Integer customerId, Date createDate, Boolean isAccountCreated, Integer accountId) {
        this.name = name;
        this.aadharNumber = aadharNumber;
        this.customerId = customerId;
        this.createDate = createDate;
        this.isAccountCreated = isAccountCreated;
        this.accountId = accountId;
    }
}
