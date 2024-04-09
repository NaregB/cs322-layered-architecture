package com.aua.bank.controller;

import com.aua.bank.model.BankAccountDTO;
import com.aua.bank.model.CreateBankAccountRequest;
import com.aua.bank.model.TransactionRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface BankAccountController {
    public BankAccountDTO createBankAccount(@RequestBody CreateBankAccountRequest request);

    public BankAccountDTO debitAccount(@PathVariable Long accountId, @RequestBody TransactionRequest request);

    public BankAccountDTO creditAccount(@PathVariable Long accountId, @RequestBody TransactionRequest request);
}
