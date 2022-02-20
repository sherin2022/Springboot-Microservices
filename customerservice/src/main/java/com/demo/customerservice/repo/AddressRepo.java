package com.demo.customerservice.repo;

import com.demo.customerservice.model.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends MongoRepository<Address, String> {
}
