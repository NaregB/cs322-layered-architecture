package am.banking.model;

import am.cs322.model.User;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity

@Table(name = "account")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "account_id")
    private String accountID;

    @Temporal(TemporalType.DATE)
    private Date openingDate;

    private Long balance;
    private Long debitLimit;
    private Long creditLimit;

    @ManyToOne
    @JoinColumn(name = "\"user_id\"")
    private User user;

    // Default constructor is implicitly available if no other constructors are defined

    public BankAccount(String bankName, String accountID, Date openingDate, Long balance, Long debitLimit, Long creditLimit, User user) {
        this.bankName = bankName;
        this.accountID = accountID;
        this.openingDate = openingDate;
        this.balance = balance;
        this.debitLimit = debitLimit;
        this.creditLimit = creditLimit;
        this.user = user;
    }

    public BankAccount() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount)) return false;
        BankAccount that = (BankAccount) o;
        return Objects.equals(bankName, that.bankName) &&
                Objects.equals(accountID, that.accountID) &&
                Objects.equals(openingDate, that.openingDate) &&
                Objects.equals(balance, that.balance) &&
                Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankName, accountID, openingDate, balance, user);
    }

    // Simplified getters
    public String getBankName() {
        return bankName;
    }

    public String getAccountID() {
        return accountID;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public Long getBalance() {
        return balance;
    }

    public Boolean isUserIdValid(Long userId) {
        return Objects.equals(user.getId(), userId);
    }

    public Boolean debit(Long amount) {
        if (amount <= debitLimit && balance + amount >= 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public Boolean credit(Long amount) {
        if (amount <= creditLimit && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
