package com.demo.customerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Exception to handle an attempt of duplicate entry of a customer record.
@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "Duplicate Customer Entry. Customer entry already exists for this customer.")
public class CustomerExistsException extends RuntimeException{
    public CustomerExistsException(String errorMessage){
        super(errorMessage);
    }
}
