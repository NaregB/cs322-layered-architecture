package am.banking.model;

import jakarta.annotation.Nonnull;

public record TransactionRequest(@Nonnull
                                 Long userId,
                                 @Nonnull
                                 Long accountId,
                                 @Nonnull
                                 Long amount) {}
