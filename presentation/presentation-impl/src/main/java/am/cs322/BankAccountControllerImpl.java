package am.cs322;

import am.cs322.model.BankAccountDTO;
import am.cs322.model.CreateBankAccountRequest;
import am.cs322.model.TransactionRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/bankaccounts")
public class BankAccountControllerImpl implements BankAccountController {

    private BankAccountService bankAccountService;

    public BankAccountControllerImpl(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @PostMapping
    public BankAccountDTO createBankAccount(@RequestBody CreateBankAccountRequest request) {
        return bankAccountService.createBankAccount(request.userId(), request.initialBalance());
    }

    @PostMapping("/{accountId}/debit")
    public BankAccountDTO debitAccount(@PathVariable Long accountId, @RequestBody TransactionRequest request) {
        return bankAccountService.debit(accountId, request.amount());
    }

    @PostMapping("/{accountId}/credit")
    public BankAccountDTO creditAccount(@PathVariable Long accountId, @RequestBody TransactionRequest request) {
        return bankAccountService.credit(accountId, request.amount());
    }
}

