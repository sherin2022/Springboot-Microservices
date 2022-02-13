package com.demo.customerservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection="customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private String name;
    @Id
    private String id;
    private String aadharNumber;
    private Date createDate;

    public Customer(String name, String aadharNumber, Date createDate) {
        this.name = name;
        this.aadharNumber = aadharNumber;
        this.createDate = createDate;
    }
}
