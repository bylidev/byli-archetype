package dev.byli.robot.archetype.core.application.mappers;

import dev.byli.robot.archetype.core.application.dto.EventSummary;
import dev.byli.robot.archetype.core.domain.model.Event;

public class EventMapper {

    public static EventSummary toDto(Event event) {
        return EventSummary.builder()
                .id(event.getId())
                .title(event.getTitle())
                .startTime(event.getStartDate().toLocalTime())
                .startDate(event.getStartDate().toLocalDate())
                .endTime(event.getEndDate().toLocalTime())
                .endDate(event.getEndDate().toLocalDate())
                .maxPrice(event.getMaxPrice())
                .minPrice(event.getMinPrice())
                .build();
    }
}
