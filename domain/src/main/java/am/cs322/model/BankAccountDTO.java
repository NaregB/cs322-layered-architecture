package am.cs322.model;

import java.math.BigDecimal;

public record BankAccountDTO(Long id, String accountNumber, BigDecimal balance){
}
