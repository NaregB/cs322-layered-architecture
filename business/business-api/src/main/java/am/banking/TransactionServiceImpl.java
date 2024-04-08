package am.banking;

import am.banking.model.BankAccount;
import am.banking.model.TransactionDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final BankAccountRepository bankAccountRepository;

    public TransactionServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public TransactionDTO debit(Long userID, Long accountId, Long amount) {
      BankAccount account = bankAccountRepository.findByAccountID(accountId+"");
        if (account==null) {
            return new TransactionDTO("Failure", Optional.empty(), Optional.of("Account Not Found!"));
        }

        if (!account.debit(amount)) {
            return new TransactionDTO("Failure", Optional.of(account.getBalance()), Optional.of("The requested amount exceeds the debit limit!"));
        }
        bankAccountRepository.save(account);
       return new TransactionDTO("Successful", Optional.of(account.getBalance()), Optional.empty());
    }

    @Override
    public TransactionDTO credit(Long userID, Long accountId, Long amount) {
        BankAccount account = bankAccountRepository.findByAccountID(accountId+"");
        if (account == null) {
            return new TransactionDTO("Failure", Optional.empty(), Optional.of("Account Not Found!"));
        }

        if (!account.credit(amount)) {
            if (amount > account.getBalance()) {
                return new TransactionDTO("Failure", Optional.of(account.getBalance()), Optional.of("Not enough balance on the account!"));
            }
            return new TransactionDTO("Failure", Optional.of(account.getBalance()), Optional.of("The requested amount exceeds the credit limit!"));
        }
        bankAccountRepository.save(account);
        return new TransactionDTO("Successful", Optional.of(account.getBalance()), Optional.empty());
    }

}