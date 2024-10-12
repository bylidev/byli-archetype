package dev.byli.robot.archetype.core.domain.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@Builder
public class Event {
    private UUID id;
    private Long providerEventId;
    private String title;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
}
