package dev.byli.robot.archetype.infrastructure.springboot.ports.repository;

import dev.byli.robot.archetype.core.application.ports.EventRepository;
import dev.byli.robot.archetype.core.domain.model.Event;
import dev.byli.robot.archetype.infrastructure.springboot.ports.repository.jpa.JpaEventRepository;
import dev.byli.robot.archetype.infrastructure.springboot.ports.repository.jpa.mappers.EventEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.List;

import static dev.byli.robot.archetype.infrastructure.springboot.configs.CacheConfig.EVENTS_CACHE;
import static dev.byli.robot.archetype.infrastructure.springboot.configs.CacheConfig.EXIST_EVENT_CACHE;

@Component
@RequiredArgsConstructor
public class EventRepositoryImpl implements EventRepository {
    private final JpaEventRepository jpaEventRepository;
    private final CacheManager cacheManager;

    @Override
    @Cacheable(EVENTS_CACHE)
    public List<Event> getEvents(ZonedDateTime startsAt, ZonedDateTime endsAt) {
        return jpaEventRepository.findByStartDateAfterAndEndDateBefore(startsAt, endsAt).stream()
                .map(EventEntityMapper::toDomain).toList();
    }

    @Override
    @Cacheable(cacheNames = EXIST_EVENT_CACHE, key = "#event.providerEventId")
    public Boolean exists(Event event) {
        return jpaEventRepository.existsByProviderEventId(event.getProviderEventId());
    }

    @Override
    @CacheEvict(cacheNames = {EVENTS_CACHE, EXIST_EVENT_CACHE})
    public void saveEvents(List<Event> events) {
        cacheManager.getCache(EVENTS_CACHE).clear();
        cacheManager.getCache(EXIST_EVENT_CACHE).clear();
        jpaEventRepository.saveAll(events.stream()
                .map(EventEntityMapper::toEntity)
                .toList());
    }
}
