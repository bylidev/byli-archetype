package dev.byli.robot.archetype.infrastructure.springboot.crons;

import dev.byli.robot.archetype.core.application.usecases.PullEventsUseCase;
import dev.byli.robot.archetype.entrypoints.scheduled.PullEventsCron;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PullEventsCronImpl implements PullEventsCron {

    private final PullEventsUseCase pullEventsUseCase;

    @Scheduled(fixedRate = 1000)
    @Override
    public void pullEvents() {
        this.pullEventsUseCase.execute();
    }
}
