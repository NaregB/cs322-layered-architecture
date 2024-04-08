package am.banking;

import am.banking.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends  CrudRepository<BankAccount, Long> {

    BankAccount findByAccountID(String accountID);
}