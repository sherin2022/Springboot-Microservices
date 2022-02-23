package com.demo.customerservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Data
public class Address {
    private Integer houseNumber;
    private String houseStreet;
    private String city;
    private String state;
    private Integer pincode;

    public Address(Integer houseNumber, String houseStreet, String city, String state, Integer pincode) {
        this.houseNumber = houseNumber;
        this.houseStreet = houseStreet;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }
}
