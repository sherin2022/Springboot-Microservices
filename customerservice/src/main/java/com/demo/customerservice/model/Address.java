package com.demo.customerservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="address")
@Data
public class Address {



    private int customerId;
    private Integer houseNumber;
    private String houseStreet;
    private String city;
    private String state;
    private Integer pincode;

    public Address(int customerId, Integer houseNumber, String houseStreet, String city, String state, Integer pincode) {
        this.customerId= customerId;
        this.houseNumber = houseNumber;
        this.houseStreet = houseStreet;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }
}
