package com.example.rewardmanagement.service;

import com.example.rewardmanagement.entity.CashBackHistory;
import com.example.rewardmanagement.exception.CustomerNotFoundException;
import com.example.rewardmanagement.repository.CashBackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CashBackService {

    @Autowired
    private CashBackRepository cashBackRepository;

    public Optional<List<CashBackHistory>> getCashBackHistory(int customerId) {
        if (cashBackRepository.findByCustomerId(customerId).isPresent()) {
            Optional<List<CashBackHistory>> cashBackHistoryList = cashBackRepository.findByCustomerId(customerId);
            return cashBackHistoryList;
        }else {
            throw new CustomerNotFoundException();
        }

    }
}
