package dev.byli.robot.archetype.infrastructure.springboot.ports;

import dev.byli.robot.archetype.infrastructure.springboot.ports.provider.EventProviderImpl;
import dev.byli.robot.archetype.infrastructure.springboot.ports.provider.dto.BaseEvent;
import dev.byli.robot.archetype.infrastructure.springboot.ports.provider.dto.EventList;
import dev.byli.robot.archetype.infrastructure.springboot.ports.provider.dto.Output;
import dev.byli.robot.archetype.infrastructure.springboot.ports.provider.dto.ProviderEvent;
import dev.byli.robot.archetype.infrastructure.springboot.ports.provider.dto.Zone;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class EventProviderImplTest {
    @Autowired
    private EventProviderImpl eventProvider;

    @Test
    void getEvents() throws Exception {
        var test = new EventList();
        var output = new Output();
        var baseEvent = new BaseEvent();
        baseEvent.setBaseEventId(1L);
        baseEvent.setSellMode("sellMode");
        baseEvent.setOrganizerCompanyId(1L);
        var provider = new ProviderEvent();
        Zone zone = new Zone();
        zone.setZoneId(1L);
        provider.setZones(List.of(zone));
        baseEvent.setEvent(provider);
        baseEvent.setTitle("title");
        output.setBaseEvents(List.of(baseEvent));
        test.setOutput(output);
        var events = eventProvider.getEvents();
        //new MappingJackson2XmlHttpMessageConverter().getObjectMapper().writeValueAsString(test);
    }


}