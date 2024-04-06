package controller;

import dto.AccountDto;
import dto.AccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.AccountServiceImpl;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/v1/accounts")
public class AccountController {

    private final AccountServiceImpl accountService;

    @Autowired
    public AccountController(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/")
    public ResponseEntity<List<AccountEntity>> getAllAccounts() {
        List<AccountEntity> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    @PostMapping("/create")
    public ResponseEntity<AccountDto> createAccount() {
        AccountDto newAccount = accountService.createAccount();
        return ResponseEntity.ok(newAccount);
    }

    @PostMapping("/{accountId}/debit")
    public ResponseEntity<?> debitAccount(@PathVariable String accountId, @RequestParam BigDecimal amount) {
        accountService.debit(accountId, amount);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{accountId}/credit")
    public ResponseEntity<?> creditAccount(@PathVariable String accountId, @RequestParam BigDecimal amount) {
        accountService.credit(accountId, amount);
        return ResponseEntity.ok().build();
    }
}
