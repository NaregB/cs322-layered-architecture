package am.cs322.model;

import java.math.BigDecimal;

public record CreateBankAccountRequest(Long userId, BigDecimal initialBalance) {
}
