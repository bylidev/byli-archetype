package dev.byli.robot.archetype.infrastructure.springboot.ports.provider;

import dev.byli.robot.archetype.core.application.ports.EventProvider;
import dev.byli.robot.archetype.core.domain.model.Event;
import dev.byli.robot.archetype.infrastructure.springboot.ports.provider.dto.EventList;
import dev.byli.robot.archetype.infrastructure.springboot.ports.provider.mappers.ProviderEventMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@AllArgsConstructor
public class EventProviderImpl implements EventProvider {
    public final String EVENT_PROVIDER_URL = "https://provider.code-challenge.feverup.com/api/events";
    private final RestTemplate restTemplate;

    @Override
    public List<Event> getEvents() {
        var eventList = restTemplate.getForObject(EVENT_PROVIDER_URL, EventList.class);
        assert eventList != null;
        return ProviderEventMapper.toDomain(eventList);
    }
}
