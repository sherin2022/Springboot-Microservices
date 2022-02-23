package com.demo.customerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Exception to handle the attempt to access a customer record which is not in the db.
@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such customer record found.")
public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
