package dev.byli.robot.archetype.infrastructure.springboot.controllers.handler;

import dev.byli.robot.archetype.core.domain.exception.ValidationException;
import dev.byli.robot.archetype.infrastructure.springboot.controllers.handler.dto.Error;
import dev.byli.robot.archetype.infrastructure.springboot.controllers.handler.dto.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;


@RestControllerAdvice
public class ControllerConfig {

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorResponse illegalArguments(ValidationException e) {
        return ErrorResponse.builder().error(Error.builder().code(BAD_REQUEST.toString())
                .message(e.getMessage()).build()).build();

    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ErrorResponse illegalArguments(Exception e) {
        return ErrorResponse.builder().error(Error.builder().code(BAD_REQUEST.toString())
                .message(e.getMessage()).build()).build();

    }
}
