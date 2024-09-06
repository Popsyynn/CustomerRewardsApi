package com.example.rewardmanagement.repository;

import com.example.rewardmanagement.entity.CustomerReward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerReward, Integer> {
    CustomerReward findByCustomerId(int customerId);
}
