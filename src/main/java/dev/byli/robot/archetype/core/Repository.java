package dev.byli.robot.archetype.core;

import dev.byli.robot.archetype.core.domain.Domain;

import java.util.List;


public interface Repository<T extends Domain> {
    default T save(T entity) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    default T findById(Long id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    default void delete(T entity) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    default List<T> findAll() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
