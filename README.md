# Springboot-Microservices

This is a springboot project demo containing 4 project modules to understand the microservices gateway architecture.
This project gives a basic understanding of how to configure eureka server, understand service registry and API Gateway. 
The 4 modules are 4 springboot java projects 
1. eurekaservicedemo - The application is the Eureka Server.
2. gatewaydemo       - The API gateway application to route to the two microservices application.
3. accountservice    - The application to hold bank account details of a customer
4. customerservice    - The application to hold customer details and fire a request to create and account when a customer is created. (feature not added)
