package am.cs322;

import am.cs322.model.BankAccountDTO;
import am.cs322.model.CreateBankAccountRequest;
import am.cs322.model.TransactionRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface BankAccountController {
    public BankAccountDTO createBankAccount(@RequestBody CreateBankAccountRequest request);

    public BankAccountDTO debitAccount(@PathVariable Long accountId, @RequestBody TransactionRequest request);

    public BankAccountDTO creditAccount(@PathVariable Long accountId, @RequestBody TransactionRequest request);
}
