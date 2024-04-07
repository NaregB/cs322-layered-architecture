package dev.danvega.account.io.am.controller;

import dev.danvega.account.io.am.dto.AccountDto;
import dev.danvega.account.io.am.dto.AccountEntity;
import dev.danvega.account.io.am.dto.AccountOperationRequest;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import dev.danvega.account.io.am.service.AccountServiceImpl;

import java.math.BigDecimal;
import java.util.List;

import static org.slf4j.Logger.*;

@RestController
@RequestMapping("/v1/accounts")
@Slf4j
public class AccountController {

    private final AccountServiceImpl accountService;

    private  Logger logger;
    @Autowired
    public AccountController(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<List<AccountEntity>> getAllAccounts() {
        List<AccountEntity> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    @PostMapping("/create")
    public ResponseEntity<AccountDto> createAccount() {
        AccountDto newAccount = accountService.createAccount();
        return ResponseEntity.ok(newAccount);
    }

    @PostMapping("/debit")
    public ResponseEntity<?> debitAccount(@RequestBody AccountOperationRequest request) {
        accountService.debit(request.getAccountId(), request.getAmount());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/credit")
    public ResponseEntity<?> creditAccount(@RequestBody AccountOperationRequest request) {
        accountService.credit(request.getAccountId(), request.getAmount());
        return ResponseEntity.ok().build();
    }
}
