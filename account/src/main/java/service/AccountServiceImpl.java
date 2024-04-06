package service;

import dto.AccountDto;
import dto.AccountEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AccountRepository;

import java.math.BigDecimal;
import java.util.List;

/**
 *  @author: Tigran Movsesyan
 */

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;


    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    @Override
    public void debit (String accountId, BigDecimal amount) {
        AccountEntity account = accountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));
        BigDecimal currentBalance = account.getBalance();

        if (validateCurrentFunds(currentBalance,amount)) {
            currentBalance = currentBalance.subtract(amount);
        }
        account.setBalance(currentBalance);
        accountRepository.save(account);
    }

    @Transactional
    @Override
    public void credit(String accountId, BigDecimal amount) {
        AccountEntity account = accountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));
        BigDecimal currentBalance = account.getBalance();

        currentBalance = currentBalance.add(amount);
        account.setBalance(currentBalance);
        accountRepository.save(account);
    }


    public AccountDto createAccount() {
        AccountEntity account = new AccountEntity();
        account.setBalance(BigDecimal.ZERO);
        accountRepository.save(account);

        AccountDto accountDto = new AccountDto();
        accountDto.setId(accountDto.getId());

        return accountDto;
    }


    public List<AccountEntity> getAllAccounts() {
        return (List<AccountEntity>) accountRepository.findAll();
    }


    public boolean validateCurrentFunds(BigDecimal currentBalance,BigDecimal amount){
        boolean balanceIsValid;
        balanceIsValid = currentBalance.compareTo(BigDecimal.ZERO) >= 0 && currentBalance.compareTo(amount) >= 0;
        return balanceIsValid;
    }
}
