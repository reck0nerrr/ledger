package com.paysys.account;

import com.paysys.ledgerentry.Direction;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Getter @NoArgsConstructor @AllArgsConstructor
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String ownerType;
    @Column(nullable = false, unique = true)
    private Long ownerId;
    @Column(nullable = false, unique = true)
    private String purpose;
    @Enumerated(EnumType.STRING)
    @Column(name = "normal_balance", nullable = false)
    private Direction normalBalance;
    @Column
    private String currency;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Instant createdAt;
    @Column(nullable = false)
    private Instant expiresAt;
}
