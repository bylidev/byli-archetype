package com.feverup.challenge.core.application.usecases;

import com.feverup.challenge.core.application.dto.SearchRequest;
import com.feverup.challenge.core.domain.exception.ValidationException;
import com.feverup.challenge.core.application.ports.EventRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.ZonedDateTime;

@ExtendWith(MockitoExtension.class)
class SearchUseCaseTest {
    @InjectMocks
    private SearchUseCase searchUseCases;
    @Mock
    private EventRepository eventRepository;

    @Test
    @DisplayName("Should validate invalid dates")
    void test_1() {
        //arrange
        var arrange = SearchRequest.builder()
                .startsAt(ZonedDateTime.now().plusDays(1)).endsAt(ZonedDateTime.now()).build();
        //act
        Assertions.assertThrows(ValidationException.class, () -> searchUseCases.execute(arrange));

    }

    @Test
    @DisplayName("Should validate search")
    void test_2() {
        //arrange
        var arrange = SearchRequest.builder()
                .startsAt(ZonedDateTime.now()).endsAt(ZonedDateTime.now().plusDays(1)).build();
        //act
        searchUseCases.execute(arrange);
        //assert
        Mockito.verify(eventRepository, Mockito.times(1)).getEvents(arrange.getStartsAt(), arrange.getEndsAt());

    }
}