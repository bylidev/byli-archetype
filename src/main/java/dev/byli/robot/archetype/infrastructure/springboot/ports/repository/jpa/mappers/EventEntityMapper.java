package dev.byli.robot.archetype.infrastructure.springboot.ports.repository.jpa.mappers;

import dev.byli.robot.archetype.core.domain.model.Event;
import dev.byli.robot.archetype.infrastructure.springboot.ports.repository.jpa.entity.EventEntity;

import java.time.ZonedDateTime;
import java.util.UUID;

public class EventEntityMapper {
    public static EventEntity toEntity(Event event) {
        return EventEntity.builder()
                .id(UUID.randomUUID())
                .providerEventId(event.getProviderEventId())
                .title(event.getTitle())
                .startDate(event.getStartDate())
                .endDate(event.getEndDate())
                .minPrice(event.getMinPrice())
                .maxPrice(event.getMaxPrice())
                .createdAt(ZonedDateTime.now())
                .updatedAt(ZonedDateTime.now())
                .build();
    }

    public static Event toDomain(EventEntity eventEntity) {
        return Event.builder()
                .id(eventEntity.getId())
                .providerEventId(eventEntity.getProviderEventId())
                .title(eventEntity.getTitle())
                .startDate(eventEntity.getStartDate())
                .endDate(eventEntity.getEndDate())
                .minPrice(eventEntity.getMinPrice())
                .maxPrice(eventEntity.getMaxPrice())
                .createdAt(eventEntity.getCreatedAt())
                .updatedAt(eventEntity.getUpdatedAt())
                .build();
    }
}
