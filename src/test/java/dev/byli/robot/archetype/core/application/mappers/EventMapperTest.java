package dev.byli.robot.archetype.core.application.mappers;

import dev.byli.robot.archetype.core.domain.model.Event;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

@AllArgsConstructor
public class EventMapperTest {

    @Test
    public void testEventMapper() {
        //arrange
        var eventSummary = Event.builder().id(UUID.randomUUID()).title("title").startDate(ZonedDateTime.now())
                .endDate(ZonedDateTime.now()).maxPrice(BigDecimal.TEN)
                .minPrice(BigDecimal.TWO).build();
        //act
        var event = EventMapper.toDto(eventSummary);
        //assert
        Assertions.assertEquals(eventSummary.getId(), event.getId());
        Assertions.assertEquals(eventSummary.getTitle(), event.getTitle());
        Assertions.assertEquals(eventSummary.getStartDate().toLocalTime(), event.getStartTime());
        Assertions.assertEquals(eventSummary.getStartDate().toLocalDate(), event.getStartDate());
        Assertions.assertEquals(eventSummary.getEndDate().toLocalTime(), event.getEndTime());
        Assertions.assertEquals(eventSummary.getEndDate().toLocalDate(), event.getEndDate());
        Assertions.assertEquals(eventSummary.getMaxPrice(), event.getMaxPrice());
        Assertions.assertEquals(eventSummary.getMinPrice(), event.getMinPrice());

    }
}