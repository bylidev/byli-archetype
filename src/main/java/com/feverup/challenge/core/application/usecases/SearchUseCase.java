package com.feverup.challenge.core.application.usecases;

import com.feverup.challenge.core.application.dto.Data;
import com.feverup.challenge.core.application.dto.SearchRequest;
import com.feverup.challenge.core.application.dto.SearchResponse;
import com.feverup.challenge.core.domain.exception.ValidationException;
import com.feverup.challenge.core.application.mappers.EventMapper;
import com.feverup.challenge.core.application.ports.EventRepository;
import lombok.RequiredArgsConstructor;

import java.time.ZonedDateTime;

@RequiredArgsConstructor
public class SearchUseCase {
    private final EventRepository eventRepository;

    public SearchResponse execute(SearchRequest request) {
        validate(request.getStartsAt(), request.getEndsAt());
        return SearchResponse.builder().data(Data.builder().events(
                eventRepository.getEvents(request.getStartsAt(), request.getEndsAt()).stream()
                        .map(EventMapper::toDto).toList()).build()).build();
    }

    private void validate(ZonedDateTime start, ZonedDateTime end) {
        if (start.isAfter(end)) {
            throw new ValidationException("Start date must be before end date");
        }
    }
}
