package com.example.rewardmanagement;

import com.example.rewardmanagement.entity.CashBackHistory;
import com.example.rewardmanagement.entity.CustomerReward;
import com.example.rewardmanagement.repository.CashBackRepository;
import com.example.rewardmanagement.repository.CustomerRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class RewardManagementApplication {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CashBackRepository cashBackRepository;

    @PostConstruct
    public void initDB() {
        // Sample data for CustomerRewards
        CustomerReward customer1 = new CustomerReward();
        customer1.setTotalCashback(4000);
        customer1.setCurrentBalance(200.0);

        CustomerReward customer2 = new CustomerReward();
        customer2.setTotalCashback(1000.0);
        customer2.setCurrentBalance(750.0);

        // Save the customer rewards data
        customerRepository.save(customer1);
        customerRepository.save(customer2);

        // Sample data for CashbackHistory
        CashBackHistory transaction1 = new CashBackHistory();
        transaction1.setCustomerId(customer1.getCustomerId());
        transaction1.setTransactionDate(LocalDate.now().minusDays(10));
        transaction1.setAmountEarned(100.0);
        transaction1.setDescription("Booking cashback");

        CashBackHistory transaction2 = new CashBackHistory();
        transaction2.setCustomerId(customer1.getCustomerId());
        transaction2.setTransactionDate(LocalDate.now().minusDays(5));
        transaction2.setAmountEarned(50.0);
        transaction2.setDescription("Shopping cashback");

        CashBackHistory transaction3 = new CashBackHistory();
        transaction3.setCustomerId(customer2.getCustomerId());
        transaction3.setTransactionDate(LocalDate.now().minusDays(20));
        transaction3.setAmountEarned(250.0);
        transaction3.setDescription("Dining cashback");

        // Save the cashback history data
        cashBackRepository.saveAll(Arrays.asList(transaction1, transaction2, transaction3));
    }


    public static void main(String[] args) {
        SpringApplication.run(RewardManagementApplication.class, args);



    }
}
