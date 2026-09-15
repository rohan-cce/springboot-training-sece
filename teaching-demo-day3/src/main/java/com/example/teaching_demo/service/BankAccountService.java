package com.example.teaching_demo.service;
import com.example.teaching_demo.dto.BankAccountDTO;
import com.example.teaching_demo.entity.BankAccount;
import com.example.teaching_demo.repository.BankAccountRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class BankAccountService {
    private final BankAccountRepository repository;
    public BankAccountService(BankAccountRepository repository) { this.repository = repository; }
    public BankAccount addBankAccount(BankAccountDTO dto) {
        BankAccount account = new BankAccount();
        account.setAccountHolderName(dto.getAccountHolderName());
        account.setBalance(dto.getBalance());
        return repository.save(account);
    }
    public List<BankAccount> getAllBankAccounts() { return repository.findAll(); }
    public Optional<BankAccount> getBankAccountById(Long id) { return repository.findById(id); }
    public BankAccount updateBankAccount(Long id, BankAccountDTO dto) {
        Optional<BankAccount> existing = repository.findById(id);
        if (existing.isPresent()) {
            BankAccount s = existing.get();
            s.setAccountHolderName(dto.getAccountHolderName());
            s.setBalance(dto.getBalance());
            return repository.save(s);
        }
        return null;
    }
    public void deleteBankAccount(Long id) { repository.deleteById(id); }
}
