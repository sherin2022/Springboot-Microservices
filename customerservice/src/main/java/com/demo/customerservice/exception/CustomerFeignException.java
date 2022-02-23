package com.demo.customerservice.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE,reason = "")
public class CustomerFeignException extends RuntimeException{
    public CustomerFeignException(String errorMessage) {
        super(errorMessage);
    }
}
