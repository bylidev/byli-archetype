package com.feverup.challenge.core.application.usecases;

import com.feverup.challenge.core.application.ports.EventProvider;
import com.feverup.challenge.core.application.ports.EventRepository;
import com.feverup.challenge.core.domain.model.Event;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PullEventsUseCaseTest {
    @InjectMocks
    private PullEventsUseCase pullEventsUseCase;
    @Mock
    private EventProvider eventProvider;
    @Mock
    private EventRepository eventRepository;

    @Test
    @DisplayName("Test PullEventsUseCase should save them if they are new")
    void test_1() {
        //arrange
        when(eventProvider.getEvents()).thenReturn(List.of(Event.builder().id(UUID.randomUUID()).title("title").startDate(ZonedDateTime.now())
                .endDate(ZonedDateTime.now()).maxPrice(BigDecimal.TEN)
                .minPrice(BigDecimal.TWO).build()));
        when(eventRepository.exists(any(Event.class))).thenReturn(false);
        //act
        pullEventsUseCase.execute();
        //assert
        verify(eventRepository).exists(any(Event.class));
        verify(eventRepository).saveEvents(any());
    }


    @Test
    @DisplayName("Test PullEventsUseCase should not save them if they aren´t new")
    void test_2() {
        //arrange
        when(eventProvider.getEvents()).thenReturn(List.of(Event.builder().id(UUID.randomUUID()).title("title").startDate(ZonedDateTime.now())
                .endDate(ZonedDateTime.now()).maxPrice(BigDecimal.TEN)
                .minPrice(BigDecimal.TWO).build()));
        when(eventRepository.exists(any(Event.class))).thenReturn(true);
        //act
        pullEventsUseCase.execute();
        //assert
        verify(eventRepository).exists(any(Event.class));
        verify(eventRepository, never()).saveEvents(any());
    }

}