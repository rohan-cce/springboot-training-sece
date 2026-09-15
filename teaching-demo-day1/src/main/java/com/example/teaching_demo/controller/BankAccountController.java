package com.example.teaching_demo.controller;

import com.example.teaching_demo.dto.BankAccountDTO;
import com.example.teaching_demo.service.BankAccountService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// @RestController // <-- TUTOR SABOTAGE: Leave this commented out! Hit localhost:8080/accounts and watch it yield a massive 404 NOT FOUND error organically. Uncomment it live to fix!
public class BankAccountController {
    
    // N-Tier Dependency Injection seamlessly bridging Controller directly into Service
    private final BankAccountService accountService;

    public BankAccountController(BankAccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/accounts")
    public String addBankAccount(@RequestBody BankAccountDTO account) {
        return accountService.addBankAccount(account);
    }

    @GetMapping("/accounts")
    public List<BankAccountDTO> getBankAccounts() {
        return accountService.getAllBankAccounts();
    }
}
