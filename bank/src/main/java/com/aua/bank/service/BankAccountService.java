package com.aua.bank.service;

import com.aua.bank.model.BankAccountDTO;

import java.math.BigDecimal;

public interface BankAccountService {
    public BankAccountDTO debit(Long accountId, BigDecimal amount);

    public BankAccountDTO credit(Long accountId, BigDecimal amount);

    BankAccountDTO createBankAccount(Long userId, BigDecimal initialBalance);
}
