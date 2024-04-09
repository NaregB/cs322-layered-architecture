package transaction_service_architecture;

import transaction_service_architecture.model.AccountDTO;

public interface AccountService {
    AccountDTO createAccount(Long userId);
    AccountDTO credit(Double amount, Long toAccount);
    AccountDTO debit(Double amount, Long fromAccount);
}
