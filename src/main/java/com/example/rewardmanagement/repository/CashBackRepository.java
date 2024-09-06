package com.example.rewardmanagement.repository;

import com.example.rewardmanagement.entity.CashBackHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CashBackRepository extends JpaRepository<CashBackHistory, Integer> {
    Optional<List<CashBackHistory>> findByCustomerId(int customerId);
}
