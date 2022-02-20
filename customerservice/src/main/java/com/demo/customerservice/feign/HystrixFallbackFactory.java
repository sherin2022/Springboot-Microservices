package com.demo.customerservice.feign;

import org.springframework.cloud.openfeign.FallbackFactory;

public class HystrixFallbackFactory implements FallbackFactory<AccountFeignClient> {
    @Override
    public AccountFeignClient create(Throwable cause) {

        System.out.println("fallback; reason was: " + cause.getMessage());
        return null;

    }
}
