package com.feverup.challenge.infrastructure.springboot.crons;

import com.feverup.challenge.core.application.usecases.PullEventsUseCase;
import com.feverup.challenge.entrypoints.schedules.PullEventsCron;
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
