package com.demo.customerservice.config;

import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

@Slf4j
public class MyErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();
    private static Logger logger = LoggerFactory.getLogger(MyErrorDecoder.class);

    @Override
    public Exception decode(String s, Response response) {
        Exception exception = defaultErrorDecoder.decode(s, response);

        if(exception instanceof RetryableException){
            return exception;
        }


        if(response.status() == 503){
            logger.info("Retrying in ...");
            return new RetryableException(response.status(), "503 error", response.request().httpMethod(), new Date(),response.request());
        }

        return exception;
    }
}

