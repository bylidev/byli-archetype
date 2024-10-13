package dev.byli.robot.archetype.infrastructure.springboot.ports.repository;

import dev.byli.robot.archetype.core.application.ports.EventRepository;
import dev.byli.robot.archetype.core.domain.model.Event;
import dev.byli.robot.archetype.infrastructure.springboot.ports.repository.jpa.JpaEventRepository;
import dev.byli.robot.archetype.infrastructure.springboot.ports.repository.jpa.mappers.EventEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

import static dev.byli.robot.archetype.infrastructure.springboot.configs.CacheConfig.EVENTS_CACHE;
import static dev.byli.robot.archetype.infrastructure.springboot.configs.CacheConfig.EXIST_EVENT_CACHE;

@Component
@RequiredArgsConstructor
public class EventRepositoryImpl implements EventRepository {
    private final JpaEventRepository jpaEventRepository;
    private final CacheManager cacheManager;

    @Override
    public List<Event> getEvents(ZonedDateTime startsAt, ZonedDateTime endsAt) {
        return jpaEventRepository.findByStartDateAfterAndEndDateBefore(startsAt, endsAt).stream()
                .map(EventEntityMapper::toDomain).toList();
    }

    @Override
    public Boolean exists(Event event) {
        var exists = Objects.requireNonNull(cacheManager.getCache(EXIST_EVENT_CACHE)).get(event.getProviderEventId(), Boolean.class);
        return Objects.requireNonNullElseGet(exists, () -> jpaEventRepository.existsByProviderEventId(event.getProviderEventId()));
    }

    @Override
    public void saveEvents(List<Event> events) {
        Objects.requireNonNull(cacheManager.getCache(EVENTS_CACHE)).clear();
        Objects.requireNonNull(cacheManager.getCache(EXIST_EVENT_CACHE)).clear();
        jpaEventRepository.saveAll(events.stream()
                .map(EventEntityMapper::toEntity)
                .toList());
    }
}
