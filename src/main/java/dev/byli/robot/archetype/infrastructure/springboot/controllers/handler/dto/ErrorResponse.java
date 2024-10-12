package dev.byli.robot.archetype.infrastructure.springboot.controllers.handler.dto;

import lombok.Builder;

@Builder
public class ErrorResponse {
    private Error error;
}
