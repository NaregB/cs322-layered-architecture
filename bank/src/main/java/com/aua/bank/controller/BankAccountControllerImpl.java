package com.aua.bank.controller;

import com.aua.bank.model.BankAccountDTO;
import com.aua.bank.model.CreateBankAccountRequest;
import com.aua.bank.model.TransactionRequest;
import com.aua.bank.service.BankAccountService;
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

