package com.example.teaching_demo.entity;
import jakarta.persistence.*;
@Entity
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountHolderName;
    private double balance;
    public BankAccount() {}
    public BankAccount(String accountHolderName, double balance) { this.accountHolderName = accountHolderName; this.balance = balance; }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getAccountHolderName() { return accountHolderName; }
    public void setAccountHolderName(String accountHolderName) { this.accountHolderName = accountHolderName; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
}
