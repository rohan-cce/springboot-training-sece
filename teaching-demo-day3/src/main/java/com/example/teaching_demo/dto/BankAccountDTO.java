package com.example.teaching_demo.dto;
public class BankAccountDTO {
    private String accountHolderName;
    private double balance;
    public BankAccountDTO() {}
    public BankAccountDTO(String accountHolderName, double balance) { this.accountHolderName = accountHolderName; this.balance = balance; }
    public String getAccountHolderName() { return accountHolderName; }
    public void setAccountHolderName(String accountHolderName) { this.accountHolderName = accountHolderName; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
}
