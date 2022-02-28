package com.demo.customerservice.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerRetryClientConfig {

    @Bean
    public Retryer clientServiceRetryer() {
        return new FeignClientRetryer();
    }
}