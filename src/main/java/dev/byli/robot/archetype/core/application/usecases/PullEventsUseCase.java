package dev.byli.robot.archetype.core.application.usecases;

import dev.byli.robot.archetype.core.application.ports.EventProvider;
import dev.byli.robot.archetype.core.application.ports.EventRepository;
import dev.byli.robot.archetype.core.domain.model.Event;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PullEventsUseCase {
    private final EventProvider eventProvider;
    private final EventRepository eventRepository;

    public final void execute() {
        var events = this.eventProvider.getEvents();
        var newEvents = getNewEvents(events);
        if (!newEvents.isEmpty()) {
            this.eventRepository.saveEvents(newEvents);
        }
    }

    private List<Event> getNewEvents(List<Event> eventList) {
        return eventList.stream()
                .filter(event -> !this.eventRepository.exists(event))
                .toList();
    }
}
