package com.example.teaching_demo.repository;

import com.example.teaching_demo.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
    // Basic CRUD operations are completely implicitly generated!
}
