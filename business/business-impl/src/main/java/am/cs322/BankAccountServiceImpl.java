package am.cs322;

//import am.cs322.domain.BankAccount;

import am.cs322.model.BankAccount;
import am.cs322.model.BankAccountDTO;
import am.cs322.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Random;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public BankAccountDTO debit(Long accountId, BigDecimal amount) {
        BankAccount account = bankAccountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));
        account.debit(amount);
        BankAccount bankAccount = bankAccountRepository.save(account);
        return new BankAccountDTO(bankAccount.getId(), bankAccount.getAccountNumber(), bankAccount.getBalance());
    }

    @Transactional
    public BankAccountDTO credit(Long accountId, BigDecimal amount) {
        BankAccount account = bankAccountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));
        account.credit(amount);
        BankAccount bankAccount = bankAccountRepository.save(account);
        return new BankAccountDTO(bankAccount.getId(), bankAccount.getAccountNumber(), bankAccount.getBalance());
    }

    @Override
    public BankAccountDTO createBankAccount(Long userId, BigDecimal initialBalance) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountNumber(generateAccountNumber());
        bankAccount.setBalance(initialBalance);

        Optional<User> user = userRepository.findById(userId);

        if (!user.isPresent()) {
            throw new IllegalArgumentException("User not found!");
        }

        bankAccount.setUser(user.get());
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);

        return new BankAccountDTO(savedBankAccount.getId(), savedBankAccount.getAccountNumber(), savedBankAccount.getBalance());
    }

    private String generateAccountNumber() {
        Random random = new Random();
        StringBuilder accountNumber = new StringBuilder();

        for (int i = 0; i < 16; i++) {
            int digit = random.nextInt(10);
            accountNumber.append(digit);
        }

        return accountNumber.toString();
    }
}
