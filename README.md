# Springboot-Microservices

This is a springboot project demo containing 4 project modules to understand the microservices gateway architecture.
This project gives a basic understanding of how to configure eureka server, understand service registry and API Gateway. 
The 4 modules are 4 springboot java projects 
1. eurekaservicedemo - The application is to enable the Eureka Server to register the microservices and gateway.
2. gatewaydemo       - The API gateway application to route and establish communication between the two microservices application. 
3. accountservice    - The microservice application to hold bank account details of a customer where the object is created and stores in MySQl database when a customer is                              registred/created.
4. customerservice   - The microservice application to hold customer details. The customer properties are stored in NoSQL database. 
                       The customer properties are created by a POST request.
                       When the request is fired, the customer id property is shared to the account service application through an HTTP request from the customer service                                application. The request creates a new account instance in accountservices and stores it to the MySQL database and accountId property is returned to the                          customer service. The customer details/properties are then added to the NoSQL database.
                       
                       On a successful application run. Data should be correctly inserted to the respective tables in mongodb and MySQL database and all HTTP request methods 
                       provided should work and produce the expected output. 


