package com.demo.customerservice.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import rx.BackpressureOverflow;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Document(collection="customers")
@Data
@NoArgsConstructor
public class Customer {



//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private String Id;

    @Id
    private int customerId;

    @NotBlank(message ="Customer name cannot be black")
    private String name;

    @NotBlank(message="aadharNumber cannot be blank")
    @Size(min = 12)
    private String aadharNumber;

    Address address;

    private Date createDate;
    private Date lastUpdateDate;
    private AccountHolderType accountHolderType;

    // added account info to customer

    private Boolean isCustomerActive;

    @Value("${initial.value:0")
    private Integer NoOfActiveAccounts;

    public Customer(int customerId, String name, String aadharNumber, Address address, Date createDate, Date lastUpdateDate, Boolean isCustomerActive) {
        this.customerId = customerId;
        this.name = name;
        this.aadharNumber = aadharNumber;
        this.address = address;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
        this.isCustomerActive = isCustomerActive;
    }
}
