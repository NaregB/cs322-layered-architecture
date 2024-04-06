package service;


import java.math.BigDecimal;

public interface AccountService {

    void debit (String accountId,BigDecimal amount);
    void credit (String accountId,BigDecimal amount);




}
