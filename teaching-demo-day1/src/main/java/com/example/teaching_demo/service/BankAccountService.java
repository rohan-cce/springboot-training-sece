package com.example.teaching_demo.service;

import com.example.teaching_demo.dto.BankAccountDTO;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BankAccountService {
    
    // VOLATILE MEMORY STORAGE: This array dies the exact second the Server stops running.
    // Explicitly isolated directly inside the Service layer natively honoring N-Tier separation early!
    private final List<BankAccountDTO> accounts = new ArrayList<>();

    public String addBankAccount(BankAccountDTO account) {
        
        // TUTOR SABOTAGE (MASSIVE RUNTIME EXCEPTION): 
        // When you test POST in Postman, this dynamically triggers a horrific unchecked Runtime Exception!
        // It bypasses everything returning a catastrophic raw 500 Internal Error. Comment it out to fix!
        if (true) throw new RuntimeException("Simulated Hardware/Network Complete Meltdown Exception!");

        accounts.add(account);
        return "BankAccount added successfully! We now have " + accounts.size() + " accounts inside RAM memory.";
    }

    public List<BankAccountDTO> getAllBankAccounts() {
        return accounts;
    }
}
