package com.feverup.challenge.infrastructure.springboot.configs;

import com.feverup.challenge.core.application.usecases.PullEventsUseCase;
import com.feverup.challenge.core.application.usecases.SearchUseCase;
import com.feverup.challenge.core.application.ports.EventProvider;
import com.feverup.challenge.core.application.ports.EventRepository;
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
