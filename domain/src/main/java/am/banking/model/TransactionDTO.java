package am.banking.model;

import java.util.Optional;

public record TransactionDTO(String status, Optional<Long> currentBalance, Optional<String> errorMessage) {
}
