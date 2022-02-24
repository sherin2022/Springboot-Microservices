package com.example.gateway.gatewaydemo.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableEurekaClient
public class RouteConfig {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route("accountservice", rt -> rt.path("/accounts/**")
                        .uri("http://localhost:8071/"))
                .route("customerservice",rt -> rt.path("/customers/**")
                        .uri("http://localhost:8070/"))
                .build();

    }
}
