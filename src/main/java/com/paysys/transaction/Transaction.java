package com.paysys.transaction;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import lombok.*;
@Entity
@Getter @NoArgsConstructor @AllArgsConstructor
@Table(name = "transactions")
public class Transaction {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;
    @Enumerated(EnumType.STRING) @Column(nullable = false)
    private TransactionStatus status;
    @Column(name = "idempotency_key", unique = true)
    private String idempotencyKey;

    public void setStatusPending(){
        this.status = TransactionStatus.PENDING;
    }
    public void setStatusReversed(){
        this.status=TransactionStatus.REVERSED;
    }
    public void setStatusPosted(){
        this.status = TransactionStatus.POSTED;
    }
    public void setStatusFailed(){
        this.status = TransactionStatus.FAILED;
    }
}
