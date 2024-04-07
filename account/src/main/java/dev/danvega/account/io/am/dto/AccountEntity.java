package dev.danvega.account.io.am.dto;



import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
@Entity
@Table(name = "account")
@Data
public class AccountEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "balance", precision = 15, scale = 2, columnDefinition = "DECIMAL(15,2) DEFAULT 0.00")
    private BigDecimal balance;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountEntity account = (AccountEntity) o;
        return Objects.equals(balance, account.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance);
    }


}


