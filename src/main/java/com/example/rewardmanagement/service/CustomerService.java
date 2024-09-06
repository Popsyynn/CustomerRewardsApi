package com.example.rewardmanagement.service;

import com.example.rewardmanagement.entity.CustomerReward;
import com.example.rewardmanagement.exception.CustomerNotFoundException;
import com.example.rewardmanagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Optional<CustomerReward> getCustomerReward(int customerId) {
        return Optional.ofNullable(customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException()));
    }
}
