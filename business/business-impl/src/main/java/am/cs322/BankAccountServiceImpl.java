package am.cs322;

import am.cs322.model.BankAccount;
import am.cs322.model.BankAccountDTO;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class BankAccountServiceImpl implements BankService {

    private final BankAccountRepository bankAccountRepository;

    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }
    @Override
    public BankAccountDTO createBankAccount(double balance) {
        BankAccount account = bankAccountRepository.save(new BankAccount(balance));
        return new BankAccountDTO(account.getAccountID(), account.getBalance());
    }
    @Override
    public BankAccountDTO debit(Long accountID, double amount) {
        Optional<BankAccount> optionalAccount = bankAccountRepository.findById(accountID);

        if (optionalAccount.isPresent()) {
            BankAccount account = optionalAccount.get();

            if (account.getBalance() >= amount) {
                account.setBalance(account.getBalance() - amount);
                bankAccountRepository.save(account);
                return new BankAccountDTO(account.getAccountID(), account.getBalance());
            } else {
                throw new RuntimeException("Insufficient balance");
            }
        } else {
            throw new RuntimeException("Account not found");
        }
    }
    @Override
    public BankAccountDTO credit(Long accountID, double amount) {
        Optional<BankAccount> optionalBankAccount = bankAccountRepository.findById(accountID);
        if (optionalBankAccount.isPresent()) {
            BankAccount account = optionalBankAccount.get();
            account.setBalance(account.getBalance() + amount);
            bankAccountRepository.save(account);
            return new BankAccountDTO(account.getAccountID(), account.getBalance());
        } else {
            throw new RuntimeException("Account not found");
        }
    }
}