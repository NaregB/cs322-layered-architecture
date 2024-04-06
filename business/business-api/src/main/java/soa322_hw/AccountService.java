package soa322_hw;

import soa322_hw.model_account.AccountDTO;

public interface AccountService {
    AccountDTO debit(Long accountId, double amount);
    AccountDTO credit(Long accountId, double amount);
    AccountDTO createAccount(long id, String accountNumber, Double initialDeposit);
}
