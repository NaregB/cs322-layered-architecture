package com.aua.bank.model;

import java.math.BigDecimal;

public record TransactionRequest(BigDecimal amount) {
}
