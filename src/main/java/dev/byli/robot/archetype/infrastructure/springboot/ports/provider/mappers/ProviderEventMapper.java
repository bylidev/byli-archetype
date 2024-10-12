package dev.byli.robot.archetype.infrastructure.springboot.ports.provider.mappers;

import dev.byli.robot.archetype.core.domain.model.Event;
import dev.byli.robot.archetype.infrastructure.springboot.ports.provider.dto.BaseEvent;
import dev.byli.robot.archetype.infrastructure.springboot.ports.provider.dto.EventList;
import dev.byli.robot.archetype.infrastructure.springboot.ports.provider.dto.Zone;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;

@Slf4j
public class ProviderEventMapper {

    public static List<Event> toDomain(EventList eventList) {
        var output = eventList.getOutput();
        if (output != null) {
            return output.getBaseEvents().stream()
                    .map(ProviderEventMapper::toDomain)
                    .toList();
        }
        return List.of();
    }

    public static Event toDomain(BaseEvent baseEvent) {
        var event = baseEvent.getEvent();
        var zones = event.getZones();
        return Event.builder()
                .providerEventId(baseEvent.getBaseEventId())
                .title(baseEvent.getTitle())
                .startDate(parseDateTime(event.getEventStartDate()))
                .endDate(parseDateTime(event.getEventEndDate()))
                .maxPrice(getMaxPrice(zones))
                .minPrice(getMinPrice(zones))
                .build();
    }

    private static BigDecimal getMaxPrice(List<Zone> zones) {
        return zones.stream()
                .map(z -> new BigDecimal(z.getPrice()))
                .max(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);
    }

    private static BigDecimal getMinPrice(List<Zone> zones) {
        return zones.stream()
                .map(z -> new BigDecimal(z.getPrice()))
                .min(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);
    }

    private static ZonedDateTime parseDateTime(String dateTimeStr) {
        ZonedDateTime zonedDateTime;

        try {
            zonedDateTime = ZonedDateTime.parse(dateTimeStr);
        } catch (DateTimeParseException e) {
            log.warn("Invalid date: " + e.getMessage());
            String[] parts = dateTimeStr.split("T");
            String datePart = parts[0];
            String timePart = parts[1];
            String[] dateComponents = datePart.split("-");
            int year = Integer.parseInt(dateComponents[0]);
            int month = Integer.parseInt(dateComponents[1]);
            LocalDate date = LocalDate.of(year, month, 1).withDayOfMonth(LocalDate.of(year, month, 1).lengthOfMonth());
            LocalDateTime tempDateTime = LocalDateTime.parse(date + "T" + timePart);
            zonedDateTime = tempDateTime.atZone(java.time.ZoneId.systemDefault());
        }
        return zonedDateTime;
    }

}
