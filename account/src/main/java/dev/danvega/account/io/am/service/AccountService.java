package dev.danvega.account.io.am.service;


import java.math.BigDecimal;

public interface AccountService {

    void debit (Long accountId,BigDecimal amount);
    void credit (Long accountId,BigDecimal amount);




}
