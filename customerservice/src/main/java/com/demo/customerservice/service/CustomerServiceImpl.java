package com.demo.customerservice.service;

import com.demo.customerservice.model.Customer;
import com.demo.customerservice.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CustomerRepo customerRepo;

    @Override
    public Customer addCustomer(Customer customer) {
        Integer customerId = customer.getCustomerId();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Integer> httpEntity = new HttpEntity<>(customerId, httpHeaders);
        Integer accId =restTemplate.postForObject("http://accountservice/accounts/addAccount",httpEntity,Integer.class);
        customer.setAccountId(accId);
        if(accId!=null)
            customer.setIsAccountCreated(true);
        else
            customer.setIsAccountCreated(false);
        return customerRepo.save(new Customer(customer.getName(),customer.getAadharNumber(),customer.getCustomerId(),customer.getCreateDate(),customer.getIsAccountCreated(),customer.getAccountId()));
    }

;

    @Override
    public Customer getAllCustomers(Integer customerId) {

        Optional<Customer> customerDetails = customerRepo.findByCustomerId(customerId);
        if (customerDetails.isPresent())
            return customerDetails.get();
        else return null;
    }

    @Override
    public List<Customer> getCustomer() {
        return customerRepo.findAll();
    }


}





