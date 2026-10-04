package com.paysys.ledgerentry;
import com.paysys.account.Account;
import com.paysys.transaction.Transaction;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Getter @NoArgsConstructor @AllArgsConstructor
@Table(name = "ledger_entries")
public class LedgerEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "transaction_id", referencedColumnName = "id")
    private Transaction transaction;
    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;
    @Enumerated(EnumType.STRING) @Column(nullable = false)
    private Direction direction;
    @Positive
    @Column(nullable = false)
    private String currency;
    @CreationTimestamp
    @Column(nullable = false,updatable = false)
    private Instant createdAt;

}
