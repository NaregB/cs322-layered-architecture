package am.banking;

import am.banking.model.TransactionDTO;
import am.banking.model.TransactionRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/account")
public class TransactionControllerImpl implements TransactionController {
    private final TransactionService transactionService;

    public TransactionControllerImpl(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Override
    @PostMapping("/debit")
    public TransactionDTO debit(@RequestBody TransactionRequest request) {
        return transactionService.debit(request.userId(), request.accountId(), request.amount());
    }

    @Override
    @PostMapping("/credit")
    public TransactionDTO credit(@RequestBody TransactionRequest request) {
        return transactionService.credit(request.userId(), request.accountId(), request.amount());
    }
}
