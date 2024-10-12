package dev.byli.robot.archetype.core.application.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class Error {
    private List<EventSummary> events;
    private String error;
}
