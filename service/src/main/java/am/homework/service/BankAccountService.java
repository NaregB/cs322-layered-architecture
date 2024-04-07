package am.homework.service;

import am.homework.entity.BankAccount;
import am.homework.repo.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    @Autowired
    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }


    public double checkBalance(Long accountId) {
        Optional<BankAccount> optionalBankAccount = bankAccountRepository.findById(accountId);
        if (optionalBankAccount.isPresent()) {
            BankAccount bankAccount = optionalBankAccount.get();
            return bankAccount.getBalance();
        }
        return -1;
    }


    public boolean debit(Long accountId, double amount) {
        Optional<BankAccount> optionalBankAccount = bankAccountRepository.findById(accountId);
        if (optionalBankAccount.isPresent()) {
            BankAccount bankAccount = optionalBankAccount.get();
            double balance = bankAccount.getBalance();
            if (balance >= amount) {
                bankAccount.setBalance(balance - amount);
                bankAccountRepository.save(bankAccount);
                return true;
            }
        }
        return false;
    }


    public boolean credit(Long accountId, double amount) {
        Optional<BankAccount> optionalBankAccount = bankAccountRepository.findById(accountId);
        if (optionalBankAccount.isPresent()) {
            BankAccount bankAccount = optionalBankAccount.get();
            double balance = bankAccount.getBalance();
            bankAccount.setBalance(balance + amount);
            return true;
        }
        return false;
    }
}

