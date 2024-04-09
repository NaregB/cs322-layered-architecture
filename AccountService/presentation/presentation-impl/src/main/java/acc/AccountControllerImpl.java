package acc;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/account")
public class AccountControllerImpl implements AccountController {

    private final AccountService accountService;

    public AccountControllerImpl(AccountService userService) {
        this.accountService = userService;
    }

    @Override
    public AccountDTO createAccount(@RequestParam Long userId) {
        return accountService.createAccount(userId);
    }

    @Override
    @PostMapping("/debit")
    public AccountDTO debitAccount(@RequestParam Long userId, @RequestParam Double balance) {
        return accountService.debitAccount(userId, balance);
    }

    @Override
    @PostMapping("/credit")
    public AccountDTO creditAccount(@RequestParam Long userId, @RequestParam Double balance) {
        return accountService.creditAccount(userId, balance);

    }
}