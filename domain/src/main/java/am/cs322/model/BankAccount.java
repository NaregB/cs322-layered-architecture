package am.cs322.model;

import jakarta.persistence.*;
import java.util.Objects;
@Entity
@Table(name = "\"account\"")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountID;

    private double balance;

    public BankAccount(double balance) {

        this.balance = balance;
    }

    public BankAccount() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount bankAccount = (BankAccount) o;
        return Objects.equals(accountID, bankAccount.accountID) && Objects.equals(balance, bankAccount.balance);
    }
    public Long getAccountID() {
        return accountID;
    }
    public double getBalance() {
        return balance;
    }
    public void setAccountID(Long accountID) {
        this.accountID = accountID;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    @Override
    public int hashCode() {
        return Objects.hash(accountID, balance);
    }

}
