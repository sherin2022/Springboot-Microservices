package com.demo.customerservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class  CustomerAccount {


    private Customer customer_model;
    private Account account_model;

}
