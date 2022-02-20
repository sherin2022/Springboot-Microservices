package com.demo.customerservice.repo;

import com.demo.customerservice.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepo extends MongoRepository<Customer, Integer> {

    Optional<Customer> findByCustomerId(Integer customerId);

    @Override
    List<Customer> findAll();
}
