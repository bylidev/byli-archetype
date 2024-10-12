package dev.byli.robot.archetype.core.application.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class Data {
    private List<EventSummary> events;
}
