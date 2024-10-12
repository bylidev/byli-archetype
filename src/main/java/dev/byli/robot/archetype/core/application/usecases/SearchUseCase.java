package dev.byli.robot.archetype.core.application.usecases;

import dev.byli.robot.archetype.core.application.dto.Data;
import dev.byli.robot.archetype.core.application.dto.SearchRequest;
import dev.byli.robot.archetype.core.application.dto.SearchResponse;
import dev.byli.robot.archetype.core.application.mappers.EventMapper;
import dev.byli.robot.archetype.core.application.ports.EventRepository;
import dev.byli.robot.archetype.core.domain.exception.ValidationException;
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
