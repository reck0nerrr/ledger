package com.paysys.idempotencykey;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import tools.jackson.databind.JsonNode;

import java.time.Instant;

@Entity
@Getter @NoArgsConstructor @AllArgsConstructor
@Table(name = "idempotency_keys")
public class IdempotencyKey {
    @Id
    @Column
    private String key;
    @Column(nullable = false)
    private String requestHash;
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private JsonNode responseBody;
    @CreationTimestamp
    @Column(updatable = false)
    private Instant createdAt;

}
