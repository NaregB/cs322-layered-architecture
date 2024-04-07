package dev.danvega.account.io.am.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountOperationRequest {
    private Long accountId;
    private BigDecimal amount;
}
