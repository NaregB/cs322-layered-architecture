package acc;

import jakarta.persistence.*;

@Entity
@Table(name = "\"accounts\"")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double balance;

    private Long userId;

    // Constructors, getters, and setters

    public Account() {
        // Default constructor
    }

    public Account(Long id, Double balance) {
        this.id = id;
        this.balance = balance;
    }

    public Account(Long userId) {
        this.userId = userId;
        this.balance = 0.0;
    }

    public Long getUserId() {
        return userId;
    }
    // Standard getters and setters for id and balance

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    // Additional methods, like deposit and withdraw, could be implemented here as well
}
