package am.banking;

import am.banking.model.TransactionDTO;

public interface TransactionService {
    public TransactionDTO debit(Long userID, Long accountId, Long amount);
    public TransactionDTO credit(Long userID, Long accountId, Long amount);
}
