package dev.byli.robot.archetype.infrastructure.springboot.controllers;

import dev.byli.robot.archetype.core.application.dto.SearchRequest;
import dev.byli.robot.archetype.core.application.dto.SearchResponse;
import dev.byli.robot.archetype.core.application.usecases.SearchUseCase;
import dev.byli.robot.archetype.entrypoints.controllers.SearchController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@Controller
@RequiredArgsConstructor
public class SearchControllerImpl implements SearchController {
    private final SearchUseCase searchUseCase;

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public SearchResponse search(@RequestParam("starts_at") ZonedDateTime start, @RequestParam("ends_at") ZonedDateTime end) {
        return searchUseCase.execute(SearchRequest.builder().startsAt(start).endsAt(end).build());
    }
}
