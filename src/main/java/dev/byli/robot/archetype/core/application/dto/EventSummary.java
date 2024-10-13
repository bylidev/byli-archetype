package dev.byli.robot.archetype.core.application.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Getter
@Builder
public class EventSummary {
    private UUID id;
    private String title;
    private LocalDate startDate;
    private LocalTime startTime;
    private LocalDate endDate;
    private LocalTime endTime;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
}
