package com.demo.customerservice.repo;

import com.demo.customerservice.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface CustomerRepo extends MongoRepository<Customer, BigInteger> {

    @Override
    List<Customer> findAll();
}
