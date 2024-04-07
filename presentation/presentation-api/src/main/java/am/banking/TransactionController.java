package am.banking;

import am.banking.model.TransactionDTO;
import am.banking.model.TransactionRequest;

public interface TransactionController {
    public TransactionDTO debit(TransactionRequest request);
    public TransactionDTO credit(TransactionRequest request);
}
