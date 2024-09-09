package dev.byli.robot.archetype.core;

import java.util.List;
import java.util.UUID;

public interface UseCase<I extends Dto, O extends Dto> {
    default O execute(I request) {
        throw new UnsupportedOperationException("Not implemented");
    }

    default List<O> execute() {
        throw new UnsupportedOperationException("Not implemented");
    }

    default O execute(Long id) {
        throw new UnsupportedOperationException("Not implemented");
    }

    default O execute(UUID id) {
        throw new UnsupportedOperationException("Not implemented");
    }

    default O execute(String id) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
