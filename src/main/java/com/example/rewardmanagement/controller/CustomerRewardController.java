package com.example.rewardmanagement.controller;


import com.example.rewardmanagement.entity.CashBackHistory;
import com.example.rewardmanagement.entity.CustomerReward;
import com.example.rewardmanagement.exception.CustomerNotFoundException;
import com.example.rewardmanagement.service.CashBackService;
import com.example.rewardmanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rewards")
public class CustomerRewardController {

    @Autowired
    CustomerService customerService;

    @Autowired
    CashBackService cashBackService;


    @RequestMapping(method = RequestMethod.GET, value = "/balance/{customerId}")
    public ResponseEntity<Optional<CustomerReward>> getCustomerReward(@PathVariable int customerId) throws CustomerNotFoundException {
        return new ResponseEntity<>(customerService.getCustomerReward(customerId), HttpStatus.FOUND);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/history/{customerId}")
    public ResponseEntity<Optional<List<CashBackHistory>>> getCustomerRewardHistory(@PathVariable int customerId) throws CustomerNotFoundException {
        return new ResponseEntity<>(cashBackService.getCashBackHistory(customerId), HttpStatus.FOUND);
    }

}
