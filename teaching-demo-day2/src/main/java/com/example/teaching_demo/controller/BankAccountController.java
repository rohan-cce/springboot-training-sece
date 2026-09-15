package com.example.teaching_demo.controller;

import com.example.teaching_demo.dto.BankAccountDTO;
import com.example.teaching_demo.entity.BankAccount;
import com.example.teaching_demo.service.BankAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts") // API Versioning Guidelines
public class BankAccountController {
    
    private final BankAccountService service;

    public BankAccountController(BankAccountService service) {
        this.service = service;
    }

    // DEBUG TRAP: Missing @RequestBody. Spring inherently falls back to query mapping. 
    // Postman JSON will be silently ignored resulting in Account Holder Name=null, Balance=0 natively saving to MySQL!
    @PostMapping
    public ResponseEntity<BankAccount> addBankAccount(BankAccountDTO dto) {
        return ResponseEntity.ok(service.addBankAccount(dto));
    }

    @GetMapping
    public ResponseEntity<List<BankAccount>> getAllBankAccounts() {
        return ResponseEntity.ok(service.getAllBankAccounts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankAccount> getBankAccountById(@PathVariable Long id) {
        return service.getBankAccountById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BankAccount> updateBankAccount(@PathVariable Long id, @RequestBody BankAccountDTO dto) {
        BankAccount updated = service.updateBankAccount(id, dto);
        return (updated != null) ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBankAccount(@PathVariable Long id) {
        service.deleteBankAccount(id);
        return ResponseEntity.ok().build();
    }
}
