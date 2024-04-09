package transaction_service_architecture;

import transaction_service_architecture.model.AccountDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public AccountDTO createAccount(@RequestParam Long userId) {
        return accountService.createAccount(userId);
    }

    @PostMapping("/credit")
    public AccountDTO credit(@RequestParam Double amount, @RequestParam Long accountTo) {
        return accountService.credit(amount, accountTo);
    }

    @PostMapping("/debit")
    public AccountDTO debit(@RequestParam Double amount, @RequestParam Long accountFrom) {
        return accountService.debit(amount, accountFrom);
    }
}
