package soa322_hw;

import soa322_hw.model_account.AccountDTO;
import soa322_hw.model.AddRemoveMoneyRequest;
import soa322_hw.model.CreateAccountRequest;

public interface AccountController {

    AccountDTO createAccount(CreateAccountRequest request);

    AccountDTO debit(AddRemoveMoneyRequest request);

    AccountDTO credit(AddRemoveMoneyRequest request);
}
