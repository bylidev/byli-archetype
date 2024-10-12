package dev.byli.robot.archetype.core.application.ports;

import dev.byli.robot.archetype.core.domain.model.Event;

import java.util.List;

public interface EventProvider {
    List<Event> getEvents();
}
