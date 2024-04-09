package sia;

import sia.model.AccountDTO;

public interface AccountService {

    AccountDTO createAccount(Long userId);

    AccountDTO credit(Double amount, Long toAccount);

    AccountDTO debit(Double amount, Long fromAccount);
}
