package com.feverup.challenge.infrastructure.springboot.ports.repository.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EventEntity {
    @Id
    private UUID id;
    private Long providerEventId;
    private String title;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    @PreUpdate
    public void preUpdate() {
        updatedAt = ZonedDateTime.now();
    }

    @PrePersist
    public void prePersist() {
        createdAt = ZonedDateTime.now();
        updatedAt = ZonedDateTime.now();
    }
}
