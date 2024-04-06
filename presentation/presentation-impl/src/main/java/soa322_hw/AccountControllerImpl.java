package soa322_hw;

import soa322_hw.model_account.AccountDTO;
import soa322_hw.model.AddRemoveMoneyRequest;
import soa322_hw.model.CreateAccountRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/accounts")
public class AccountControllerImpl implements AccountController {
    private final AccountService accountService;

    public AccountControllerImpl(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create")
    public AccountDTO createAccount(@RequestBody CreateAccountRequest request) {
        AccountDTO accountDTO = accountService.createAccount(
                request.id(),
                request.accountNumber(),
                request.initialDeposit()
        );
        return ResponseEntity.ok(accountDTO).getBody();
    }

    @PostMapping("/{accountId}/debit")
    public AccountDTO debit(@RequestBody AddRemoveMoneyRequest request) {
        AccountDTO accountDTO = accountService.debit(request.accountId(), request.amount());
        return ResponseEntity.ok(accountDTO).getBody();
    }

    @PostMapping("/{accountId}/credit")
    public AccountDTO credit(@RequestBody AddRemoveMoneyRequest request) {
        AccountDTO accountDTO = accountService.credit(request.accountId(), request.amount());
        return ResponseEntity.ok(accountDTO).getBody();
    }
}
