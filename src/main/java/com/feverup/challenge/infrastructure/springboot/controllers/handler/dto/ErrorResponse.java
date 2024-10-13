package com.feverup.challenge.infrastructure.springboot.controllers.handler.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ErrorResponse {
    private Error error;
}
