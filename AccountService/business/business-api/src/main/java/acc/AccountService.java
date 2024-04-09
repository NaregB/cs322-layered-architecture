package acc;

import acc.AccountDTO;

public interface AccountService {
    public AccountDTO createAccount(Long userId);
    public AccountDTO creditAccount(Long accountId, Double amount);
    public AccountDTO debitAccount(Long accountId, Double amount);
}