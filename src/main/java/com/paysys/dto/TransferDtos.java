package com.paysys.dto;

import com.paysys.account.Account;
import com.paysys.ledgerentry.LedgerEntry;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.*;
import lombok.*;

public class TransferDtos {
    @Getter @Setter @AllArgsConstructor @NoArgsConstructor
    public static class TransferRequest{
        @NotNull
        private Long fromAccountId;
        @NotNull
        private Long toAccountId;
        @NotNull
        @Positive
        private Long amount;
        @NotNull
        @Size(max=3)
        private String currency;
        @NotBlank
        @Size(max = 100)
        private String idempotencyKey;
    }
}
