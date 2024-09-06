package com.example.rewardmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CustomerReward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private double totalCashback;
    private double currentBalance;


    public CustomerReward(double currentBalance, int customerId, double totalCashback) {
        this.currentBalance = currentBalance;
        this.customerId = customerId;
        this.totalCashback = totalCashback;
    }

    public CustomerReward() {

    }

    public double getTotalCashback() {
        return totalCashback;
    }

    public void setTotalCashback(double totalCashback) {
        this.totalCashback = totalCashback;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
