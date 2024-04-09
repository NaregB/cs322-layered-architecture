package acc;

import acc.Account;
import acc.AccountDTO;
import acc.AccountRepository;
import acc.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDTO createAccount(Long userId) {
        Account createdAcc = accountRepository.save(new Account(userId));
        return new AccountDTO(createdAcc.getUserId() + " " + createdAcc.getBalance());
    }

    @Override
    public AccountDTO creditAccount(Long accountId, Double amount) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));
        double newBalance = account.getBalance() + amount;
        account.setBalance(newBalance);
        Account updatedAccount = accountRepository.save(account);
        return new AccountDTO(updatedAccount.getId() + " " +  updatedAccount.getBalance());
    }

    @Override
    public AccountDTO debitAccount(Long accountId, Double amount) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));
        if (account.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        double newBalance = account.getBalance() - amount;
        account.setBalance(newBalance);
        Account updatedAccount = accountRepository.save(account);
        return new AccountDTO(updatedAccount.getId() + " " + updatedAccount.getBalance());
    }
}
