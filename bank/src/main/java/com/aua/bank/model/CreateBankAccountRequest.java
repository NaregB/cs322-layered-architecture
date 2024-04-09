package com.aua.bank.model;

import java.math.BigDecimal;

public record CreateBankAccountRequest(Long userId, BigDecimal initialBalance) {
}
