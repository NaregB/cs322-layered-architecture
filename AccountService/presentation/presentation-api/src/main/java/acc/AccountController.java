package acc;

public interface AccountController {
    public AccountDTO createAccount(Long userId);
    public AccountDTO debitAccount(Long userId, Double balance);
    public AccountDTO creditAccount(Long userId, Double balance);
}
