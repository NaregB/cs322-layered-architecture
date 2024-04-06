package soa322_hw;

import soa322_hw.model_account.Account;
import soa322_hw.model_account.AccountDTO;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDTO debit(Long accountId, double amount) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));

        if (account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
        } else {
            throw new IllegalArgumentException("Insufficient funds");
        }
        accountRepository.save(account);
        return new AccountDTO(account.getId(),account.getAccountNumber(),account.getBalance());
    }

    @Override
    public AccountDTO credit(Long accountId, double amount) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));

        account.setBalance(account.getBalance() + amount);

        accountRepository.save(account);
        return new AccountDTO(account.getId(),account.getAccountNumber(),account.getBalance());
    }

    @Override
    public AccountDTO createAccount(long id, String accountNumber, Double initialDeposit) {
        Account newAccount = new Account();
        newAccount.setAccountNumber(accountNumber);
        newAccount.setBalance(initialDeposit);

        Account savedAccount = accountRepository.save(newAccount);

        return new AccountDTO(savedAccount.getId(), savedAccount.getAccountNumber(), savedAccount.getBalance());
    }
}
