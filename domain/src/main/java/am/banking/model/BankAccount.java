package am.banking.model;

import am.cs322.model.User;
import jakarta.persistence.*;


import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "\"account\"", uniqueConstraints = @UniqueConstraint(columnNames = {"\"bank_name\"", "\"account_number\""}))
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "\"bank_name\"")
    private String bankName;


    @Column(name = "\"account_number\"")
    private String accountNumber;

    @Temporal(TemporalType.DATE)
    private Date openingDate;

    private Long balance;

    private Long debitLimit;

    private Long creditLimit;

    @ManyToOne
    @JoinColumn(name="\"user_id\"")
    private User user;

    public BankAccount(String bankName, String accountNumber, Date openingDate, Long balance, Long debitLimit, Long creditLimit, User user) {
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.openingDate = openingDate;
        this.balance = balance;
        this.debitLimit = debitLimit;
        this.creditLimit = creditLimit;
        this.user = user;
    }

    public BankAccount() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount account = (BankAccount) o;
        return Objects.equals(bankName, account.bankName) &&
               Objects.equals(accountNumber, account.accountNumber) &&
               Objects.equals(openingDate, account.openingDate) &&
               Objects.equals(balance, account.balance) &&
               user.equals(account.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankName, accountNumber, openingDate, balance, user);
    }

    public String getBankName() { return bankName; }

    public String getAccountNumber() { return accountNumber; }

    public Date getOpeningDate() { return openingDate; }

    public Long getBalance() { return balance; }

    public Boolean isUserIdValid(Long userId) {
        return Objects.equals(user.getId(), userId);
    }
    public Boolean debit(Long amount) {
        if (amount > debitLimit) {
            return false;
        }
        this.balance += amount;
        return true;
    }

    public Boolean credit(Long amount) {
        if (amount > creditLimit || amount > this.balance) {
            return false;
        }
        this.balance -= amount;
        return true;
    }
}
