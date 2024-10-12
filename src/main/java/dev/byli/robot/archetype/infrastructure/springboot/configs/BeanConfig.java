package dev.byli.robot.archetype.infrastructure.springboot.configs;

import dev.byli.robot.archetype.core.application.ports.EventProvider;
import dev.byli.robot.archetype.core.application.ports.EventRepository;
import dev.byli.robot.archetype.core.application.usecases.PullEventsUseCase;
import dev.byli.robot.archetype.core.application.usecases.SearchUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public PullEventsUseCase pullEventsUseCase(EventProvider eventProvider, EventRepository eventRepository) {
        return new PullEventsUseCase(eventProvider, eventRepository);
    }

    @Bean
    public SearchUseCase searchUseCase(EventRepository eventRepository) {
        return new SearchUseCase(eventRepository);
    }
}
