package dev.byli.robot.archetype.infrastructure.springboot.ports.repository.jpa;

import dev.byli.robot.archetype.infrastructure.springboot.ports.repository.jpa.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface JpaEventRepository extends JpaRepository<EventEntity, Long> {
    List<EventEntity> findByStartDateAfterAndEndDateBefore(ZonedDateTime start, ZonedDateTime end);

    boolean existsByProviderEventId(Long id);
}
