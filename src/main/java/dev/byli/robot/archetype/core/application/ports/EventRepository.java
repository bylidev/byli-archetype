package dev.byli.robot.archetype.core.application.ports;

import dev.byli.robot.archetype.core.domain.model.Event;

import java.time.ZonedDateTime;
import java.util.List;

public interface EventRepository {
    List<Event> getEvents(ZonedDateTime startsAt, ZonedDateTime endsAt);

    Boolean exists(Event event);

    void saveEvents(List<Event> events);
}
