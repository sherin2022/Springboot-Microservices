package com.demo.customerservice.service;

import com.demo.customerservice.model.Account;
import com.demo.customerservice.model.Address;
import com.demo.customerservice.model.Customer;
import com.demo.customerservice.repo.AddressRepo;
import com.demo.customerservice.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

//    @Autowired
//    RestTemplate restTemplate;

     @Autowired
     CustomerRepo customerRepo;

     @Autowired
     AddressRepo addressRepo;

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepo.save(new Customer(customer.getCustomerId(),customer.getName(),customer.getAadharNumber(),addressRepo.save(new Address(customer.getCustomerId(),customer.getAddress().getHouseNumber(),customer.getAddress().getHouseStreet(),customer.getAddress().getCity(),customer.getAddress().getState(),customer.getAddress().getPincode())),customer.getCreateDate(),customer.getLastUpdateDate(),customer.getIsCustomerActive()));
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(Integer id) {

        return customerRepo.findByCustomerId(id);
    }

    @Override
    public int deleteCustomer(Integer id) {
        Optional<Customer> customerToBeDeleted = customerRepo.findByCustomerId(id);
        if(customerToBeDeleted.isPresent()) {
            Customer updateCustomer = customerToBeDeleted.get();
            updateCustomer.setIsCustomerActive(false);
            customerRepo.save(updateCustomer);
            return customerToBeDeleted.get().getCustomerId();
        }
        else
            return 0;
    }





//    @Override
//    public Customer addCustomer(Customer customer) {
////        Integer customerId = customer.getCustomerId();
////        HttpHeaders httpHeaders = new HttpHeaders();
////        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
////        HttpEntity<Integer> httpEntity = new HttpEntity<>(customerId, httpHeaders);
////        Integer accId =restTemplate.postForObject("http://accountservice/accounts/addAccount",httpEntity,Integer.class);
////        customer.setAccountId(accId);
////        if(accId!=null)
////            customer.setIsAccountCreated(true);
////        else
////            customer.setIsAccountCreated(false);
//       return customerRepo.save(new Customer(customer.getName(),customer.getAadharNumber(),customer.getCustomerId(),customer.getCreateDate(),customer.getIsAccountCreated(),customer.getAccountId()));
////    }
//
//
//    @Override
//    public Customer getCustomer(Integer id) {
//
//       // Optional<Customer> customerDetails = customerRepo.findByCustomerId(customerId);
//       // if (customerDetails.isPresent())
//        //    return customerDetails.get();
//        //else return null;
//
//            customerRepo.findByCustomerId(Integer customerId).get();
//    }
//
//    @Override
//    public List<Customer> getAllCustomers() {
//        return customerRepo.findAll();
//    }


}





