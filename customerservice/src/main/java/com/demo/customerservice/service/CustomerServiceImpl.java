package com.demo.customerservice.service;

import com.demo.customerservice.exception.CustomerFeignException;
import com.demo.customerservice.feign.AccountFeignClient;
import com.demo.customerservice.model.*;
import com.demo.customerservice.repo.CustomerRepo;
import com.netflix.hystrix.exception.HystrixRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.springframework.util.ClassUtils.isPresent;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    AccountFeignClient accountFeignClient;

    @Override
    public CustomerAccount addCustomer(CustomerAccount customerRecord) {
        Customer newCustomer = customerRecord.getCustomer_model();
        newCustomer.setIsCustomerActive(true);                //customer is active now
        Account newAccount = customerRecord.getAccount_model();
        newAccount.setCustomerId(newCustomer.getCustomerId());   //passing customer id value
        newAccount.setIsAccountActive(true);                     //account is active now
        Account newAccountAllData= accountFeignClient.addAccount(newAccount); //passing account to accountservice
        LocalDateTime customerCreationDate = LocalDateTime.now();
        Customer newCustomerAllData = new Customer(newCustomer.getCustomerId(),newCustomer.getName(),newCustomer.getAadharNumber(),newCustomer.getAddress(),newCustomer.getPhoneNumber(),customerCreationDate,LocalDateTime.now(),newCustomer.getAccountHolderType(),newCustomer.getIsCustomerActive());
        customerRepo.save(newCustomerAllData);
        customerRecord.setCustomer_model(newCustomerAllData);
        customerRecord.setAccount_model(newAccountAllData);
        return customerRecord;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(BigInteger id) {

        return customerRepo.findById(id);
    }

    @Override
    public String deleteCustomer(BigInteger id) {
        try {
            Optional<Customer> customer = customerRepo.findById(id);
            customer.get().setIsCustomerActive(accountFeignClient.deleteAccount(id));
            customerRepo.save(customer.get());  // will update the customer active state and the last update date.
            return "Customer " + id + " is deactivated";
        } catch (HystrixRuntimeException e) {
            throw new CustomerFeignException("Account Application Not Responding");
        }
     }

        @Override
        public Boolean isCustomerPresent(BigInteger customerId) {
        Optional<Customer> customer = customerRepo.findById(customerId);
        if(customer.isPresent()) { //If no record is found,null value is returned.
            return customer.get().getIsCustomerActive();
        }
        return false;
    }

    @Override
    public CustomerAllAccount getAllCustomerDataById(BigInteger id) {
        Optional<Customer> customerBio = customerRepo.findById(id);
        List<Account> accountData = accountFeignClient.getAccountsByCustomerId(id);
        //Doubt to ask Mansi. Should I rather autowire this content?
//        CustomerAllAccount customerAllAccount= new CustomerAllAccount();
//        customerAllAccount.setCustomerBio(customerData);
//        customerAllAccount.setAccountList(accountData);

        return new CustomerAllAccount(customerBio.get(),accountData);


    }

    @Override
    public Customer updateCustomer(BigInteger customerId, CustomerUpdatableData customerUpdatableData) {
        Optional<Customer> customerToBeUpdated = customerRepo.findById(customerId);
        customerToBeUpdated.get().setAddress(customerUpdatableData.getAddress());
        customerToBeUpdated.get().setPhoneNumber(customerUpdatableData.getPhoneNumber());
        customerToBeUpdated.get().setLastUpdateDate(LocalDateTime.now());

        return customerRepo.save(customerToBeUpdated.get());

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





