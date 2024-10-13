package dev.byli.robot.archetype.infrastructure.springboot.controllers.handler.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Error {
    private String code;
    private String message;
}
