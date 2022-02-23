package com.demo.customerservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerUpdatableData {

    @NotNull(message="Address field can't be blank")
    Address address;
    private long phoneNumber;


}
