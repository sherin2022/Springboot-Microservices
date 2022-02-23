package com.demo.accountservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="Account does not exist for this customer")
public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
