package transaction_service_architecture;

import org.springframework.stereotype.Service;
import transaction_service_architecture.model.Account;
import transaction_service_architecture.model.AccountDTO;

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
    public AccountDTO credit(Double amount, Long toAccount) {
        Account account = accountRepository.findById(toAccount)
            .orElseThrow(() -> new RuntimeException("Account not found"));
        Double balance = account.getBalance();
        account.setBalance(balance + amount);
        accountRepository.save(account);
        return new AccountDTO(account.getUserId() + " balance: " + account.getBalance());
    }

    @Override
    public AccountDTO debit(Double amount, Long fromAccount) {
        Account account = accountRepository.findById(fromAccount)
            .orElseThrow(() -> new RuntimeException("Account not found"));

        if (account.getBalance() == 0) {
            throw new RuntimeException("Balance is zero, cannot debit");
        }

        if (amount > account.getBalance()) {
            throw new RuntimeException("Debit amount exceeds current balance");
        }

        Double balance = account.getBalance();
        account.setBalance(balance - amount);
        accountRepository.save(account);
        return new AccountDTO(account.getUserId() + " balance: " + account.getBalance());
    }
}
