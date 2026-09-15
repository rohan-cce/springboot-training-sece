package com.example.teaching_demo.controller;
import com.example.teaching_demo.dto.BankAccountDTO;
import com.example.teaching_demo.entity.BankAccount;
import com.example.teaching_demo.service.BankAccountService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BankAccountController {
    private final BankAccountService service;
    public BankAccountController(BankAccountService service) { this.service = service; }
    @PostMapping("/accounts")
    public ResponseEntity<BankAccount> addBankAccount(@Valid @RequestBody BankAccountDTO dto) {
        return ResponseEntity.ok(service.addBankAccount(dto));
    }
    @GetMapping("/accounts")
    public List<BankAccount> getBankAccounts() {
        return service.getAllBankAccounts();
    }
}
